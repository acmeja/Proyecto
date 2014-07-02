<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto Constructora GRUPO ALIMO</title>
</head>
<body>
<c:if test="${mensaje !='Usuario Correcto'}">
    <h4>${mensaje}</h4>
</c:if>
 <%@page import="com.javi.acme.formulario.BaseDatosForm"%>
 <% BaseDatosForm bd =(BaseDatosForm)  session.getAttribute("basedatos"); %>
<spring:url var="verificarLogin" value="/verificarLogin.html"/>
 
<form:form id="login" modelAttribute="usuarioForm" method="post" action="${verificarLogin}">
<h2 align="center">ACCESO AL SISTEMA</h2>
    <table width="400px" height="150px" align="center">
    	<tr>
    		<td>SISTEMA: <%=bd.getBasededatos()%></td>
    		<td><form:hidden path=""/></td>
    	</tr>
        <tr>        
        <td><form:label path="usuario">Nombre:</form:label></td>
        <td><form:input  path="usuario"/></td>
        </tr>
        <tr>
        <td><form:label path="password">Clave:</form:label></td>
        <td><form:input type="password" path="password"/></td>
        </tr>
        <tr align="center"><td></td><td>
        <input type="submit" value="Login" />
        </td></tr>
    </table>
</form:form>
</body>
</html>