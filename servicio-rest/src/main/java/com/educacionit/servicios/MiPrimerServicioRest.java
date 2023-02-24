package com.educacionit.servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//api/usuarios
//api/inventario
// 
@Path(value = "/MiPrimerServicioRest")
public class MiPrimerServicioRest {

	private static Logger logger = LogManager.getLogger();

	@GET
	@Path(value = "/tipoTexto")
	@Produces(MediaType.TEXT_PLAIN)
	public String metodo1() {
		logger.debug("Hola Mundo Servicio Rest");
		return "<html><h1>Hola Mundo Servicio Rest 1</h1></html>";
	}
	

	@GET
	@Path(value = "/tipoHTML")
	@Produces(MediaType.TEXT_HTML)
	public String metodo2() {
		logger.debug("<html><h1>Hola Mundo Servicio Rest 1</h1></html>");
		return "<html><h1>Hola Mundo Servicio Rest 1</h1></html>";
	}
	

	@GET
	@Path(value = "/tipoJson")
	@Produces(MediaType.APPLICATION_JSON)
	public String metodo3() {
		logger.debug("<html><h1>Hola Mundo Servicio Rest 1</h1></html>");
		return "<html><h1>Hola Mundo Servicio Rest 1</h1></html>";
	}
	
	// patron de diseño builder
	@POST
	@Path(value = "/tipoResponse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response metodo4() {
		logger.debug("<html><h1>Hola Mundo Servicio Rest tipoResponse</h1></html>");
		// 200 ok 400 errores del cliente 300 redireccion 500 errores del programador
		return Response.status(201).entity("<html><h1>Hola Mundo Servicio Rest tipoResponse</h1></html>").build();
	}
	
	
	

}
