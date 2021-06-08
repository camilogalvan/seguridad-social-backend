package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptCliente;

public class ClienteApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private SsptCliente cliente;

	public SsptCliente getCliente() {
		return cliente;
	}

	public void setCliente(SsptCliente cliente) {
		this.cliente = cliente;
	}

}
