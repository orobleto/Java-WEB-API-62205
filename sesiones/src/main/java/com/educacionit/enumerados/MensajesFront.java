package com.educacionit.enumerados;

public enum MensajesFront {
	CERRAR_SESION("Ha cerrado sesion correctamente", "orange"),
	CREDENCIALES_INVALIDAS("Credenciales Incorrectas", "red");

	private String mensaje;
	private String color;

	private MensajesFront(String mensaje, String color) {
		this.mensaje = mensaje;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public String getMensaje() {
		return mensaje;
	}
}
