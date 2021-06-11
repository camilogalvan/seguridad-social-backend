package ufps.web.professionacare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ufps.web.professionacare.backend.container.TiposIdentificacionApi;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/tipoDeIdentificacion/")
public class TipoIdentificacionController {

	@Autowired
	private SsptTipoIdentificacionService service;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("todos")
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
