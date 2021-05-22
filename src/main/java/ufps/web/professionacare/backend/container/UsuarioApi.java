package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptUsuario;

public class UsuarioApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private SsptUsuario usuario;

	public SsptUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(SsptUsuario usuario) {
		this.usuario = usuario;
	}

}
