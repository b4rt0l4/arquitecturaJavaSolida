<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Error</title>
</head>
<body>
	<p>Ha ocurrido un error en la aplicación :<%=exception.getMessage()%></p>
	<p>Error Interno:<%=exception.getCause().getMessage()%></p>
</body>
</html>