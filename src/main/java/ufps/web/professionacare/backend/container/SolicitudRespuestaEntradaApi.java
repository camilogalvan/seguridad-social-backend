package ufps.web.professionacare.backend.container;

import java.io.Serializable;

public class SolicitudRespuestaEntradaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private String observacion;
	private String respuesta;

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
