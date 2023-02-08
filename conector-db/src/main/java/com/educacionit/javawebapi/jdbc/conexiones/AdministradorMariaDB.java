package com.educacionit.javawebapi.jdbc.conexiones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AdministradorMariaDB {
	private static Logger logger = LogManager.getLogger();
	private static AdministradorMariaDB administradorMariaDB;
	private Connection connection;
	private String llave;

	private AdministradorMariaDB() {
		setConnection();
	}

	public static AdministradorMariaDB getInstancia() {
		if (administradorMariaDB == null) {
			administradorMariaDB = new AdministradorMariaDB();
		}

		return administradorMariaDB;
	}

	public String getLlave() {
		return llave;
	}

	private void setLlave(String llave) {
		this.llave = llave;
	}

	public Connection getConnection() {
		return connection;
	}

	private void setConnection() {

		try {
			Properties propiedades = new Properties();
			propiedades
					.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("basededatos.properties"));
			String driver = propiedades.getProperty("db.driver");
			String url = propiedades.getProperty("db.url");
			String usuario = propiedades.getProperty("db.usuario");
			String clave = propiedades.getProperty("db.clave");

			setLlave(propiedades.getProperty("db.llave"));

			Class.forName(driver);
			connection = DriverManager.getConnection(url, usuario, clave);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

	}

}
