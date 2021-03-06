<%@page import="mx.ipn.escom.wad.util.FieldErrors"%>
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
		FieldErrors fieldErrors = (FieldErrors) request.getAttribute("fieldErrors");
		if (mensaje != null) {
	%>
	<h3><%=mensaje%></h3>
	<%
		}
		String fechaString = null;
		if (usuario.getNacimiento() != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			fechaString = format.format(usuario.getNacimiento());
		} else {
			fechaString = "";
		}
	%>
	<form action="ModificarUsuario" method="post">
		<div>
			<div>Nombre</div>
			<input type="hidden" name="idUsuario" value="<%=usuario.getId()%>">
			<div>
				<input name="nombre" value="<%=getString(usuario.getNombre())%>" />
				<%
					if (fieldErrors.contains("nombre")) {
				%>
				<ul>
					<%
						for (String e : fieldErrors.get("nombre")) {
					%>
					<li><%=e%></li>
					<%
						}
					%>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		<div>
			<div>Primer Apellido:</div>
			<div>
				<input name="primerApellido"
					value="<%=getString(usuario.getPrimerApellido())%>" />
				<%
					if (fieldErrors.contains("primerApellido")) {
				%>
				<ul>
					<%
						for (String e : fieldErrors.get("primerApellido")) {
					%>
					<li><%=e%></li>
					<%
						}
					%>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		<div>
			<div>Segundo Apellido</div>
			<div>
				<input name="segundoApellido"
					value="<%=getString(usuario.getSegundoApellido())%>" />
				<%
					if (fieldErrors.contains("segundoApellido")) {
				%>
				<ul>
					<%
						for (String e : fieldErrors.get("segundoApellido")) {
					%>
					<li><%=e%></li>
					<%
						}
					%>
				</ul>
				<%
					}
				%>
			</div>
		</div>
		<div>
			<div>Nacimiento</div>
			<div>
				<input name="nacimiento" value="<%=fechaString%>" />
				<%
					if (fieldErrors.contains("nacimiento")) {
				%>
				<ul>
					<%
						for (String e : fieldErrors.get("nacimiento")) {
					%>
					<li><%=e%></li>
					<%
						}
					%>
				</ul>
				<%
					}
				%>
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