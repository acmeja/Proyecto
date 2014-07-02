<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACREEDOR</title>
</head>
<body>
<center>
<br><br><br>
<div style="font-size:15px">${mensajeAcreedor}</div>
<br>
<br>
<c:choose>
	<c:when test="${ mensajeAcreedor != 'AGREGAR ACREEDOR'}">
		<spring:url var="accionAcreedor" value="actualizarAcreedor.acme" />	
	</c:when>
	<c:otherwise>
		<spring:url var="accionAcreedor" value="agregarAcreedor.acme" />
	</c:otherwise>
</c:choose>

<form:form id="frmagregarAcreedor" modelAttribute="acreedorForm" method="post" action="${accionAcreedor}">
	<table>
		<tr>
			<form:hidden path="idacreedor"/>
			<td><form:label path="nombre">NOMBRE:</form:label></td>
			<td><form:input path="nombre"/></td>
		</tr>
		<tr>
			<td><form:label path="ncorto">NOMBRE CORTO:</form:label></td>
			<td><form:input path="ncorto"/></td>
		</tr>
		<tr>
		<td></td>
			<td>
				<c:choose>
					<c:when test="${mensajeAcreedor != 'AGREGAR ACREEDOR'}">						
						<input type="button" value='MODIFICAR' onclick="submit_enviar_formulario(0,2,'cont_acreedor','ACREEDOR','frmagregarAcreedor');" />
					</c:when>
				<c:otherwise>
					<input type="button" value='AGREGAR' onclick="submit_enviar_formulario(0,0,'cont_acreedor','ACREEDOR','frmagregarAcreedor');" />
				</c:otherwise>
					</c:choose>
			</td>
		</tr>
		
	</table>
</form:form>
<br><br>
	<spring:url var="lista" value="/mostrarAcreedores.acme"></spring:url>
	<a href="javascript:cargar_sn_parametros(0,1,'cont_acreedor','ACREEDORES')"">VER LISTA DE ACREEDORES</a>
	</center>
</body>
</html>