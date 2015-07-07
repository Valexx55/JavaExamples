<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi primer JSP</title>
</head>
<body>

<%!int n = 0; %><%--DECLARACIÓN! :) --%>

<%n++; %><%--SCRIPTLET --%>

<p>EL usuario está llamando <%=n%> veces <%--EXPRESIÓN! --%>
<p>Luego es un número de veces
<%if ((n%2)==0) { %><b>par</b>
<b><%} else { %> impar <%} %> </b>

</body>
</html>