package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import ufps.web.professionacare.backend.model.SsptEmpresa;

public class EmpresaApi implements Serializable {
	private static final long serialVersionUID = -5532259889526898560L;

	private SsptEmpresa empresa;

	public SsptEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(SsptEmpresa empresa) {
		this.empresa = empresa;
	}

}
