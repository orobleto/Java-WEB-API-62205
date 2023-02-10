package com.educacionit.javawebapi.servicios;

import javax.jws.WebService;

@WebService
public class HolaMundo {
	public String holaMundo() {
		return "Hola Mundo desde Servicio WEB";
	}
}
