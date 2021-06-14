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
import javax.persistence.Table;

@Entity
@Table(name = "sspt_detalle_pago")
public class SsptDetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, name = "fecha_pago")
	private Date fechaPago;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_orden", referencedColumnName = "id")
	private SsptOrdenServicio orden;

	public SsptDetallePago() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public SsptOrdenServicio getOrden() {
		return orden;
	}

	public void setOrden(SsptOrdenServicio orden) {
		this.orden = orden;
	}

}
