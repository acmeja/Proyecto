<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SELECCIONAR SISTEMA</title>
</head>
<body>
<%
	Integer inte  = (Integer) session.getAttribute("baseDatosForm");
%>
<c:if test="${mensaje !='Usuario Correcto'}">
    <h4>${mensaje}</h4>
</c:if>
 
<spring:url var="inicializarLogin" value="/inicializarLogin.html"/>
 
<form:form id="sel_bd" modelAttribute="baseDatosForm" method="post" action="${inicializarLogin}">

    <table width="400px" height="150px" align="center">
    <tr align="center">
    	<td><h2>SELECCIONA BASE DE DATOS</h2></td>
    </tr>
        <tr align="center">
        <td>
        	<form:select  path="basededatos">
        		<form:option value="2014">SISTEMA 2014</form:option>
        		<form:option value="2013">SISTEMA 2013</form:option>
        		<form:option value="2012">SISTEMA 2012</form:option>
        	</form:select>
        		
        </td>
        </tr>
        <tr align="center"><td>
        <input type="submit" value="ACEPTAR" />
        </td></tr>
    </table>
</form:form>
</body>
</html>