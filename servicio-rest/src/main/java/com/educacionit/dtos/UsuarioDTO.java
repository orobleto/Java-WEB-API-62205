package com.educacionit.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

// POJO
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String correo;
	private String clave;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaCreacion;
	private Boolean activo;
	private String mensaje;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String correo, String clave, LocalDateTime fechaCreacion, Boolean activo, String mensaje) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		this.mensaje = mensaje;
	}

	public String toString() {
		return "UsuarioDTO [correo=" + correo + ", clave=" + clave + ", fechaCreacion=" + fechaCreacion + ", activo="
				+ activo + ", mensaje=" + mensaje + "]";
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
