package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.enums.EstadoCliente;
import ufps.web.professionacare.backend.model.SsptCliente;

public interface SsptClienteService {
	
	public SsptCliente GetPorId(int id);
	
	public List<SsptCliente> Get();
	
	public SsptCliente guardar(SsptCliente cliente);
	
	public SsptCliente GetPorCedula(String cedula);
	
	public SsptCliente GetPorEstado(EstadoCliente e);
	
	public SsptCliente GetPorNombreCompleto(String nombre);

}
