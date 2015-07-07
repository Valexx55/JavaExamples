<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi segundo JSP</title>
</head>
<body>



<jsp:declaration>
int n = 0;
</jsp:declaration>

<jsp:scriptlet>n++;</jsp:scriptlet><%--SCRIPTLET --%>

<p>EL usuario está llamando <jsp:expression>n</jsp:expression> veces <%--EXPRESIÓN! --%>
<p>Luego es un número de veces
<jsp:scriptlet>if ((n%2)==0) { </jsp:scriptlet><b>par</b>
<b><jsp:scriptlet>} else { </jsp:scriptlet> impar <jsp:scriptlet>} </jsp:scriptlet> </b>

</body>
</html>