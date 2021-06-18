package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.repository.SsptClienteRepository;
import ufps.web.professionacare.backend.service.SsptClienteService;

@Service
@Transactional
public class SsptClienteServiceImpl implements SsptClienteService {

	@Autowired
	private SsptClienteRepository c;

	@Override
	public SsptCliente GetPorId(int id) {

		return c.findById(id).orElse(null);
	}

	@Override
	public List<SsptCliente> Get() {

		return (List<SsptCliente>) c.findAll();
	}

	@Override
	public SsptCliente guardar(SsptCliente cliente) {

		return c.save(cliente);
	}

	@Override
	public SsptCliente GetPorCedula(String cedula) {

		return c.findByIdentificacion(cedula);
	}
	
	@Override
	public SsptCliente buscarPorCorreo(String correo) {
		return c.findByCorreo(correo);
	}

}
