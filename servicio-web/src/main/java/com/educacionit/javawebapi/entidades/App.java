package com.educacionit.javawebapi.entidades;

import javax.xml.ws.Endpoint;

import com.educacionit.javawebapi.servicios.HolaMundo;

public class App {
	public static void main(String[] args) {
		System.out.println("Inicio");
		Endpoint.publish("http://localhost:8080/ServicioWeb/HolaMundo", new HolaMundo());
		System.out.println("Fin");
		
	}
}
