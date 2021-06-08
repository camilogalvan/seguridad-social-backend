package ufps.web.professionacare.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptMunicipio;
import ufps.web.professionacare.backend.repository.SsptMunicipioRepository;
import ufps.web.professionacare.backend.service.SsptMunicipioService;

@Service
@Transactional
public class SsptMunicipioServiceImpl implements SsptMunicipioService{
	
	@Autowired
	SsptMunicipioRepository s;

	@Override
	public SsptMunicipio getPorId(int id) {
		// TODO Auto-generated method stub
		return s.findById(id).orElse(null);
	}

	
	
}
