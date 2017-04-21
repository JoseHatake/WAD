<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mx.ipn.escom.wad.controlacceso.mapeo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Modificar Usuario</h1>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null) {
	%>
	<h3><%=mensaje%></h3>
	<%
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String fechaString = format.format(usuario.getNacimiento());
	%>
	<form action="EliminarUsuario" method="post">
		<div>
			<input type="hidden" name="idUsuario" value="<%=usuario.getId()%>">
			<div>Nombre</div>
			<div>
				<%=getString(usuario.getNombre())%>
			</div>
		</div>
		<div>
			<div>Primer Apellido:</div>
			<div>
				<%=getString(usuario.getPrimerApellido())%>
			</div>
		</div>
		<div>
			<div>Segundo Apellido</div>
			<div><%=getString(usuario.getSegundoApellido())%></div>
		</div>
		<div>
			<div>Nacimiento</div>
			<div>
				<%=fechaString%>
			</div>
		</div>
		<div>
			<a href="../GestionarUsuarioCtrl">Cancelar</a><input type="submit"
				value="Aceptar">
		</div>
	</form>
</body>

<%!public String getString(String valor) {
		return valor != null ? valor : "";
	}%>
</html>