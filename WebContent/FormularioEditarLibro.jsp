<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import ="com.arquitecturaJavaSolida.Libro"%>
<% Libro libro = Libro.buscarPorClave (request.getParameter("isbn"));%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulario editar libro</title>
	<link rel="stylesheet" type="text/css" href= "css/formato.css"/>
</head>
<body>
	<form id="formularioEdicion" action="SalvarLibro.jsp">
	<fieldset>
		<legend>Formulario editar libro</legend>
		<p><label for="isbn">ISBN:</label><input id ="isbn" type="text" name="isbn" value="<%=libro.getIsbn()%>"/></p>
		<p><label for="titulo">Título:</label><input id="titulo" type="text" name="titulo" value="<%=libro.getTitulo()%>"/></p>
		<p><label for="categoria">Categoría:</label>
			<select name="categoria" id="categoria">
				<%
					List<String> listaDeCategorias = null;
					listaDeCategorias = Libro.buscarTodasLasCategorias();

					for (String categoria:listaDeCategorias) {
				%>
						<option value="<%=categoria%>"<%if (libro.getCategoria().equals(categoria)){%> selected="selected" <%}%>><%=categoria%></option>
				<%
					}
				%>
			</select>
		<br/>
		</p>
		<p><input type="submit" value="Salvar" /></p>
	</fieldset>
	</form>
</body>
</html>