package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;
import ufps.web.professionacare.backend.repository.SsptTipoIdentificacionRepository;
import ufps.web.professionacare.backend.service.SsptTipoIdentificacionService;

@Service
@Transactional
public class SsptTipoIdentificacionServiceImpl implements SsptTipoIdentificacionService {

	@Autowired
	private SsptTipoIdentificacionRepository repository;

	@Override
	public List<SsptTipoIdentificacion> buscarTodos() {
		return (List<SsptTipoIdentificacion>) repository.findAll();
	}

	@Override
	public SsptTipoIdentificacion buscarPorTipo(String tipo) {
		return repository.findFirstByTipo(tipo);
	}

	@Override
	public SsptTipoIdentificacion buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
