package ufps.web.professionacare.backend.container;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class PlanEntradaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String descripcion;
	private Boolean enable;
	private MultipartFile file = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
