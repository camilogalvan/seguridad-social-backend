package ufps.web.professionacare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import ufps.web.professionacare.backend.container.EmpresaApi;
import ufps.web.professionacare.backend.container.EmpresaEntradaApi;
import ufps.web.professionacare.backend.model.SsptEmpresa;
import ufps.web.professionacare.backend.model.SsptFile;
import ufps.web.professionacare.backend.service.SsptEmpresaService;
import ufps.web.professionacare.backend.service.SsptFileService;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/empresa/")
public class EmpresaController {

	@Autowired
	private SsptEmpresaService service;

	@Autowired
	private SsptFileService fileService;

	@GetMapping("actual")
	public ResponseEntity<SsptEmpresa> getEmpresa() {

		SsptEmpresa api = null;

		try {
			api = service.getEmpresaActual();
			if (api != null) {
				return new ResponseEntity<>(api, HttpStatus.OK);
			}
			throw new Exception("");
		} catch (HttpClientErrorException e) {
			throw new ValidationException(e.getResponseBodyAsString(), e, e.getStatusCode());
		} catch (Exception e) {
			throw new ValidationException("No se encuentra registrada ninguna empresa.", e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "", consumes = { "multipart/form-data" })
	public EmpresaApi save(@ModelAttribute EmpresaEntradaApi entrada) {
		EmpresaApi api = new EmpresaApi();

		SsptEmpresa proveedorSearch = service.getEmpresaActual();

		proveedorSearch.setNombre(entrada.getNombre());

		proveedorSearch.setDireccion(entrada.getDireccion());
		proveedorSearch.setEmail(entrada.getEmail());
		proveedorSearch.setTelefono(entrada.getTelefono());
		proveedorSearch.setEnable(entrada.getEnable());

		if (entrada.getFile() != null) {
			SsptFile mppFile = null;
			if (proveedorSearch.getFile() != null) {
				mppFile = fileService.save(proveedorSearch.getFile(), entrada.getFile());
			} else {
				mppFile = fileService.save(entrada.getFile());
			}
			proveedorSearch.setFile(mppFile);
		}

		proveedorSearch = service.guardar(proveedorSearch);

		api.setEmpresa(proveedorSearch);

		return api;
	}

}
