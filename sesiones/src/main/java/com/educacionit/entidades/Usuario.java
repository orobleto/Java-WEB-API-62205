package com.educacionit.entidades;

import java.time.LocalDate;

public class Usuario {

	private String correo;
	private String clave;
	private LocalDate fechaNacimiento;

	public Usuario() {
		super();
	}

	public Usuario(String correo, String clave, LocalDate fechaNacimiento) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Usuario [" + correo + ", " + clave + ", " + fechaNacimiento + "]";
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

}
