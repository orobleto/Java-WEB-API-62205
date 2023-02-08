package com.educacionit.javawebapi.entidades;

import java.time.LocalDateTime;

public class Usuario {
	private String correo;
	private String clave;
	private LocalDateTime fechaCreacion;
	private Boolean activo;

	public Usuario() {
		super();
	}

	public Usuario(String correo, String clave, LocalDateTime fechaCreacion, Boolean activo) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	public String toString() {
		return "Usuario [" + correo + ", " + clave + ", fechaCreacion=" + fechaCreacion + ", "
				+ (activo ? "activo" : "inactivo") + "]";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
