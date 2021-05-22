package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;

public interface SsptTipoIdentificacionService {

	public List<SsptTipoIdentificacion> buscarTodos();

	public SsptTipoIdentificacion buscarPorTipo(String tipo);

	public SsptTipoIdentificacion buscarPorId(Integer id);

}
