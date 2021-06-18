package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptActividadEconomica;

public interface SsptActividadEconomicaService {
	
	public List<SsptActividadEconomica> listarTodos();
	
	public SsptActividadEconomica buscarPorId(Integer id);

}
