package com.educacionit.javawebapi.conector_db;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.educacionit.javawebapi.entidades.Usuario;
import com.educacionit.javawebapi.jdbc.conexiones.AdministradorMariaDB;
import com.educacionit.javawebapi.jdbc.implementaciones.UsuarioImplementacion;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("oct4@gmail.com", "99999", null, true);
		UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();
		usuarioImplementacion.eliminar(usuario);

		// System.out.println(usuarioImplementacion.buscarPorID("oct3@gmail.com"));

		for (Usuario usuarioAux : usuarioImplementacion.listar()) {
			System.out.println(usuarioAux);
		}
	}
}
