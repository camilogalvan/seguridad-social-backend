package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptDepartamento;
import ufps.web.professionacare.backend.repository.SsptDepartamentoRepository;
import ufps.web.professionacare.backend.service.SsptDepartamentoService;

@Service
@Transactional
public class SsptDepartamentoServiceImpl implements SsptDepartamentoService {
	
	@Autowired
	private SsptDepartamentoRepository repository;

	@Override
	public List<SsptDepartamento> getTodos() {
		return (List<SsptDepartamento>) repository.findAll();
	}

}
