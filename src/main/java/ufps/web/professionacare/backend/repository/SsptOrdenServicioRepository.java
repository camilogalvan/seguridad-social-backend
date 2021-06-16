package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;

public interface SsptOrdenServicioRepository extends CrudRepository<SsptOrdenServicio, Integer>{

	public SsptOrdenServicio findLastByCliente(SsptCliente cliente);
	
}
