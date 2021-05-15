package ufps.web.professionacare.backend.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

	@GetMapping("/")
	public String inicio(HttpServletRequest request) {

		return "API REST SEGURIDAD SOCIAL PARA TODOS FROM IP(" + request.getRemoteAddr() + ")";
	}
	
	@GetMapping("/validate")
	public boolean validate(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		return principal != null;
	}

}
