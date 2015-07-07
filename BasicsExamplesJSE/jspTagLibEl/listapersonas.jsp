<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.microforum.cursojava.jee.Persona, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Persona> lista_personas = new ArrayList<Persona>();
lista_personas.add(new Persona(22, "Eva"));
lista_personas.add(new Persona(38, "Carmen"));
lista_personas.add(new Persona(25, "Juan"));
lista_personas.add(new Persona(61, "Jesús"));
session.setAttribute("lista_personas", lista_personas);
%>

<br>PRIMER FORMA, con puntos, recorrido tipo Iterator<br>
<c:forEach items="${lista_personas}" var="persona" varStatus="i">
	<c:out value="${persona.nombre}"></c:out>
	<c:if test="${persona.nombre eq 'Eva'}">
		<c:out value="${'La persona Eva está en la pos'}"></c:out>
		<c:out value="${i.index}"></c:out>
	</c:if>
	<c:out value="${persona.edad}"></c:out>
</c:forEach>
<br>


<br>SEGUNDA, especifico inicio y fin, recorrido tipo Array<br>
<c:forEach items="${lista_personas}" begin="0" end="3" varStatus="i">
	<c:out value="${lista_personas[i.index].nombre}"></c:out>
	<c:out value="${lista_personas[i.index].edad}"></c:out>
</c:forEach>

</body>
</html>