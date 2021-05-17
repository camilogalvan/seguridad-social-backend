package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "sspt_soporte_solicitud_afiliacion")
public class SsptSoporteAfiliacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	private String descripcion;

	@ManyToOne
	@JsonBackReference
	private SsptSolicitudAfiliacion solicitud;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_file", referencedColumnName = "id")
	private SsptFile file;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaRegistro;

	@PrePersist
	protected void prePersist() {
		this.fechaRegistro = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SsptFile getFile() {
		return file;
	}

	public void setFile(SsptFile file) {
		this.file = file;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public SsptSolicitudAfiliacion getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SsptSolicitudAfiliacion solicitud) {
		this.solicitud = solicitud;
	}

}
