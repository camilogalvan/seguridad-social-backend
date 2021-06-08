package ufps.web.professionacare.backend.controller;

import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;
import ufps.web.professionacare.backend.service.impl.SsptPlanServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.SolicitudEntrada;
import ufps.web.professionacare.backend.container.UsuarioApi;
import ufps.web.professionacare.backend.model.*;
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudAfiliacionController {

	@Autowired
	public SsptSolicitudAfiliacionService serv;
	
	@Autowired
	public ClienteController cli;
	
	@Autowired
	public UsuarioController us;
	
	@Autowired
	public PlanController plan;
	
	@Autowired
	public SsptPlanServiceImpl impl;
	
	@GetMapping("/findAll")
	public List<SsptSolicitudAfiliacion> index(){
		
		return serv.Get();
	}
	
	@GetMapping("/findById/{id}")
	public SsptSolicitudAfiliacion GetId1(@PathVariable int id) {
		System.out.println("id1:"+ id);
		
		return null; //serv.GetPorId(id);
	}
	
	@GetMapping("/findById")
	public SsptSolicitudAfiliacion GetId2(@RequestBody int id) {
		System.out.println("id2:"+ id);
		return null; //serv.GetPorId(id);
	}
	
	@PostMapping("/save")
	public SsptSolicitudAfiliacion guardar(@RequestBody SolicitudEntrada sol) {
		
		SsptSolicitudAfiliacion s= new SsptSolicitudAfiliacion();
		
		s.setObservaciones(sol.getObservaciones());
		s.setSsptCliente(cli.GetPorCedula(sol.getCliente()));	
		s.setSsptUsuario( us.getUsuario(sol.getUsuario()).getUsuario());
		s.setSsptPlan(impl.buscarPorId(sol.getPlan()));
		
		
		return serv.guardar(s);
	}
	
	@PostMapping("/responder/{id}/{rt}")
	public SsptSolicitudAfiliacion responder(@PathVariable int id, @PathVariable String rt) {
		
		SsptSolicitudAfiliacion soli = serv.GetPorId(id);
		
		soli.setRespuesta(rt);
		
		return serv.guardar(soli);
	}
	
}
