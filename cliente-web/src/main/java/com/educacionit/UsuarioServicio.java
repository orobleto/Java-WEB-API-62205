/**
 * UsuarioServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit;

public interface UsuarioServicio extends java.rmi.Remote {
    public void buscarUsuarioPorCorreo(javax.xml.rpc.holders.StringHolder correo, javax.xml.rpc.holders.BooleanWrapperHolder activo, javax.xml.rpc.holders.StringHolder clave, javax.xml.rpc.holders.CalendarHolder fechaCreacion) throws java.rmi.RemoteException;
    public void guardarUsuario(com.educacionit.UsuarioDTO usuario) throws java.rmi.RemoteException;
    public boolean eliminarUsuario(com.educacionit.UsuarioDTO usuario) throws java.rmi.RemoteException;
    public com.educacionit.UsuarioDTO[] listarUsuarios() throws java.rmi.RemoteException;
}
