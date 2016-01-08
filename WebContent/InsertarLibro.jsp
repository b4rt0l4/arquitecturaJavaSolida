<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.arquitecturajavaSolida.Libro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		// recojo los datos del formulario 	
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
	
		//Realizo la consulta usando la clase Libro y el código queda simplificado
		Libro libro = new Libro(isbn, titulo, categoria);
		libro.insertar();
			 
		response.sendRedirect("MostrarLibros.jsp");
	%>
</body>
</html>