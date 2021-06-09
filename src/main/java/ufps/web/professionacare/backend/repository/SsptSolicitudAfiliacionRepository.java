package ufps.web.professionacare.backend.repository;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SsptSolicitudAfiliacionRepository extends CrudRepository<SsptSolicitudAfiliacion, Integer> {
	
	@Query(value = "SELECT * FROM sspt_solicitud_afiliacion ORDER BY fecha_respuesta", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findAllOrderByfechaRespuesta();

}
