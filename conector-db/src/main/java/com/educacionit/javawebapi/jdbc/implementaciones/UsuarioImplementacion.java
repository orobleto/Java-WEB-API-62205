package com.educacionit.javawebapi.jdbc.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.javawebapi.entidades.Usuario;
import com.educacionit.javawebapi.jdbc.conexiones.AdministradorMariaDB;
import com.educacionit.javawebapi.jdbc.interfaces.DAO;
import com.octaviorobleto.commons.utilities.time.DateUtils;

public class UsuarioImplementacion implements DAO<Usuario, String> {
	//private static Logger logger = LogManager.getLogger();
	private PreparedStatement preparedStatementBuscarPorID;
	private PreparedStatement preparedStatementInsertar;
	private PreparedStatement preparedStatementModificar;
	private PreparedStatement preparedStatementListar;
	private PreparedStatement preparedStatementEliminar;

	private AdministradorMariaDB administradorMariaDB;

	public UsuarioImplementacion() {
		administradorMariaDB = AdministradorMariaDB.getInstancia();
	}

	public Usuario buscarPorID(String correo) {
		String sql = "select correo,AES_DECRYPT(clave,concat(?,correo)) as clave,fechaCreacion,activo from usuarios where correo = ?";
		try {
			if (preparedStatementBuscarPorID == null) {
				preparedStatementBuscarPorID = administradorMariaDB.getConnection().prepareStatement(sql);
			}
			preparedStatementBuscarPorID.setString(1, administradorMariaDB.getLlave());
			preparedStatementBuscarPorID.setString(2, correo.toLowerCase());

			ResultSet resultSet = preparedStatementBuscarPorID.executeQuery();
			if (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultSet.getString("correo"));
				usuario.setClave(resultSet.getString("clave"));
				usuario.setFechaCreacion(DateUtils.getLocalDateTime(resultSet.getString("fechaCreacion"),
						DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS_24H));
				usuario.setActivo(resultSet.getBoolean("activo"));
				return usuario;
			}

		} catch (SQLException e) {
			//logger.error(e);
		}

		return null;
	}

	public boolean guardar(Usuario usuario) {

		if (buscarPorID(usuario.getCorreo()) != null) {
			return modificar(usuario);
		}

		return insertar(usuario);
	}

	private boolean insertar(Usuario usuario) {
		String sql = "insert into usuarios (correo,clave,fechaCreacion,activo) values (?,AES_ENCRYPT(?,?),?,?)";
		try {
			if (preparedStatementInsertar == null) {
				preparedStatementInsertar = administradorMariaDB.getConnection().prepareStatement(sql);
			}
			preparedStatementInsertar.setString(1, usuario.getCorreo().toLowerCase());
			preparedStatementInsertar.setString(2, usuario.getClave());
			preparedStatementInsertar.setString(3,
					(administradorMariaDB.getLlave().concat(usuario.getCorreo().toLowerCase())));
			preparedStatementInsertar.setString(4,
					DateUtils.getString(LocalDateTime.now(), DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS_24H));
			preparedStatementInsertar.setBoolean(5, usuario.getActivo());

			boolean inserto = preparedStatementInsertar.executeUpdate() == 1;
			//logger.debug(inserto ? usuario : null);
			return inserto;
		} catch (SQLException e) {
			//logger.error(e);
		}
		return false;
	}

	private boolean modificar(Usuario usuario) {
		String sql = "update usuarios set clave = AES_ENCRYPT(?,?), activo = ? where correo = ?";
		try {
			if (preparedStatementModificar == null) {
				preparedStatementModificar = administradorMariaDB.getConnection().prepareStatement(sql);
			}
			preparedStatementModificar.setString(1, usuario.getClave());
			preparedStatementModificar.setString(2,
					administradorMariaDB.getLlave().concat(usuario.getCorreo().toLowerCase()));
			preparedStatementModificar.setBoolean(3, usuario.getActivo());
			preparedStatementModificar.setString(4, usuario.getCorreo());

			boolean modifico = preparedStatementModificar.executeUpdate() == 1;
			//logger.debug(modifico ? usuario : null);
			return modifico;

		} catch (SQLException e) {
			//logger.error(e);
		}

		return false;
	}

	public boolean eliminar(Usuario usuario) {
		String sql = "delete from usuarios where correo = ?";
		try {
			if (preparedStatementEliminar == null) {
				preparedStatementEliminar = administradorMariaDB.getConnection().prepareStatement(sql);
			}
			preparedStatementEliminar.setString(1, usuario.getCorreo());
			boolean elimino = preparedStatementEliminar.executeUpdate() == 1;
			//logger.debug(elimino ? usuario : null);
			return elimino;

		} catch (SQLException e) {
			//logger.error(e);
		}

		return false;
	}

	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();
		String sql = "select correo,AES_DECRYPT(clave,concat(?,correo)) as clave,fechaCreacion,activo from usuarios";
		try {
			if (preparedStatementListar == null) {
				preparedStatementListar = administradorMariaDB.getConnection().prepareStatement(sql);
			}
			preparedStatementListar.setString(1, administradorMariaDB.getLlave());

			ResultSet resultSet = preparedStatementListar.executeQuery();
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultSet.getString("correo"));
				usuario.setClave(resultSet.getString("clave"));
				usuario.setFechaCreacion(DateUtils.getLocalDateTime(resultSet.getString("fechaCreacion"),
						DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS_24H)

				);
				usuario.setActivo(resultSet.getBoolean("activo"));
				lista.add(usuario);
			}

		} catch (SQLException e) {
			//logger.error(e);
		}

		return lista;
	}

}
