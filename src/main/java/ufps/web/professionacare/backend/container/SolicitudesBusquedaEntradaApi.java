package ufps.web.professionacare.backend.container;

import java.io.Serializable;

public class SolicitudesBusquedaEntradaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private String busqueda;
	private String fecha;
	private Boolean porFecha;
	private String estado;

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Boolean getPorFecha() {
		return porFecha;
	}

	public void setPorFecha(Boolean porFecha) {
		this.porFecha = porFecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
