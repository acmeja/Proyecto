<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONTACTO CLIENTE</title>
</head>
<body>
	<center>
<br><br><br>
<div style="font-size:15px">${mensajeContactoCliente}</div>
<br>
<br>                                              
<form:form id="frmagregarContactoCliente" modelAttribute="contactoClienteForm" method="post" action="">
	<table>
		<tr>
			<form:input path="idcliente" />
				
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
					<c:when test="${mensajeContactoCliente != 'AGREGAR CONTACTO CLIENTE'}">						
						<input type="button" value='MODIFICAR' onclick="submit_enviar_formulario(2,2,'cont_contactocliente','CONTACTO CLIENTTE','frmagregarContactoCliente');" />
					</c:when>
				<c:otherwise>
					<input type="button" value='AGREGAR' onclick="submit_enviar_formulario(2,0,'cont_contactocliente','CONTACTO CLIENTTE','frmagregarContactoCliente');" />
				</c:otherwise>
					</c:choose>
			</td>
		</tr>
		
	</table>
</form:form>
<br><br>
	<a href="javascript:cargar_sn_parametros(2,1,'cont_contactocliente','CONTACTOS CLIENTES')"">VER LISTA DE CONTACTOS</a>
	</center>
</body>
</html>