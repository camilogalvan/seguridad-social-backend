package ufps.web.professionacare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.ClienteApi;
import ufps.web.professionacare.backend.container.ClienteEntrada;
import ufps.web.professionacare.backend.container.EmpresaApi;
import ufps.web.professionacare.backend.container.EmpresaEntradaApi;
import ufps.web.professionacare.backend.enums.EstadoCliente;
import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptEmpresa;
import ufps.web.professionacare.backend.model.SsptFile;
import ufps.web.professionacare.backend.model.SsptTipoCliente;
import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;
import ufps.web.professionacare.backend.service.SsptClienteService;
import ufps.web.professionacare.backend.service.SsptTipoClienteService;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController {
	
	@Autowired
	private SsptClienteService service;
	
	@Autowired
	private SsptTipoIdentificacionService tipoIdentificacionService;
	
	@Autowired
	private SsptTipoClienteService tipoClienteService;
	
	@GetMapping("todos")
	public List<SsptCliente> getAll() {
		
		return service.Get();
		
	}
	
	/**@PostMapping("save")
	@ResponseStatus(HttpStatus.CREATED)
	public SsptCliente save(@RequestBody SsptClienteEntrada cliente) {
		
		cliente.prePersist();
		return service.guardar(cliente);
	}**/
	
	@PostMapping(value = "save")
	public ClienteApi save(@RequestBody ClienteEntrada entrada) {
		ClienteApi api = new ClienteApi();

		SsptTipoIdentificacion tipoId = tipoIdentificacionService.buscarPorId(entrada.getIdTipoIdentificacion());
		SsptTipoCliente tipoCliente = tipoClienteService.buscarPorId(entrada.getIdTipoCliente());

		if (tipoId == null || tipoCliente == null) {
			return null;
		}
		
		SsptCliente client = new SsptCliente();
		
		client.setNombre1(entrada.getNombre1());
		client.setNombre2(entrada.getNombre2());
		client.setApellido1(entrada.getApellido1());
		client.setApellido2(entrada.getApellido2());
		client.setCorreo(entrada.getCorreo());
		client.setTelefono(entrada.getTelefono());
		client.setDireccion(entrada.getDireccion());
		client.setIdentificacion(entrada.getIdentificacion());

		client.setTipoIdentificacion(tipoId);	
		client.setTipoCliente(tipoCliente);		

		return api;
	}
	
//	@PostMapping("save")
//	public SsptCliente save(@RequestBody ClienteEntrada entrada) {
//		
//
//		SsptCliente client = new SsptCliente();
//		
//		SsptTipoIdentificacion tipoId = tipoIdentificacionService.buscarPorId(entrada.getIdTipoIdentificacion());
//		
//		if (tipoId == null) {
//			return null;
//		}
//
//		client.setNombre1(entrada.getNombre1());
//		client.setNombre2(entrada.getNombre2());
//		client.setApellido1(entrada.getApellido1());
//		client.setApellido2(entrada.getApellido2());
//		client.setCorreo(entrada.getCorreo());
//		client.setTelefono(entrada.getTelefono());
//		client.setDireccion(entrada.getDireccion());
//		client.setIdentificacion(entrada.getIdentificacion());
//		
//		
//		
////		client.setTipoIdentificacion(new SsptTipoIdentificacion("cedula de ciudadania", "CC"));
//		//client.setTipoCliente(new SsptTipoCliente(entrada.getTipoCliente(), "Un cliente despendfiente" ));
////		client.prePersist();
//
//		
//
//		//client = service.save(client);
//
//		//api.setEmpresa(proveedorSearch);
//
//		return service.guardar(client);
//	}
	@GetMapping("porId/{id}")
	public SsptCliente GetPorId(@PathVariable int id) {
		
		return service.GetPorId(id);
		
	}
	
	@GetMapping("porCedula/{cedula}")
	public SsptCliente GetPorCedula(@PathVariable String cedula) {
		
		return service.GetPorCedula(cedula);
	}
	
	
	@GetMapping("porEstado")
	public SsptCliente GetPorEstado(@RequestBody EstadoCliente e) {
		
		return service.GetPorEstado(e);
	}

}
