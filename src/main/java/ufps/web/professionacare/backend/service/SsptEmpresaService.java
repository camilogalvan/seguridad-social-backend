package ufps.web.professionacare.backend.service;

import ufps.web.professionacare.backend.model.SsptEmpresa;

public interface SsptEmpresaService {
	
	public SsptEmpresa getEmpresaActual();
	
	public SsptEmpresa guardar(SsptEmpresa entity);

}
