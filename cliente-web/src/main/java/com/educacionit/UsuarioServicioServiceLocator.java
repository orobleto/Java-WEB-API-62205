/**
 * UsuarioServicioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit;

public class UsuarioServicioServiceLocator extends org.apache.axis.client.Service implements com.educacionit.UsuarioServicioService {

    public UsuarioServicioServiceLocator() {
    }


    public UsuarioServicioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UsuarioServicioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioUsuario
    private java.lang.String ServicioUsuario_address = "http://localhost:8080/servicio-web/services/UsuarioServicio";

    public java.lang.String getServicioUsuarioAddress() {
        return ServicioUsuario_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioUsuarioWSDDServiceName = "ServicioUsuario";

    public java.lang.String getServicioUsuarioWSDDServiceName() {
        return ServicioUsuarioWSDDServiceName;
    }

    public void setServicioUsuarioWSDDServiceName(java.lang.String name) {
        ServicioUsuarioWSDDServiceName = name;
    }

    public com.educacionit.UsuarioServicio getServicioUsuario() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioUsuario_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioUsuario(endpoint);
    }

    public com.educacionit.UsuarioServicio getServicioUsuario(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.educacionit.ServicioUsuarioBindingStub _stub = new com.educacionit.ServicioUsuarioBindingStub(portAddress, this);
            _stub.setPortName(getServicioUsuarioWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioUsuarioEndpointAddress(java.lang.String address) {
        ServicioUsuario_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.educacionit.UsuarioServicio.class.isAssignableFrom(serviceEndpointInterface)) {
                com.educacionit.ServicioUsuarioBindingStub _stub = new com.educacionit.ServicioUsuarioBindingStub(new java.net.URL(ServicioUsuario_address), this);
                _stub.setPortName(getServicioUsuarioWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioUsuario".equals(inputPortName)) {
            return getServicioUsuario();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://educacionit.com", "UsuarioServicioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://educacionit.com", "ServicioUsuario"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioUsuario".equals(portName)) {
            setServicioUsuarioEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
