package ufps.web.professionacare.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptRol;
import ufps.web.professionacare.backend.model.SsptUsuario;

public interface SsptUsuarioRepository extends CrudRepository<SsptUsuario, Integer> {

	public SsptUsuario findFirstByUsername(String username);

	public SsptUsuario findFirstByIdentificacion(String identificacion);
	
	public SsptUsuario findFirstByEmail(String email);
	
	@Query(value = "select su.* from sspt_usuario su \r\n"
			+ "left outer join sspt_solicitud_afiliacion ssa on (ssa.id_usuario_respuesta = su.id \r\n"
			+ "and DATE(ssa.fecha_registro) = current_date) \r\n"
			+ "where su.id_rol = 3 order by ssa.fecha_registro desc, su.id limit 1", nativeQuery = true)
	public SsptUsuario buscarDisponible();

	public List<SsptUsuario> findByRol(SsptRol rol);

	public boolean existsByUsernameIgnoreCaseAndIdentificacion(String username, String identificacion);

}
