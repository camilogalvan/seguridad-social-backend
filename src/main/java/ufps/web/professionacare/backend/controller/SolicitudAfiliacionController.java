package ufps.web.professionacare.backend.controller;

import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.model.*;
@RestController
@RequestMapping("/api/Solicitudes")
public class SolicitudAfiliacionController {

	@Autowired
	public SsptSolicitudAfiliacionService serv;
	
	@GetMapping("/FindAll")
	public List<SsptSolicitudAfiliacion> index(){
		
		return serv.Get();
	}
	
	@GetMapping("/FindById/{id}")
	public SsptSolicitudAfiliacion GetId1(@PathVariable int id) {
		System.out.println("id1:"+ id);
		
		return null; //serv.GetPorId(id);
	}
	
	@GetMapping("/FindById")
	public SsptSolicitudAfiliacion GetId2(@RequestBody int id) {
		System.out.println("id2:"+ id);
		return null; //serv.GetPorId(id);
	}
	
	@GetMapping("/save")
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion sol) {
		
		return serv.guardar(sol);
	}
	
}
