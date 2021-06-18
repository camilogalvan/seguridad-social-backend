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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ufps.web.professionacare.backend.enums.EstadoCliente;

@Entity
@Table(name = "sspt_cliente")
public class SsptCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	@Column(nullable = false, unique = true)
	private String identificacion;

	@Column(unique = true)
	private String correo;

	@Column(nullable = false)
	private String nombre1;

	@Column
	private String nombre2;

	@Column(nullable = false)
	private String apellido1;

	@Column
	private String apellido2;

	@Column
	private String profesion;

	@Column
	private String telefono;

	@Column
	private String direccion;

	@Column
	private String dv;

	@Column
	private Integer ibc;

	@Column(name = "lugar_expedicion")
	private String lugarExpedicion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expedicion")
	private Date fechaExpedicion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_afiliacion")
	private Date fechaAfiliacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_retiro")
	private Date fechaRetiro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion")
	@JsonIgnore
	private Date fechaActualizacion;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado_cliente", nullable = false)
	private EstadoCliente estadoCliente;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_identificacion", referencedColumnName = "id")
	private SsptTipoIdentificacion tipoIdentificacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_cliente", referencedColumnName = "id")
	private SsptTipoCliente tipoCliente;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_cliente_dependiente", referencedColumnName = "id")
	private SsptCliente clienteDependiente;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
	private SsptMunicipio municipio;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_plan", referencedColumnName = "id")
	private SsptPlan plan;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
	private SsptActividadEconomica actividad;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_asesor", referencedColumnName = "id")
	private SsptUsuario asesor;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference
	private Set<SsptSoporteCliente> soportes;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonManagedReference
	@JsonIgnore
	private Set<SsptOrdenServicio> ordenes;

	public SsptCliente() {
	}

	@PrePersist
	public void prePersist() {
		this.estadoCliente = EstadoCliente.PENDIENTE;
		this.fechaRegistro = new Date();
	}

	@PreUpdate
	protected void preUpdate() {
		this.fechaActualizacion = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public SsptActividadEconomica getActividad() {
		return actividad;
	}

	public void setActividad(SsptActividadEconomica actividad) {
		this.actividad = actividad;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public Integer getIbc() {
		return ibc;
	}

	public void setIbc(Integer ibc) {
		this.ibc = ibc;
	}

	public String getLugarExpedicion() {
		return lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public EstadoCliente getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(EstadoCliente estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public SsptTipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(SsptTipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public SsptTipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(SsptTipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Set<SsptSoporteCliente> getSoportes() {
		return soportes;
	}

	public void setSoportes(Set<SsptSoporteCliente> soportes) {
		this.soportes = soportes;
	}

	public SsptMunicipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(SsptMunicipio municipio) {
		this.municipio = municipio;
	}

	public SsptCliente getClienteDependiente() {
		return clienteDependiente;
	}

	public void setClienteDependiente(SsptCliente clienteDependiente) {
		this.clienteDependiente = clienteDependiente;
	}

	public Set<SsptOrdenServicio> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(Set<SsptOrdenServicio> ordenes) {
		this.ordenes = ordenes;
	}

	public SsptPlan getPlan() {
		return plan;
	}

	public void setPlan(SsptPlan plan) {
		this.plan = plan;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public SsptUsuario getAsesor() {
		return asesor;
	}

	public void setAsesor(SsptUsuario asesor) {
		this.asesor = asesor;
	}

	public String getNombreCompleto() {
		return this.nombre1 + (this.nombre2 != null ? " " + this.nombre2 : "") + " " + this.apellido1 + " "
				+ (this.apellido2 != null ? this.apellido2 : "");
	}

}
