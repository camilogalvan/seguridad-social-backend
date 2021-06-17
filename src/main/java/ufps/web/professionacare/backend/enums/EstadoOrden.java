package ufps.web.professionacare.backend.enums;

public enum EstadoOrden {	
	PENDIENTE("Pendiente"), 
	PAGADA("Pagada");

	private String nombre;

	private EstadoOrden(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
