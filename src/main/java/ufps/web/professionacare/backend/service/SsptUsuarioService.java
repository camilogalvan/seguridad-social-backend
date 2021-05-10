package ufps.web.professionacare.backend.service;

import ufps.web.professionacare.backend.model.SsptUsuario;

public interface SsptUsuarioService {

	public SsptUsuario buscarPorIdentificacion(String identificacion);

	public SsptUsuario buscarPorUsername(String username);

}
