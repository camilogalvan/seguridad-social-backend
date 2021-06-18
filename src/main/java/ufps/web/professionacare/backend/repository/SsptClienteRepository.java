package ufps.web.professionacare.backend.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ufps.web.professionacare.backend.model.SsptCliente;

public interface SsptClienteRepository extends CrudRepository <SsptCliente, Integer>{

	public SsptCliente findByIdentificacion(String identificacion);

	public SsptCliente findByCorreo(String correo);
	
	@Query(value = "SELECT sol.* FROM sspt_cliente sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "ORDER BY case when sol.estado_cliente = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptCliente> findByFechaBetweenOnly(Date fechaInicio, Date fechaFinal);
	
	@Query(value = "SELECT sol.* FROM sspt_cliente sol "
			+ "where DATE(sol.fecha_registro) >= :fechaInicio and DATE(sol.fecha_registro) <= :fechaFinal "
			+ "and sol.estado_cliente = :estado "
			+ "ORDER BY case when sol.estado_cliente = 0 then 0 else 1 end, "
			+ "sol.fecha_registro desc", nativeQuery=true)
	public List<SsptCliente> findByFechaBetweenAndEstadoOnly(Date fechaInicio, Date fechaFinal, Integer estado);
}
