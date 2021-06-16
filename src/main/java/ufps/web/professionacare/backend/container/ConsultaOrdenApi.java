package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptCliente;
import ufps.web.professionacare.backend.model.SsptOrdenServicio;

public class ConsultaOrdenApi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SsptCliente cliente;
	private SsptOrdenServicio orden;

	public SsptOrdenServicio getOrden() {
		return orden;
	}

	public void setOrden(SsptOrdenServicio orden) {
		this.orden = orden;
	}

	public SsptCliente getCliente() {
		return cliente;
	}

	public void setCliente(SsptCliente cliente) {
		this.cliente = cliente;
	}

}
