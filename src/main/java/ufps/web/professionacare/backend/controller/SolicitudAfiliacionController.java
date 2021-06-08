package ufps.web.professionacare.backend.controller;

import ufps.web.professionacare.backend.service.SsptClienteService;
import ufps.web.professionacare.backend.service.SsptFileService;
import ufps.web.professionacare.backend.service.SsptMunicipioService;
import ufps.web.professionacare.backend.service.SsptPlanService;
import ufps.web.professionacare.backend.service.SsptSolicitudAfiliacionService;
import ufps.web.professionacare.backend.service.SsptTipoClienteService;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;
import ufps.web.professionacare.backend.service.SsptUsuarioService;
import ufps.web.professionacare.backend.service.impl.SsptPlanServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.SolicitudEntradaApi;
import ufps.web.professionacare.backend.container.UsuarioApi;
import ufps.web.professionacare.backend.model.*;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudAfiliacionController {

	@Autowired
	public SsptSolicitudAfiliacionService service;
	
	@Autowired
	public SsptClienteService clienteService;
	
	@Autowired
	public SsptUsuarioService usuarioService;
	
	@Autowired
	public SsptPlanService planService;
	
	@Autowired
	private SsptTipoIdentificacionService tipoIdentificacionService;
	
	@Autowired
	private SsptTipoClienteService tipoClienteService;
	
	@Autowired 
	private SsptMunicipioService municipioser;

	@Autowired
	private SsptFileService fileService;
	
	@GetMapping("/findAll")
	public List<SsptSolicitudAfiliacion> index(){
		
		return service.Get();
	}

	@PostMapping(value = "/save/", consumes = { "multipart/form-data" })
	public SsptSolicitudAfiliacion guardar(@ModelAttribute SolicitudEntradaApi entrada) {
		
		System.out.println("guardar solicitud");
		
		// Verificar si ya existe
		SsptCliente cliente = clienteService.GetPorCedula(entrada.getIdentificacion());

		SsptTipoIdentificacion tipoId = tipoIdentificacionService.buscarPorId(entrada.getIdTipoIdentificacion());
		SsptTipoCliente tipoCliente = tipoClienteService.buscarPorId(entrada.getIdTipoCliente());
		SsptMunicipio municipio = municipioser.getPorId(entrada.getIdMunicipio());
		
		SsptPlan tipoPlan = planService.buscarPorId(entrada.getIdTipoPlan());

		if (cliente == null) {
			cliente = new SsptCliente();

			cliente.setNombre1(entrada.getNombre1());
			cliente.setNombre2(entrada.getNombre2());
			cliente.setApellido1(entrada.getApellido1());
			cliente.setApellido2(entrada.getApellido2());
			cliente.setIdentificacion(entrada.getIdentificacion());
			cliente.setTipoIdentificacion(tipoId);	
			cliente.setTipoCliente(tipoCliente);	

			cliente.setCorreo(entrada.getCorreo());
			cliente.setTelefono(entrada.getTelefono());
			cliente.setDireccion(entrada.getDireccion());
			cliente.setMunicipio(municipio);
			
			clienteService.guardar(cliente);
			
		}
		
		// Registrar solicitud		
		SsptSolicitudAfiliacion solicitud = new SsptSolicitudAfiliacion();
		
		solicitud.setObservaciones(entrada.getObservaciones());
		solicitud.setSsptCliente(cliente);
		solicitud.setSsptPlan(tipoPlan);		
		
		// Registrar soportes
		Set<SsptSoporteAfiliacion> soportes = new HashSet<>();
		if (entrada.getFile() != null) {
			SsptFile mppFile =fileService.save(entrada.getFile());
			if (mppFile != null) {
				SsptSoporteAfiliacion soporteCedula = new SsptSoporteAfiliacion();
				
				soporteCedula.setDescripcion("Soporte de Cédula");
				soporteCedula.setFile(mppFile);
				soporteCedula.setSolicitud(solicitud);
				
				soportes.add(soporteCedula);
			}		
		}
		solicitud.setSoportes(soportes);		
		
		return service.guardar(solicitud);
	}
	
	@PostMapping("/responder/{id}/{rt}")
	public SsptSolicitudAfiliacion responder(@PathVariable int id, @PathVariable String rt) {
		
		SsptSolicitudAfiliacion soli = service.GetPorId(id);
		
		soli.setRespuesta(rt);
		
		return service.guardar(soli);
	}
	
}
