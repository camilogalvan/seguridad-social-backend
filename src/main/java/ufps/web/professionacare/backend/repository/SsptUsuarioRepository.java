package ufps.web.professionacare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptRol;
import ufps.web.professionacare.backend.model.SsptUsuario;

public interface SsptUsuarioRepository extends CrudRepository<SsptUsuario, Integer> {

	public SsptUsuario findFirstByUsername(String username);

	public SsptUsuario findFirstByIdentificacion(String identificacion);
	
	public SsptUsuario findFirstByEmail(String email);

	public List<SsptUsuario> findByRol(SsptRol rol);

	public boolean existsByUsernameIgnoreCaseAndIdentificacion(String username, String identificacion);

}
