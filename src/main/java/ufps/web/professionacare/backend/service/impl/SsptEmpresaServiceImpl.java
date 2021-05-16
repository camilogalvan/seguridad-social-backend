package ufps.web.professionacare.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptEmpresa;
import ufps.web.professionacare.backend.repository.SsptEmpresaRepository;
import ufps.web.professionacare.backend.service.SsptEmpresaService;

@Service
@Transactional
public class SsptEmpresaServiceImpl implements SsptEmpresaService {
	
	@Autowired
	private SsptEmpresaRepository repository;

	@Value("${nit_empresa}")
	private String nitEmpresa;

	@Override
	public SsptEmpresa getEmpresaActual() {
		try {
			return repository.findFirstByNit(nitEmpresa);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public SsptEmpresa guardar(SsptEmpresa entity) {
		try {
			return repository.save(entity);
		} catch (Exception e) {
		}
		return null;
	}

}
