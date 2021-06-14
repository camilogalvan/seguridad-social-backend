package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class SsptOrdenServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private Date fecha_orden;
	
	@Column(nullable = false)
	private Date fecha_limite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_afiliacion",referencedColumnName = "id")
	private SsptSolicitudAfiliacion id_afiliacion;
	

	public SsptOrdenServicio() {
		
	}
	
	public SsptOrdenServicio(int id, Date fecha_orden, Date fecha_limite, SsptSolicitudAfiliacion id_afiliacion) {
		super();
		this.id = id;
		this.fecha_orden = fecha_orden;
		this.fecha_limite = fecha_limite;
		this.id_afiliacion = id_afiliacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_orden() {
		return fecha_orden;
	}

	public void setFecha_orden(Date fecha_orden) {
		this.fecha_orden = fecha_orden;
	}

	public Date getFecha_limite() {
		return fecha_limite;
	}

	public void setFecha_limite(Date fecha_limite) {
		this.fecha_limite = fecha_limite;
	}



	public SsptSolicitudAfiliacion getId_afiliacion() {
		return id_afiliacion;
	}

	public void setId_afiliacion(SsptSolicitudAfiliacion id_afiliacion) {
		this.id_afiliacion = id_afiliacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Orden_Servicio [id=" + id + ", fecha_orden=" + fecha_orden + ", fecha_limite=" + fecha_limite
				+ ", id_afiliacion=" + id_afiliacion + "]";
	}
	
}
