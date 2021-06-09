package ufps.web.professionacare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ufps.web.professionacare.backend.container.TiposDeClienteApi;
import ufps.web.professionacare.backend.container.TiposIdentificacionApi;
import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;
import ufps.web.professionacare.backend.service.impl.SsptTipoClienteServiceImpl;
import ufps.web.professionacare.backend.service.impl.SsptTipoIdentificacionServiceImpl;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/tipoDeClientes/")
public class TipoIdentificacionController {

	@Autowired
	private SsptTipoIdentificacionServiceImpl service;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("todoss")
	public ResponseEntity<TiposIdentificacionApi> getTodos() {
		TiposIdentificacionApi api = new TiposIdentificacionApi();
		try {
			api.setTiposIdentificacion(service.buscarTodos());
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
	
}
