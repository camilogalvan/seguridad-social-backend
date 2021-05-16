package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptEmpresa;

public interface SsptEmpresaRepository extends CrudRepository<SsptEmpresa, Integer> {

	public SsptEmpresa findFirstByNit(String nit);

}
