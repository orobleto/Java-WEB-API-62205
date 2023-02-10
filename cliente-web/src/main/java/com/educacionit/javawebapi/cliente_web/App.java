package com.educacionit.javawebapi.cliente_web;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.rpc.holders.BooleanWrapperHolder;
import javax.xml.rpc.holders.CalendarHolder;
import javax.xml.rpc.holders.StringHolder;

import com.educacionit.UsuarioDTO;
import com.educacionit.UsuarioServicio;
import com.educacionit.UsuarioServicioProxy;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(false, "98563", "oct6@gmail.com", Calendar.getInstance());
		System.out.println(usuarioDTO);

		UsuarioServicio usuarioServicio = new UsuarioServicioProxy();

		try {

			usuarioServicio.guardarUsuario(usuarioDTO);//, new BooleanWrapperHolder(true), new StringHolder("1234"),					new StringHolder("octavio@gmail.com"), new CalendarHolder(Calendar.getInstance()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
