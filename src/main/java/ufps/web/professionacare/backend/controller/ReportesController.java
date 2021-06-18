package ufps.web.professionacare.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;
import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.model.SsptUsuario;
import ufps.web.professionacare.backend.service.SsptClienteService;
import ufps.web.professionacare.backend.service.SsptOrdenServicioService;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;
import ufps.web.professionacare.backend.service.SsptUsuarioService;

@Controller
@RequestMapping("/api/reportes/")
public class ReportesController {
	
	@Autowired
	private SsptSolicitudAfiliacionService service;
	
	@Autowired
	private SsptClienteService clienteService;
	
	@Autowired
	private SsptOrdenServicioService ordenService;

	@Autowired
	private SsptUsuarioService usuarioService;
	
	@GetMapping("solicitudes")
	public String informeGeneralSolicitudes(Model model, @RequestParam String fechaInicio, @RequestParam String fechaFinal, @RequestParam String estado) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SsptUsuario usuarioRta = usuarioService.buscarPorUsername(authentication.getName());
		Integer idAsesor = null;
		if (usuarioRta.getRol().getRol().equals("ROLE_USER")) {
			idAsesor = usuarioRta.getId();
		}
		Date dateInicio = null;
		Date dateFinal = null;
		try {
			dateInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (Exception e) {
		}
		try {
			dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinal);
		} catch (Exception e) {
		}
		List<SsptSolicitudAfiliacion> solicitudes = service.filtradoReporte(estado, dateInicio, dateFinal, idAsesor);
		
		model.addAttribute("solicitudes", solicitudes);		
		return "reporte-solicitud";
	}
	
	@GetMapping("clientes")
	public String informeGeneralClientes(Model model, @RequestParam String fechaInicio, @RequestParam String fechaFinal, @RequestParam String estado) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SsptUsuario usuarioRta = usuarioService.buscarPorUsername(authentication.getName());
		Integer idAsesor = null;
		if (usuarioRta.getRol().getRol().equals("ROLE_USER")) {
			idAsesor = usuarioRta.getId();
		}
		Date dateInicio = null;
		Date dateFinal = null;
		try {
			dateInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (Exception e) {
		}
		try {
			dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinal);
		} catch (Exception e) {
		}
		List<SsptCliente> solicitudes = clienteService.filtradoReporte(estado, dateInicio, dateFinal, idAsesor);
		
		model.addAttribute("clientes", solicitudes);	
			
		return "reporte-clientes";
	}
	
	@GetMapping("ordenes")
	public String informeGeneralOrdenes(Model model, @RequestParam String fechaInicio, @RequestParam String fechaFinal, @RequestParam String estado) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SsptUsuario usuarioRta = usuarioService.buscarPorUsername(authentication.getName());
		Integer idAsesor = null;
		if (usuarioRta.getRol().getRol().equals("ROLE_USER")) {
			idAsesor = usuarioRta.getId();
		}
		Date dateInicio = null;
		Date dateFinal = null;
		try {
			dateInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (Exception e) {
		}
		try {
			dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinal);
		} catch (Exception e) {
		}
		List<SsptOrdenServicio> solicitudes = ordenService.filtradoReporte(estado, dateInicio, dateFinal, idAsesor);
		
		System.out.println(solicitudes!= null ? solicitudes.size():"cero");
		model.addAttribute("ordenes", solicitudes);	
			
		return "reporte-ordenes";
	}

}
