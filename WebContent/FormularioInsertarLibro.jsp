<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturaJavaSolida.Libro"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<title>Formulario Libro</title>
	<link rel="stylesheet" type="text/css" href= "css/formato.css"/> 
	<script type="text/javascript">
		function validacion() {
			var isbn=document.getElementById("isbn");
			var miformulario=document.getElementById("formularioInsercion");
			
			if(isbn.value==""){
				alert("datos no validos");
				return false;
			} else {
				miformulario.submit();
			}
		}
	</script>	
</head>
<body>
	<form id="formularioInsercion" action="InsertarLibro.jsp" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta Libro</legend>
			<p><label for="isbn">ISBN:</label><input id="isbn" type="text" name="isbn" /></p>
			<p><label for="titulo">Título:</label><input id="titulo" type="text" name="titulo" /></p>
			<p><label for="categoria">Categoría:</label>
				<select name="categoria" id="categoria">
					<option value="seleccionar">seleccionar</option>
					<%
						List<String> listaDeCategorias = null;
						listaDeCategorias = Libro.buscarTodasLasCategorias();

						for (String categoria:listaDeCategorias) {
					%>
							<option value="<%=categoria%>"><%=categoria%></option>
					<%	}	%>
					
				</select>
			</p>
			<p><input type="submit" value="Insertar" /></p>
		</fieldset>
	</form>
</body>
</html>