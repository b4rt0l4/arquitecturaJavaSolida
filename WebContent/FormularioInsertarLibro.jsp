<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<title>Formulario Libro</title>
	<link rel="stylesheet" type="text/css" href= "css/formato.css"/>
	<script type="text/javascript" src="js/validacion.js" ></script>
</head>
<body>
	<form id="formularioInsercion" action="InsertarLibro.do" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta Libro</legend>
			<p><label for="isbn">ISBN:</label><input id="isbn" type="text" name="isbn" /></p>
			<p><label for="titulo">Título:</label><input id="titulo" type="text" name="titulo" /></p>
			<p><label for="categoria">Categoría:</label>
				<select name="categoria" id="categoria">
					<option value="seleccionar">seleccionar</option>
					<c:forEach var="categoria" items="${listaDeCategorias}">
						<option value="${categoria.id}">${categoria.descripcion}</option>
					</c:forEach>
				</select>
			</p>
			<p><input type="submit" value="Insertar" /></p>
		</fieldset>
	</form>
</body>
</html>