<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="com.arquitecturaJavaSolida.Libro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Borrar libro</title>
</head>
<body>
	<%
		String isbn = request.getParameter ("isbn");
		Libro libro = new Libro (isbn);
		libro.borrar();
		response.sendRedirect("MostrarLibros.jsp");
	%>
</body>
</html>