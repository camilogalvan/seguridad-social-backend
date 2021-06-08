package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptPlan;

public interface SsptPlanService {

	public SsptPlan guardar(SsptPlan plan);

	public SsptPlan buscarPorId(Integer id);

	public List<SsptPlan> listadoPlanesActivos();

	public List<SsptPlan> listadoPlanes();
	
	public SsptPlan buscarPorTitulo(String title);

}
