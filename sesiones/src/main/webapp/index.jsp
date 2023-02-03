<%@page import="com.educacionit.enumerados.MensajesFront"%>
<%@page import="com.educacionit.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<body>

	<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (null != usuario) {
		response.sendRedirect("bienvenido.jsp");
	}
	%>

	<!-- solo dos verbos el get y post -->
	<form action="login" method="post">
		<div>
			<label for="correo">Email</label> <input id="correo" name="correo"
				type="email">
		</div>

		<div>
			<label for="clave">Clave</label> <input id="clave" name="clave"
				type="password">
		</div>

		<div>
			<button type="submit">Enviar</button>
		</div>

	</form>

	<%
	MensajesFront mensaje = (MensajesFront) request.getAttribute("mensaje");

	if (null != mensaje) {
	%>
	<h1 style="color: <%=mensaje.getColor()%>"><%=mensaje.getMensaje()%></h1>

	<%
	}
	%>
</body>



</html>
