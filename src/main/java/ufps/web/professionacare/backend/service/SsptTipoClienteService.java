package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptTipoCliente;

public interface SsptTipoClienteService {

	public SsptTipoCliente buscarPorId(Integer id);
	
	public List<SsptTipoCliente> get();

}
