<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturaJavaSolida.aplicacion.Libro"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de libros</title>
</head>
<body>
	<form name="filtroCategoria" id="filtroCategoria" action="Filtrar.do">
		<select name="categoria">
			<option value="seleccionar">seleccionar</option>
			<%
				@SuppressWarnings("unchecked")
				List<String> listaDeCategorias = (List<String>)request.getAttribute("listaDeCategorias");
				
				for (String categoria:listaDeCategorias) {
			%>
					<option value="<%=categoria%>"><%=categoria%></option>
			<%	}	%>
		</select>
		<input type="submit" value = "filtrar">
		<br/>
	</form>

	<%
		@SuppressWarnings("unchecked")
		List<Libro> listaDeLibros = (List<Libro>)request.getAttribute("listaDeLibros");

		for (Libro libro:listaDeLibros) {
	%>
			<%=libro.getIsbn()%>
			<%=libro.getTitulo()%>
			<%=libro.getCategoria()%>
			<a href = "BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
			<a href = "FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
			<br/>
	<%	}	%>
	<a href="FormularioInsertarLibro.do">Insertar libro</a>
</body>
</html>