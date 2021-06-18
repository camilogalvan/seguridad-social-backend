package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptActividadEconomica;
import ufps.web.professionacare.backend.repository.SsptActividadEconomicaRepository;
import ufps.web.professionacare.backend.service.SsptActividadEconomicaService;

@Service
@Transactional
public class SsptActividadEconomicaServiceImpl implements SsptActividadEconomicaService {
	
	@Autowired
	private SsptActividadEconomicaRepository repository;

	@Override
	public List<SsptActividadEconomica> listarTodos() {
		return (List<SsptActividadEconomica>) repository.findAll();
	}

	@Override
	public SsptActividadEconomica buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
