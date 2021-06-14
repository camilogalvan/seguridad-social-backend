package ufps.web.professionacare.backend.container;

import java.io.Serializable;

public class OrdenEntrada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int idAfiliacion;

	
	public OrdenEntrada() {
		super();
	}

	public int getIdAfiliacion() {
		return idAfiliacion;
	}

	public void setIdAfiliacion(int idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}
	
	
}
