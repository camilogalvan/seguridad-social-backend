package ufps.web.professionacare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.PlanApi;
import ufps.web.professionacare.backend.container.PlanEntradaApi;
import ufps.web.professionacare.backend.container.PlanesApi;
import ufps.web.professionacare.backend.model.SsptFile;
import ufps.web.professionacare.backend.model.SsptPlan;
import ufps.web.professionacare.backend.service.SsptFileService;
import ufps.web.professionacare.backend.service.impl.SsptPlanServiceImpl;
import ufps.web.professionacare.backend.util.ValidationException;

@RestController
@RequestMapping("/api/plan/")
public class PlanController {

	@Autowired
	private SsptPlanServiceImpl service;

	@Autowired
	private SsptFileService fileService;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("todos")
	public ResponseEntity<PlanesApi> getList() {

		PlanesApi api = new PlanesApi();

		try {
			api.setPlanes(service.listadoPlanes());
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("activos")
	public ResponseEntity<PlanesApi> getListActivos() {

		PlanesApi api = new PlanesApi();

		try {
			api.setPlanes(service.listadoPlanesActivos());
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("{id}")
	public ResponseEntity<PlanApi> getById(@PathVariable Integer id) {

		PlanApi api = new PlanApi();

		try {
			api.setPlan(service.buscarPorId(id));
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("cambiarEstado/{id}")
	public ResponseEntity<Boolean> cambiarEstado(@PathVariable Integer id) {

		Boolean api = false;

		try {
			SsptPlan plan = service.buscarPorId(id);
			plan.setEnable(!plan.getEnable());
			service.guardar(plan);
			api = true;
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping(value = "", consumes = { "multipart/form-data" })
	public ResponseEntity<PlanApi> save(@ModelAttribute PlanEntradaApi entrada) {

		PlanApi api = new PlanApi();

		try {

			SsptPlan plan = new SsptPlan();
			if (entrada.getId() != null) {
				plan = service.buscarPorId(entrada.getId());
				if (plan == null) {
					throw new Exception("El plan no existe.");
				}
			}

			plan.setTitulo(entrada.getTitulo());
			plan.setDescripcion(entrada.getDescripcion());
			plan.setColor(entrada.getColor());
			plan.setServicios(entrada.getServicios());
			plan.setPrecio(entrada.getPrecio());
			plan.setDescripcion(entrada.getDescripcion());
			plan.setEnable(entrada.getEnable());

			if (entrada.getFile() != null) {
				SsptFile mppFile = null;
				if (plan.getFile() != null) {
					mppFile = fileService.save(plan.getFile(), entrada.getFile());
				} else {
					mppFile = fileService.save(entrada.getFile());
				}
				plan.setFile(mppFile);
			}

			api.setPlan(service.guardar(plan));
		} catch (Exception e) {
			throw new ValidationException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(api, HttpStatus.OK);
	}

}
