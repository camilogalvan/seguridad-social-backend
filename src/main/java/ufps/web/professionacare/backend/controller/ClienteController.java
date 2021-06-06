package ufps.web.professionacare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.enums.EstadoCliente;
import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.service.SsptClienteService;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController {
	
	@Autowired
	private SsptClienteService service;
	
	@GetMapping("todos")
	public List<SsptCliente> getAll() {
		
		return service.Get();
		
	}
	
	@PostMapping("save")
	@ResponseStatus(HttpStatus.CREATED)
	public SsptCliente save(@RequestBody SsptCliente cliente) {
		
		cliente.prePersist();
		return service.guardar(cliente);
	}
	
	@GetMapping("porId/{id}")
	public SsptCliente GetPorId(@PathVariable int id) {
		
		return service.GetPorId(id);
		
	}
	
	@GetMapping("porCedula/{cedula}")
	public SsptCliente GetPorCedula(@PathVariable String cedula) {
		
		return service.GetPorCedula(cedula);
	}
	
	@GetMapping("porNombreCompleto/{nombreCompleto}")
	public SsptCliente GetPorNombre(@PathVariable String nombre) {
		
		return service.GetPorNombreCompleto(nombre);
	}
	
	
	@GetMapping("porEstado")
	public SsptCliente GetPorEstado(@RequestBody EstadoCliente e) {
		
		return service.GetPorEstado(e);
	}

}
