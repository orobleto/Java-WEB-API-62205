package com.educacionit.configuraciones;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

// localhos://servio-rest/inventario
//localhos://servio-rest/producto
//localhos://servio-rest/usuarios
@ApplicationPath(value = "/api")
public class ConfiguracionRest extends ResourceConfig {
	public ConfiguracionRest() {
		packages("com.educacionit");
	}
}
