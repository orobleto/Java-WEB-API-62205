package com.educacionit.javawebapi.dtos;

import java.util.Date;

public class UsuarioDTO {
	private String correo;
	private String clave;
	private Date fechaCreacion;
	private Boolean activo;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String correo, String clave, Date fechaCreacion, Boolean activo) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [correo=" + correo + ", clave=" + clave + ", fechaCreacion=" + fechaCreacion + ", activo="
				+ activo + "]";
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
