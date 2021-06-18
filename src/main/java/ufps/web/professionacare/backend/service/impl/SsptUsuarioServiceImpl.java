package ufps.web.professionacare.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ufps.web.professionacare.backend.model.SsptRol;
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
		return repository.findFirstByIdentificacion(identificacion);
	}
	
	@Override
	public SsptUsuario buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public SsptUsuario buscarPorUsername(String username) {
		return repository.findFirstByUsername(username);
	}

	@Override
	public List<SsptUsuario> buscarTodos() {
		return (List<SsptUsuario>) repository.findAll();
	}

	@Override
	public List<SsptUsuario> buscarPorRol(SsptRol rol) {
		return repository.findByRol(rol);
	}

	@Override
	public SsptUsuario guardar(SsptUsuario entity) {
		return repository.save(entity);
	}

	@Override
	public SsptUsuario buscarPorEmail(String email) {
		return repository.findFirstByEmail(email);
	}

	@Override
	public boolean existePorUsernameEidentificacion(String username, String identificacion) {
		return repository.existsByUsernameIgnoreCaseAndIdentificacion(username, identificacion);
	}

}
