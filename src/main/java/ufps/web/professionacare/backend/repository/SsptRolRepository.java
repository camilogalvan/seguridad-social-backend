package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptRol;

public interface SsptRolRepository extends CrudRepository<SsptRol, Integer> {
	
	public SsptRol findFirstByRol(String rol);

}
