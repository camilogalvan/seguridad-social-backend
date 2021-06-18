package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptRol;
import ufps.web.professionacare.backend.model.SsptUsuario;

public interface SsptUsuarioService {

	public SsptUsuario buscarPorIdentificacion(String identificacion);

	public SsptUsuario buscarPorId(Integer id);

	public SsptUsuario buscarPorUsername(String username);
	
	public List<SsptUsuario> buscarTodos();
			
	public List<SsptUsuario> buscarPorRol(SsptRol rol);

	public SsptUsuario guardar(SsptUsuario entity);
		
	public SsptUsuario buscarPorEmail(String email);
		
	public boolean existePorUsernameEidentificacion(String username, String identificacion);

}
