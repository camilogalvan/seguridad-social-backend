package ufps.web.professionacare.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptUsuario;
import ufps.web.professionacare.backend.repository.SsptUsuarioRepository;
import ufps.web.professionacare.backend.service.SsptUsuarioService;

@Service
@Transactional
public class SsptUsuarioServiceImpl implements SsptUsuarioService {
	
	@Autowired
	private SsptUsuarioRepository repository;

	@Override
	public SsptUsuario buscarPorIdentificacion(String identificacion) {
		try {
			return repository.findFirstByIdentificacion(identificacion);
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public SsptUsuario buscarPorUsername(String username) {
		try {
			return repository.findFirstByUsername(username);
		} catch (Exception e) {
		}
		return null;
	}

}
