package ufps.web.professionacare.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sspt_actividad_economica")
public class SsptActividadEconomica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_actividad")
	private Integer idActividad;

	@Column(name = "nivel_riesgo")
	private Integer nivelRiesgo;

	@Column(name = "codigo_actividad")
	private Integer codigoActividad;

	@Column(name = "nombre_actividad")
	private String nombreActividad;

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public Integer getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(Integer nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public Integer getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(Integer codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

}
