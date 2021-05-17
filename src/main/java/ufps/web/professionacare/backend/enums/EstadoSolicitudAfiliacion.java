package ufps.web.professionacare.backend.enums;

public enum EstadoSolicitudAfiliacion {

	PENDIENTE("Pendiente"),
	NEGADA("Negada"),
	APROBADA("Aprobada");

	private String nombre;

	private EstadoSolicitudAfiliacion(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

}
