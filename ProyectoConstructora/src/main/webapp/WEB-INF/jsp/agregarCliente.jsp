<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CLIENTES</title>
</head>
<body>
	<center>
<br><br><br>
<div style="font-size:15px">${mensajeCliente}</div>
<br>
<br>                                              
<form:form id="frmagregarCliente" modelAttribute="clienteForm" method="post" action="">
	<table>
		<tr>
			<form:hidden path="idcliente"/>
			<form:hidden path="activo" value="1"/>
			<td><form:label path="razon">RAZON:</form:label></td>
			<td><form:input path="razon"/></td>
		</tr>
		<tr>
			<td><form:label path="ncorto">NOMBRE CORTO:</form:label></td>
			<td><form:input path="ncorto"/></td>
		</tr>
		<tr>
			<td><form:label path="rfc">RFC::</form:label></td>
			<td><form:input path="rfc"/></td>
		</tr>
		<tr>
			<td><form:label path="mail">E-MAIL:</form:label></td>
			<td><form:input path="mail"/></td>
		</tr>
		<tr>
		<td></td>
			<td>
				<c:choose>
					<c:when test="${mensajeCliente != 'AGREGAR CLIENTE'}">						
						<input type="button" value='MODIFICAR' onclick="submit_enviar_formulario(1,2,'cont_cliente','CLIENTTE','frmagregarCliente');" />
					</c:when>
				<c:otherwise>
					<input type="button" value='AGREGAR' onclick="submit_enviar_formulario(1,0,'cont_cliente','CLIENTTE','frmagregarCliente');" />
				</c:otherwise>
					</c:choose>
			</td>
		</tr>
		
	</table>
</form:form>
<br><br>
	<a href="javascript:cargar_sn_parametros(1,1,'cont_cliente','CLIENTES')"">VER LISTA DE CLIENTES</a>
	</center>
</body>
</html>