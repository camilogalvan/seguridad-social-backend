package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptCliente;

public interface SsptClienteService {
	
	public SsptCliente GetPorId(int id);
	
	public List<SsptCliente> Get();
	
	public SsptCliente guardar(SsptCliente cliente);
	
	public SsptCliente buscarPorCorreo(String correo);
	
	public SsptCliente GetPorCedula(String cedula);

}
