package com.educacionit;

public class UsuarioServicioProxy implements com.educacionit.UsuarioServicio {
  private String _endpoint = null;
  private com.educacionit.UsuarioServicio usuarioServicio = null;
  
  public UsuarioServicioProxy() {
    _initUsuarioServicioProxy();
  }
  
  public UsuarioServicioProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioServicioProxy();
  }
  
  private void _initUsuarioServicioProxy() {
    try {
      usuarioServicio = (new com.educacionit.UsuarioServicioServiceLocator()).getServicioUsuario();
      if (usuarioServicio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuarioServicio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuarioServicio != null)
      ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.educacionit.UsuarioServicio getUsuarioServicio() {
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio;
  }
  
  public void buscarUsuarioPorCorreo(javax.xml.rpc.holders.StringHolder correo, javax.xml.rpc.holders.BooleanWrapperHolder activo, javax.xml.rpc.holders.StringHolder clave, javax.xml.rpc.holders.CalendarHolder fechaCreacion) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    usuarioServicio.buscarUsuarioPorCorreo(correo, activo, clave, fechaCreacion);
  }
  
  public void guardarUsuario(com.educacionit.UsuarioDTO usuario) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    usuarioServicio.guardarUsuario(usuario);
  }
  
  public boolean eliminarUsuario(com.educacionit.UsuarioDTO usuario) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.eliminarUsuario(usuario);
  }
  
  public com.educacionit.UsuarioDTO[] listarUsuarios() throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.listarUsuarios();
  }
  
  
}