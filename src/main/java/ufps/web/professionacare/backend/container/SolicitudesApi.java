package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;

public class SolicitudesApi implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<SsptSolicitudAfiliacion> solicitudes;

	public List<SsptSolicitudAfiliacion> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<SsptSolicitudAfiliacion> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	
}
