package ufps.web.professionacare.backend.service;

import java.util.List;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;

public interface SsptSolicitudAfiliacionService {

	public SsptSolicitudAfiliacion GetPorId(int id);
	
	public List<SsptSolicitudAfiliacion> Get();
	
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion s);
}
