<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulario editar libro</title>
	<link rel="stylesheet" type="text/css" href= "css/formato.css"/>
</head>
<body>
	
	<form id="formularioEdicion" action="ModificarLibro.do">
	<fieldset>
		<legend>Formulario editar libro</legend>
		<p><label for="isbn">ISBN:</label><input id ="isbn" type="text" name="isbn" value="${libro.isbn}"/></p>
		<p><label for="titulo">Título:</label><input id="titulo" type="text" name="titulo" value="${libro.titulo}"/></p>
		<p><label for="categoria">Categoría:</label>
			<select name="categoria" id="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria.id}"
						<c:if test="${categoria.id == libro.categoria.id}"> selected="selected"</c:if>
					>${categoria.descripcion}</option>
				</c:forEach>		
			</select>
		</p>
		<p><input type="submit" value="Salvar" /></p>
	</fieldset>
	</form>
</body>
</html>