package ufps.web.professionacare.backend.container;

import java.io.Serializable;
import java.util.List;

import ufps.web.professionacare.backend.model.SsptUsuario;

public class UsuariosApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SsptUsuario> usuarios;

	public List<SsptUsuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<SsptUsuario> usuarios) {
		this.usuarios = usuarios;
	}

}
