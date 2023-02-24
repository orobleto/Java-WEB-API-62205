package com.educacionit.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.educacionit.dtos.UsuarioDTO;
import com.educacionit.interfaces.ServicioGenerico;
import com.educacionit.javawebapi.entidades.Usuario;
import com.educacionit.javawebapi.jdbc.implementaciones.UsuarioImplementacion;
import com.octaviorobleto.commons.utilities.text.CodeUtils;
import com.octaviorobleto.commons.utilities.time.DateUtils;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value = "usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioServicio implements ServicioGenerico<UsuarioDTO, String> {
	private static Logger logger = LogManager.getLogger();
	private UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();

	// queryParam
	@GET
	@Path(value = "/buscarPorQuery")
	public Response buscarPorID(@QueryParam(value = "correo") String correo) {
		return buscar(correo);
	}

	@GET
	@Path(value = "/buscarPorPath/{correo}")
	public Response buscarPorPath(@PathParam(value = "correo") String correo) {
		return buscar(correo);
	}

	@POST
	@Path(value = "/guardarJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarJson(UsuarioDTO usuarioDTO) {

		return guardar(usuarioDTO);
	}

	@POST
	@Path(value = "/guardarForm")
	public Response guardarForm(@FormParam(value = "correo") String correo, @FormParam(value = "clave") String clave,
			@FormParam(value = "activo") boolean activo) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setCorreo(correo);
		usuarioDTO.setClave(clave);
		usuarioDTO.setActivo(activo);
		return guardar(usuarioDTO);
	}

	@DELETE
	@Path(value = "/eliminar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminar(UsuarioDTO usuarioDTO) {
		if (usuarioImplementacion.eliminar(getUsuario(usuarioDTO))) {
			usuarioDTO.setMensaje("Eliminado Correctamente");
			return Response.ok().entity(usuarioDTO).build();
		}
		usuarioDTO.setMensaje("Usuario no Existe");
		return Response.status(204).entity(usuarioDTO).build();
	}

	@GET
	@Path(value = "/listar")
	public Response listar() {

		List<UsuarioDTO> usuarioDTOs = usuarioImplementacion.listar().stream()
				.map(usuario -> getUsuarioDTO(usuario, null)).collect(Collectors.toList());
		logger.debug(usuarioDTOs);
		/*
		 * List<Usuario> usuarios = usuarioImplementacion.listar(); List<UsuarioDTO>
		 * usuarioDTOs = usuarios.stream().map(usuario -> getUsuarioDTO(usuario, null))
		 * .collect(Collectors.toList());
		 */

		return Response.ok().entity(usuarioDTOs).build();
	}

	private UsuarioDTO getUsuarioDTO(Usuario usuario, String mensaje) {
		if (usuario == null) {
			return null;
		}
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setCorreo(usuario.getCorreo());
		usuarioDTO.setClave(CodeUtils.AES_Encrypt(usuario.getClave(), "DTO"));
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setActivo(usuario.getActivo());
		usuarioDTO.setMensaje(mensaje);
		return usuarioDTO;
	}

	private Usuario getUsuario(UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return null;
		}
		Usuario usuario = new Usuario();
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setClave(usuarioDTO.getClave());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setActivo(usuarioDTO.getActivo());
		return usuario;
	}

	private Response buscar(String correo) {
		Usuario usuario = usuarioImplementacion.buscarPorID(correo);
		if (usuario == null) {
			return Response.status(204).build();
		}

		return Response.ok().entity(getUsuarioDTO(usuario, "Encontrado Correctamente")).build();
	}

	public Response guardar(UsuarioDTO usuarioDTO) {
		usuarioImplementacion.guardar(getUsuario(usuarioDTO));
		usuarioDTO = getUsuarioDTO(usuarioImplementacion.buscarPorID(usuarioDTO.getCorreo()), "Guardado Exitosamente");
		return Response.status(201).entity(usuarioDTO).build();
	}

}
