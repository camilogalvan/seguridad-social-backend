package ufps.web.professionacare.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;

@Controller
@RequestMapping("/api/reportes/")
public class ReportesController {
	
	@Autowired
	private SsptSolicitudAfiliacionService service;
	
	@GetMapping("solicitudes")
	public String informeGeneral(Model model, @RequestParam String fechaInicio, @RequestParam String fechaFinal, @RequestParam String estado) {

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
		List<SsptSolicitudAfiliacion> solicitudes = service.filtradoReporte(estado, dateInicio, dateFinal);
		
		model.addAttribute("solicitudes", solicitudes);		
		return "reporte-solicitud";
	}

}