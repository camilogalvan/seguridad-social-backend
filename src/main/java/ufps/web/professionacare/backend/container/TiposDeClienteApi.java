package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptTipoCliente;
import ufps.web.professionacare.backend.model.SsptUsuario;

public class TiposDeClienteApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SsptTipoCliente> tiposCliente;

	public List<SsptTipoCliente> getTiposCliente() {
		return tiposCliente;
	}

	public void setTiposCliente(List<SsptTipoCliente> tiposCliente) {
		this.tiposCliente = tiposCliente;
	}

	
}
