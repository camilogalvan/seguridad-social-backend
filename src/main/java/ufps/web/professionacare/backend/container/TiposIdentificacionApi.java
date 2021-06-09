package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptTipoIdentificacion;

public class TiposIdentificacionApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SsptTipoIdentificacion> tiposIdentificacion;

	public List<SsptTipoIdentificacion> getTiposIdentificacion() {
		return tiposIdentificacion;
	}

	public void setTiposIdentificacion(List<SsptTipoIdentificacion> tiposIdentificacion) {
		this.tiposIdentificacion = tiposIdentificacion;
	}


	
}
