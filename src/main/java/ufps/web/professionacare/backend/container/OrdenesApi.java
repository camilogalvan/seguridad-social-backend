package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptOrdenServicio;
public class OrdenesApi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<SsptOrdenServicio> ordenes;

	public List<SsptOrdenServicio> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<SsptOrdenServicio> ordenes) {
		this.ordenes = ordenes;
	}
	
	
}
