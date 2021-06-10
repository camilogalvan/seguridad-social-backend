package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ufps.web.professionacare.backend.enums.EstadoSolicitudAfiliacion;

@Entity
@Table(name = "sspt_solicitud_afiliacion")
public class SsptSolicitudAfiliacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado_solicitud", nullable = false)
	private EstadoSolicitudAfiliacion estadoSolicitud;

	@Column(length = 2000)
	private String observaciones;

	@Column(length = 2000)
	private String respuesta;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_plan_seleccionado", referencedColumnName = "id")
	private SsptPlan ssptPlan;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private SsptCliente ssptCliente;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_usuario_respuesta", referencedColumnName = "id")
	private SsptUsuario ssptUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_respuesta", nullable = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaRespuesta;

	@OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference
	private Set<SsptSoporteAfiliacion> soportes;

	@PrePersist
	protected void prePersist() {
		this.estadoSolicitud = EstadoSolicitudAfiliacion.PENDIENTE;
		this.fechaRegistro = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoSolicitudAfiliacion getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitudAfiliacion estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public SsptPlan getSsptPlan() {
		return ssptPlan;
	}

	public void setSsptPlan(SsptPlan ssptPlan) {
		this.ssptPlan = ssptPlan;
	}

	public SsptCliente getSsptCliente() {
		return ssptCliente;
	}

	public void setSsptCliente(SsptCliente ssptCliente) {
		this.ssptCliente = ssptCliente;
	}

	public SsptUsuario getSsptUsuario() {
		return ssptUsuario;
	}

	public void setSsptUsuario(SsptUsuario ssptUsuario) {
		this.ssptUsuario = ssptUsuario;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public Set<SsptSoporteAfiliacion> getSoportes() {
		return soportes;
	}

	public void setSoportes(Set<SsptSoporteAfiliacion> soportes) {
		this.soportes = soportes;
	}

}
