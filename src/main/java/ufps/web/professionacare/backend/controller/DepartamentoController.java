package ufps.web.professionacare.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.model.SsptDepartamento;
import ufps.web.professionacare.backend.service.SsptDepartamentoService;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/departamento/")
public class DepartamentoController {
	
	@Autowired
	private SsptDepartamentoService service;
	
	@GetMapping("todos")
	public ResponseEntity<List<SsptDepartamento>> getDepartamentos() {

		List<SsptDepartamento> api = new ArrayList<SsptDepartamento>();

		try {
			api = service.getTodos();
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

}
