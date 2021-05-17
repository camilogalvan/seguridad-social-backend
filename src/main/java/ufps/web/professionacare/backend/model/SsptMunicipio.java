package ufps.web.professionacare.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sspt_municipio")
public class SsptMunicipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_municipio")
	private Integer idMunicipio;

	@Column(name = "codigo_departamento")
	private String codigoDepartamento;

	@Column(name = "codigo_dpto_mpio")
	private String codigoDptoMpio;

	@Column(name = "codigo_municipio")
	private String codigoMunicipio;

	@Column(name = "nombre_departamento")
	private String nombreDepartamento;

	@Column(name = "nombre_municipio")
	private String nombreMunicipio;

	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private SsptDepartamento departamento;

	public Integer getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getCodigoDepartamento() {
		return this.codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getCodigoDptoMpio() {
		return this.codigoDptoMpio;
	}

	public void setCodigoDptoMpio(String codigoDptoMpio) {
		this.codigoDptoMpio = codigoDptoMpio;
	}

	public String getCodigoMunicipio() {
		return this.codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getNombreDepartamento() {
		return this.nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreMunicipio() {
		return this.nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public SsptDepartamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(SsptDepartamento departamento) {
		this.departamento = departamento;
	}

}
