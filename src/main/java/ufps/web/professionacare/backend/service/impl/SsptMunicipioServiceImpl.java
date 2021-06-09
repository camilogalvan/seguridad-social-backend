package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptDepartamento;
import ufps.web.professionacare.backend.model.SsptMunicipio;
import ufps.web.professionacare.backend.repository.SsptDepartamentoRepository;
import ufps.web.professionacare.backend.repository.SsptMunicipioRepository;
import ufps.web.professionacare.backend.service.SsptMunicipioService;

@Service
@Transactional
public class SsptMunicipioServiceImpl implements SsptMunicipioService {

	@Autowired
	private SsptMunicipioRepository s;
	
	@Autowired
	private SsptDepartamentoRepository departamentoRepository;

	@Override
	public SsptMunicipio getPorId(int id) {
		return s.findById(id).orElse(null);
	}

	@Override
	public List<SsptMunicipio> getPorDepartamento(int id) {
		
		SsptDepartamento dep = departamentoRepository.findById(id).orElse(null);
		
		return s.findByDepartamento(dep);
	}

}
