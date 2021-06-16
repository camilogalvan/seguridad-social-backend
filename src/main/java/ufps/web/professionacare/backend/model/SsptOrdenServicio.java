package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ufps.web.professionacare.backend.enums.EstadoCliente;

@Entity
@Table(name = "sspt_orden_servicio")
public class SsptOrdenServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "fecha_orden", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaOrden;

	@Column(name = "fecha_pago", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;

	@Column(name = "fecha_limite", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaLimite;

	@Column(nullable = false)
	private Integer precio;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "estado_orden", nullable = true)
	private EstadoCliente estadoOrden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private SsptCliente cliente;

	public SsptOrdenServicio() {
	}

	@PrePersist
	public void prePersist() {
		this.fechaOrden = new Date();
		Date fechaLimite =new Date();
		this.fechaLimite= fechaLimite;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public SsptCliente getCliente() {
		return cliente;
	}

	public void setCliente(SsptCliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public EstadoCliente getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(EstadoCliente estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

}
