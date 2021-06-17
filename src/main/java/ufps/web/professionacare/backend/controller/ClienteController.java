package ufps.web.professionacare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufps.web.professionacare.backend.container.ClienteEntrada;
import ufps.web.professionacare.backend.container.ClientesApi;
import ufps.web.professionacare.backend.container.ConsultaOrdenApi;
import ufps.web.professionacare.backend.enums.EstadoCliente;
import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptMunicipio;
import ufps.web.professionacare.backend.model.SsptTipoCliente;
import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;
import ufps.web.professionacare.backend.service.SsptClienteService;
import ufps.web.professionacare.backend.service.SsptMunicipioService;
import ufps.web.professionacare.backend.service.SsptOrdenServicioService;
import ufps.web.professionacare.backend.service.SsptTipoClienteService;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController {

	@Autowired
	private SsptClienteService service;

	@Autowired
	private SsptOrdenServicioService ordenesService;

	@Autowired
	private SsptTipoIdentificacionService tipoIdentificacionService;

	@Autowired
	private SsptTipoClienteService tipoClienteService;

	@Autowired
	private SsptMunicipioService municipioser;

	@GetMapping("todos")
	public ClientesApi getAll() {

		ClientesApi api = new ClientesApi();
		api.setClientes(service.Get());
		return api;

	}

	@PostMapping(value = "save")
	public SsptCliente save(@RequestBody ClienteEntrada entrada) {
		// ClienteApi api = new ClienteApi();

		SsptTipoIdentificacion tipoId = tipoIdentificacionService.buscarPorId(entrada.getIdTipoIdentificacion());
		SsptTipoCliente tipoCliente = tipoClienteService.buscarPorId(entrada.getIdTipoCliente());
		SsptMunicipio municipio = municipioser.getPorId(entrada.getIdMunicipio());

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
		client.setMunicipio(municipio);

		return service.guardar(client);
	}

	@GetMapping("porId/{id}")
	public SsptCliente GetPorId(@PathVariable int id) {
		return service.GetPorId(id);
	}

	@GetMapping("porCedula/{cedula}")
	public ConsultaOrdenApi GetPorCedula(@PathVariable String cedula) {
		ConsultaOrdenApi api = new ConsultaOrdenApi();
		api.setCliente(service.GetPorCedula(cedula));
		api.setOrden(ordenesService.getByCliente(api.getCliente()));
		return api;
	}

//	@GetMapping("porEstado")
//	public SsptCliente GetPorEstado(@RequestBody EstadoCliente e) {
//		return service.GetPorEstado(e);
//	}

	@PostMapping("cambiarEstado/{id}/{estado}")
	public SsptCliente CambiarEstado(@PathVariable int id, @PathVariable String estado) {
		SsptCliente cli = this.GetPorId(id);
		cli.setEstadoCliente(EstadoCliente.valueOf(estado));
		return service.guardar(cli);
	}

}
