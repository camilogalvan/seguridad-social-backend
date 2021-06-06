package ufps.web.professionacare.backend.repository;

import org.springframework.data.repository.CrudRepository;
import ufps.web.professionacare.backend.enums.EstadoCliente;
import ufps.web.professionacare.backend.model.SsptCliente;

public interface SsptClienteRepository extends CrudRepository <SsptCliente, Integer>{

	public SsptCliente findByidentificacion(String documento);
	
	public SsptCliente findByestadoCliente (EstadoCliente es);
	
	public SsptCliente findBynombreCompleto(String nombre);
}
