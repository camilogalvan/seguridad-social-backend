package ufps.web.professionacare.backend.container;

import java.io.Serializable;

public class OrdenEntrada implements Serializable {

	private static final long serialVersionUID = 1L;

	int idCliente;

	public OrdenEntrada() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}
