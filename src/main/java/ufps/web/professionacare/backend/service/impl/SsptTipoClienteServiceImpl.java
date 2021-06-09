package ufps.web.professionacare.backend.service.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufps.web.professionacare.backend.model.SsptTipoCliente;
import ufps.web.professionacare.backend.repository.SsptTipoClienteRepository;
import ufps.web.professionacare.backend.service.SsptTipoClienteService;

@Service
@Transactional
public class SsptTipoClienteServiceImpl implements SsptTipoClienteService {
	
	@Autowired
	private SsptTipoClienteRepository repository;

	@Override
	public SsptTipoCliente buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<SsptTipoCliente> get() {
		
		return (List<SsptTipoCliente>) repository.findAll();
	}
	
	

}
