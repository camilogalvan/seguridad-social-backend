package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptUsuario;

public interface SsptUsuarioRepository extends CrudRepository<SsptUsuario, Integer> {

	public SsptUsuario findFirstByUsername(String username);

	public SsptUsuario findFirstByIdentificacion(String identificacion);

}
