package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptCliente;

public class ClientesApi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<SsptCliente> clientes;

	public List<SsptCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<SsptCliente> clientes) {
		this.clientes = clientes;
	}
	
	

}
