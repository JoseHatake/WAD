<%@page import="mx.ipn.escom.wad.controlacceso.mapeo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestionar Usuarios</h1>
	<%List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");%>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Nombre Copleto</th>
				<th>Primer Apellido</th>
				<th>Segundo Apellido</th>
				<th>Fecha de Nacimiento</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<%for(Usuario u:usuarios){%>
			<tr>
				<td><%=u.getNombre()%></td>
				<td><%=nombreCompleto(u)%></td>
				<td><%=u.getPrimerApellido()%></td>
				<td><%=u.getSegundoApellido()%></td>
				<td><%=u.getNacimiento()%></td>
				<td><a href="ModificarUsuario?idUsuario=<%=u.getId()%>">M</a><a href="EliminarUsuario?idUsuario=<%=u.getId()%>">E</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<a href="RegistrarUsuario">Agregar</a>
</body>
</html>

<%!
	public String nombreCompleto(Usuario u){
		return u.getNombre()+" "+u.getPrimerApellido()+" "+u.getSegundoApellido();
	}
%>