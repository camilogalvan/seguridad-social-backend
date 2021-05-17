package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "sspt_departamento")
public class SsptDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_departamento")
	private Integer idDepartamento;

	@Column(name = "codigo_departamento")
	private String codigoDepartamento;

	@Column(name = "nombre_departamento")
	private String nombreDepartamento;

	public SsptDepartamento() {
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getCodigoDepartamento() {
		return this.codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getNombreDepartamento() {
		return this.nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

}