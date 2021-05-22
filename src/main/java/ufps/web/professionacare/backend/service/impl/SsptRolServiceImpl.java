package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptRol;
import ufps.web.professionacare.backend.repository.SsptRolRepository;
import ufps.web.professionacare.backend.service.SsptRolService;

@Service
@Transactional
public class SsptRolServiceImpl implements SsptRolService {

	@Autowired
	private SsptRolRepository repository;

	@Override
	public List<SsptRol> buscarTodos() {
		return (List<SsptRol>) repository.findAll();
	}

	@Override
	public SsptRol buscarPorRol(String rol) {
		return repository.findFirstByRol(rol);
	}

	@Override
	public SsptRol buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
