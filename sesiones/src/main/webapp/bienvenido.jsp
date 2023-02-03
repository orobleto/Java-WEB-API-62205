<%@page import="com.educacionit.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (null == usuario) {
		response.sendRedirect("index.jsp");
	} else {
	%>

	<h1>Bienvenido</h1>
	<h2><%=usuario.getCorreo()%></h2>
	<h3><%=session.getId()%></h3>
	<a href="login?cerrarSesion=true">Cerrar Sesion</a>

	<%
	}
	%>

</body>
</html>