package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptRol;

public interface SsptRolService {

	public List<SsptRol> buscarTodos();

	public SsptRol buscarPorRol(String rol);

	public SsptRol buscarPorId(Integer id);

}
