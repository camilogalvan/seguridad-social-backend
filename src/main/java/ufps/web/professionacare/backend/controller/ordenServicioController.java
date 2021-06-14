package ufps.web.professionacare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.OrdenEntrada;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;
import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;
import ufps.web.professionacare.backend.service.impl.SsptOrdenServicioServiceImpl;
import ufps.web.professionacare.backend.service.impl.SsptSolicitudAfiliacionServiceImpl;

@RestController
@RequestMapping("/api/ordenes/")
public class ordenServicioController {

	@Autowired
	SsptOrdenServicioServiceImpl service;
	
	@Autowired
	SsptSolicitudAfiliacionServiceImpl ser;
	
	@PostMapping(value = "save")
	public SsptOrdenServicio save(@RequestBody OrdenEntrada entrada) {
		
		SsptOrdenServicio orden = new SsptOrdenServicio();
		
		SsptSolicitudAfiliacion afiliacion= ser.GetPorId(entrada.getIdAfiliacion());
		if(afiliacion!=null) {
		orden.setId_afiliacion(afiliacion);	
		orden.setPrecio(orden.getId_afiliacion().getSsptPlan().getPrecio());
		orden.prePersist();
		return service.save(orden);
		}
		
		else {
			return null;
		}
	}
	
	@GetMapping("getId/{id}")
	public SsptOrdenServicio getById(@PathVariable int id) {
		
		return service.getById(id);
	}
	
	@GetMapping("all")
	public List<SsptOrdenServicio> getAll(){
		
		return service.getAll();
	}
	
}
