package ufps.web.professionacare.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.enums.EstadoCliente;
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
		
		return c.findByidentificacion(cedula);
	}

	@Override
	public SsptCliente GetPorEstado(EstadoCliente e) {
		
		return c.findByEstadoCliente(e);
	}

	
	
}
