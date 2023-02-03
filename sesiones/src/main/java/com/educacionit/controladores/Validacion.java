package com.educacionit.controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.entidades.Usuario;
import com.educacionit.enumerados.MensajesFront;

@WebServlet(name = "login", urlPatterns = "/login")
public class Validacion extends HttpServlet {

	private List<Usuario> usuarios;
	private static final long serialVersionUID = 1L;

	public Validacion() {
		super();
		usuarios = cargarUsuarios();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean cerrarSesion = Boolean.valueOf(request.getParameter("cerrarSesion"));

		if (cerrarSesion) {
			request.getSession().invalidate();
			request.setAttribute("mensaje", MensajesFront.CERRAR_SESION);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("bienvenido.jsp");
		}

	}

	// post es para crear
	// crear sesion
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		Usuario usuario = buscar(correo, clave);
		String url = "index.jsp";

		if (usuario != null) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usuario);
			url = "bienvenido.jsp";

		} else {
			request.setAttribute("mensaje", MensajesFront.CREDENCIALES_INVALIDAS);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);

	}

	private Usuario buscar(String correo, String clave) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getClave().equals(clave)) {
				return usuario;
			}
		}

		return null;
	}

	private List<Usuario> cargarUsuarios() {
		return List.of(new Usuario("user1@gmail.com", "user1.1234", LocalDate.parse("1983-03-15")),
				new Usuario("user2@gmail.com", "user2.1234", LocalDate.parse("1999-01-08")));
	}

}
