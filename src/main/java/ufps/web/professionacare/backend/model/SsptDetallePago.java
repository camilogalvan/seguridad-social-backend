package ufps.web.professionacare.backend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SsptDetallePago implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private Date fecha_pago;

	@Column(nullable = false)
	private String medio_pago;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nro_orden", referencedColumnName = "id")
	private SsptOrdenServicio nro_orden;
	
	public SsptDetallePago() {
		
	}
	
	public SsptDetallePago(int id, Date fecha_pago, String medio_pago, SsptOrdenServicio nro_orden) {
		super();
		this.id = id;
		this.fecha_pago = fecha_pago;
		this.medio_pago = medio_pago;
		this.nro_orden = nro_orden;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public String getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(String medio_pago) {
		this.medio_pago = medio_pago;
	}

	public SsptOrdenServicio getNro_orden() {
		return nro_orden;
	}

	public void setNro_orden(SsptOrdenServicio nro_orden) {
		this.nro_orden = nro_orden;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SsptDetallePago [id=" + id + ", fecha_pago=" + fecha_pago + ", medio_pago=" + medio_pago
				+ ", nro_orden=" + nro_orden.getId() + "]";
	}
	
	
	
}
