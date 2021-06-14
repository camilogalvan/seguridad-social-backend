package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;

public interface SsptTipoIdentificacionRepository extends CrudRepository<SsptTipoIdentificacion, Integer> {
		
		public SsptTipoIdentificacion findFirstByTipo(String tipo);

}
