package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptSolicitudAfiliacion;

public class SolicitudApi implements Serializable {

	private static final long serialVersionUID = 1L;

	private SsptSolicitudAfiliacion solicitud;

	public SsptSolicitudAfiliacion getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SsptSolicitudAfiliacion solicitud) {
		this.solicitud = solicitud;
	}

}
