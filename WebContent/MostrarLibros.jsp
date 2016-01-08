<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lista de libros</title>
</head>
<body>
	<% 
	Connection conexion=null;
	Statement  sentencia=null;
	ResultSet rs=null;
	try  {
		
		 Class.forName("com.mysql.jdbc.Driver");
		 //Conexión local
		 conexion = DriverManager.getConnection("jdbc:mysql://localhost/arquitecturajava", "arquitecturajava", "arquitecturajava");
		 sentencia = conexion.createStatement();
		 String consultaSQL =  "select isbn,titulo,categoria from libros";
	
		 rs=sentencia.executeQuery(consultaSQL);
		 
		 while(rs.next()) { %>
		 
			 <%=rs.getString("isbn")%>
			  <%=rs.getString("titulo")%>
			   <%=rs.getString("categoria")%>
				<br/>
		 
		 
		<% }
	
	}catch (ClassNotFoundException e) {
		
		System.out.println("Error en la carga del driver" 
							+ e.getMessage());
		
	}catch (SQLException e) {
		
		System.out.println("Error accediendo a la base de datos" 
							+ e.getMessage());
		
	}
	 finally {
		
	
		if (rs != null) {
	
			try {rs.close();} catch (SQLException e)
			{System.out.println("Error cerrando el resultset" + e.getMessage());}
			
		}
		
		if (sentencia != null) {
	
			try {sentencia.close();} catch (SQLException e) 
			{System.out.println("Error cerrando la sentencia" + e.getMessage());}
			
		}
		if (conexion != null) {
	
			try {conexion.close();} catch (SQLException e) 
			{System.out.println("Error cerrando la conexion" + e.getMessage());}
		}
	 }
	%>
	<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>

</body>
</html>