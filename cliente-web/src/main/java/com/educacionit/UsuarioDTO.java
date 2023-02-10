/**
 * UsuarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit;

public class UsuarioDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.Boolean activo;

	private java.lang.String clave;

	private java.lang.String correo;

	private java.util.Calendar fechaCreacion;

	public UsuarioDTO() {
	}

	public UsuarioDTO(java.lang.Boolean activo, java.lang.String clave, java.lang.String correo,
			java.util.Calendar fechaCreacion) {
		this.activo = activo;
		this.clave = clave;
		this.correo = correo;
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "UsuarioDTOServicioWEB [activo=" + activo + ", clave=" + clave + ", correo=" + correo
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}

	/**
	 * Gets the activo value for this UsuarioDTO.
	 * 
	 * @return activo
	 */
	public java.lang.Boolean getActivo() {
		return activo;
	}

	/**
	 * Sets the activo value for this UsuarioDTO.
	 * 
	 * @param activo
	 */
	public void setActivo(java.lang.Boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the clave value for this UsuarioDTO.
	 * 
	 * @return clave
	 */
	public java.lang.String getClave() {
		return clave;
	}

	/**
	 * Sets the clave value for this UsuarioDTO.
	 * 
	 * @param clave
	 */
	public void setClave(java.lang.String clave) {
		this.clave = clave;
	}

	/**
	 * Gets the correo value for this UsuarioDTO.
	 * 
	 * @return correo
	 */
	public java.lang.String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo value for this UsuarioDTO.
	 * 
	 * @param correo
	 */
	public void setCorreo(java.lang.String correo) {
		this.correo = correo;
	}

	/**
	 * Gets the fechaCreacion value for this UsuarioDTO.
	 * 
	 * @return fechaCreacion
	 */
	public java.util.Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Sets the fechaCreacion value for this UsuarioDTO.
	 * 
	 * @param fechaCreacion
	 */
	public void setFechaCreacion(java.util.Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof UsuarioDTO))
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.activo == null && other.getActivo() == null)
						|| (this.activo != null && this.activo.equals(other.getActivo())))
				&& ((this.clave == null && other.getClave() == null)
						|| (this.clave != null && this.clave.equals(other.getClave())))
				&& ((this.correo == null && other.getCorreo() == null)
						|| (this.correo != null && this.correo.equals(other.getCorreo())))
				&& ((this.fechaCreacion == null && other.getFechaCreacion() == null)
						|| (this.fechaCreacion != null && this.fechaCreacion.equals(other.getFechaCreacion())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getActivo() != null) {
			_hashCode += getActivo().hashCode();
		}
		if (getClave() != null) {
			_hashCode += getClave().hashCode();
		}
		if (getCorreo() != null) {
			_hashCode += getCorreo().hashCode();
		}
		if (getFechaCreacion() != null) {
			_hashCode += getFechaCreacion().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			UsuarioDTO.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://educacionit.com", "usuarioDTO"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("activo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "activo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("clave");
		elemField.setXmlName(new javax.xml.namespace.QName("", "clave"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("correo");
		elemField.setXmlName(new javax.xml.namespace.QName("", "correo"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("fechaCreacion");
		elemField.setXmlName(new javax.xml.namespace.QName("", "fechaCreacion"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
