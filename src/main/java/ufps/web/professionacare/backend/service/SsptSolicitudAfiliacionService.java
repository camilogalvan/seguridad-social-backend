package ufps.web.professionacare.backend.service;

import java.util.Date;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;

public interface SsptSolicitudAfiliacionService {

	public SsptSolicitudAfiliacion GetPorId(int id);
	
	public List<SsptSolicitudAfiliacion> Get();
	
	public List<SsptSolicitudAfiliacion> busqueda(String busqueda, String tipo, Date fecha, Boolean porFecha);
	
	public List<SsptSolicitudAfiliacion> filtradoReporte(String estado, Date fechaInicio, Date fechaFinal);
	
	public SsptSolicitudAfiliacion guardar(SsptSolicitudAfiliacion s);
}
