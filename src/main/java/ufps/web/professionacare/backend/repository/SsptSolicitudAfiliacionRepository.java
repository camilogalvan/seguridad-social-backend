package ufps.web.professionacare.backend.repository;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SsptSolicitudAfiliacionRepository extends CrudRepository<SsptSolicitudAfiliacion, Integer> {
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, \r\n"
			+ "sol.fecha_registro desc limit 50", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findAllOrderByfechaRespuesta();
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, \r\n"
			+ "sol.fecha_registro desc limit 50", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findAllOrderByfechaRespuestaAsesor(Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) = :fecha "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaOnly(Date fecha);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaAsesor(Date fecha, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.estado_solicitud = :estado "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaAndEstadoOnly(Date fecha, Integer estado);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.estado_solicitud = :estado and sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaAndEstadoAsesor(Date fecha, Integer estado, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaBetweenOnly(Date fechaInicio, Date fechaFinal);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "and sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaBetweenAsesor(Date fechaInicio, Date fechaFinal, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "and sol.estado_solicitud = :estado "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaBetweenAndEstadoOnly(Date fechaInicio, Date fechaFinal, Integer estado);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "and sol.estado_solicitud = :estado and sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByFechaBetweenAndEstadoAsesor(Date fechaInicio, Date fechaFinal, Integer estado, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where sol.estado_solicitud = :estado "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByEstadoOnly(Integer estado);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "where sol.estado_solicitud = :estado and sol.id_usuario_respuesta = :idAsesor "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByEstadoAsesor(Integer estado, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaOnly(String busqueda);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where sol.id_usuario_respuesta = :idAsesor and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAsesor(String busqueda, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where DATE(sol.fecha_registro) = :fecha and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndFechaOnly(Date fecha, String busqueda);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.id_usuario_respuesta = :idAsesor and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndFechaAsesor(Date fecha, String busqueda, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where sol.estado_solicitud = :estado and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndEstadoOnly(Integer estado, String busqueda);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where sol.estado_solicitud = :estado and sol.id_usuario_respuesta = :idAsesor and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndEstadoAsesor(Integer estado, String busqueda, Integer idAsesor);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.estado_solicitud = :estado and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndFechaAndEstadoOnly(Date fecha, Integer estado, String busqueda);
	
	@Query(value = "SELECT sol.* FROM sspt_solicitud_afiliacion sol "
			+ "inner join sspt_cliente sc on sc.id = sol.id_cliente "
			+ "inner join sspt_plan sp on sp.id = sol.id_plan_seleccionado "
			+ "where DATE(sol.fecha_registro) = :fecha and sol.estado_solicitud = :estado "
			+ "and sol.id_usuario_respuesta = :idAsesor and "
			+ "(coalesce(upper(sc.identificacion),'')|| ' ' || "
			+ "coalesce(upper(sc.nombre1),'')|| ' ' || "
			+ "coalesce(upper(sc.apellido1),'')|| ' ' || "
			+ "coalesce(upper(sp.titulo),'')|| ' ' || "
			+ "coalesce(upper(sol.respuesta),'') ~ :busqueda) "
			+ "ORDER BY case when sol.estado_solicitud = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptSolicitudAfiliacion> findByBusquedaAndFechaAndEstadoAsesor(Date fecha, Integer estado, String busqueda, Integer idAsesor);

}
