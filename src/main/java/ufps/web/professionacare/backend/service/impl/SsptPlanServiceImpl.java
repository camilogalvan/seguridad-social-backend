package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptPlan;
import ufps.web.professionacare.backend.repository.SsptPlanRepository;
import ufps.web.professionacare.backend.service.SsptPlanService;

@Service
@Transactional
public class SsptPlanServiceImpl implements SsptPlanService {

	@Autowired
	private SsptPlanRepository repository;

	@Override
	public SsptPlan guardar(SsptPlan plan) {
		return repository.save(plan);
	}

	@Override
	public SsptPlan buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<SsptPlan> listadoPlanesActivos() {
		return repository.findByEnableOrderByPrecio(true);
	}

	@Override
	public List<SsptPlan> listadoPlanes() {
		return (List<SsptPlan>) repository.findAllByOrderByIdAsc();
	}

	@Override
	public SsptPlan buscarPorTitulo(String titulo) {
		
		return repository.findBytitulo(titulo);
	}

	
}
