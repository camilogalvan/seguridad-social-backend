package ufps.web.professionacare.backend.enums;

public enum EstadoCliente {

	AFILIADO("Afiliado"),
	RETIRADO("Retirado"),
	NEGADO("Negado"),
	PENDIENTE("Pendiente");

	private String nombre;

	private EstadoCliente(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
