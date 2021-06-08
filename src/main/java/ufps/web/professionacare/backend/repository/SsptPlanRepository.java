package ufps.web.professionacare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptPlan;

public interface SsptPlanRepository extends CrudRepository<SsptPlan, Integer> {
	
	public List<SsptPlan> findByEnableOrderByPrecio(Boolean enable);
	
	public List<SsptPlan> findAllByOrderByIdAsc();
	
	public SsptPlan findBytitulo(String title);

}
