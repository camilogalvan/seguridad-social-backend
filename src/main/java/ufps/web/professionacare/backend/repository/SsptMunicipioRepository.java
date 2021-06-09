package ufps.web.professionacare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptDepartamento;
import ufps.web.professionacare.backend.model.SsptMunicipio;

public interface SsptMunicipioRepository extends CrudRepository<SsptMunicipio, Integer>{
	
	public List<SsptMunicipio> findByDepartamento(SsptDepartamento departamento);

}
