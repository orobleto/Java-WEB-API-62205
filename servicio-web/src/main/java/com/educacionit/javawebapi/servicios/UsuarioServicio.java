package com.educacionit.javawebapi.servicios;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.educacionit.javawebapi.dtos.UsuarioDTO;
import com.educacionit.javawebapi.entidades.Usuario;
import com.educacionit.javawebapi.jdbc.implementaciones.UsuarioImplementacion;
import com.octaviorobleto.commons.utilities.time.DateUtils;

@WebService(name = "UsuarioServicio", portName = "ServicioUsuario", targetNamespace = "http://educacionit.com")
public class UsuarioServicio {
	private UsuarioImplementacion usuarioImplementacion = new UsuarioImplementacion();

	@WebMethod(operationName = "buscarUsuarioPorCorreo")
	@WebResult(name = "usuario", header = true)
	public UsuarioDTO buscarPorID(@WebParam(name = "correo") String correo) {
		return getUsuarioDTO(usuarioImplementacion.buscarPorID(correo));
	}

	@WebMethod(operationName = "guardarUsuario")
	@WebResult(name = "usuario", header = true)
	public UsuarioDTO guardar(@WebParam(name = "usuario") UsuarioDTO usuarioDTO) {
		usuarioImplementacion.guardar(getUsuario(usuarioDTO));
		return getUsuarioDTO(usuarioImplementacion.buscarPorID(usuarioDTO.getCorreo()));
	}

	@WebMethod(operationName = "eliminarUsuario")
	@WebResult(name = "eliminado", header = true)
	public Boolean eliminar(@WebParam(name = "usuario") UsuarioDTO usuarioDTO) {
		return usuarioImplementacion.eliminar(getUsuario(usuarioDTO));
	}

	@WebMethod(operationName = "listarUsuarios")
	@WebResult(name = "usuarios", header = true)
	public UsuarioDTO[] listar() {
		// List<UsuarioDTO> usuariosDTO = usuarioImplementacion.listar().stream().map(e
		// -> getUsuarioDTO(e)) .collect(Collectors.toList());
		List<Usuario> usuarios = usuarioImplementacion.listar();
		UsuarioDTO[] usuariosDTO = new UsuarioDTO[usuarios.size()];
		for (int i = 0; i < usuarios.size(); i++) {
			usuariosDTO[i] = getUsuarioDTO(usuarios.get(i));
		}

		return usuariosDTO;
	}

	private UsuarioDTO getUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setCorreo(usuario.getCorreo());
		usuarioDTO.setClave(usuario.getClave());
		usuarioDTO.setActivo(usuario.getActivo());
		usuarioDTO.setFechaCreacion(DateUtils.getDate(usuario.getFechaCreacion()));
		return usuarioDTO;
	}

	private Usuario getUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setClave(usuarioDTO.getClave());
		usuario.setActivo(usuarioDTO.getActivo());
		usuario.setFechaCreacion(DateUtils.getLocalDateTime(usuarioDTO.getFechaCreacion()));
		return usuario;
	}

}
