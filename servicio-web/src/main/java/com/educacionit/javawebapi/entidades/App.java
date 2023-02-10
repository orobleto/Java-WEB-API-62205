package com.educacionit.javawebapi.entidades;

import javax.xml.ws.Endpoint;

import com.educacionit.javawebapi.servicios.HolaMundo;
import com.educacionit.javawebapi.servicios.UsuarioServicio;

public class App {
	public static void main(String[] args) {
		System.out.println("Inicio");
		Endpoint.publish("http://localhost:8080/servicio-web/services/UsuarioServicio", new UsuarioServicio());
		System.out.println("Fin");
		
	}
}
