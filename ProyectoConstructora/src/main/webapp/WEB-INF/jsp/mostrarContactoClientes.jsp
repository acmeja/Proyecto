<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONTACTOS CLIENTE</title>
</head>
<body>
<center>
	<br><br><br>
	<div style="font-size:15px">LISTA DE CONTACTOS</div>
	<br>
	<br>   		
	<input type="hidden" value="${idcliente}">		 
	<c:if test="${!empty listaContactoClientes}">
		<table >
			<tr>
				<th><strong>NOMBRE</strong></th>
				<th><strong>N. CORTO</strong></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<% Integer idcliente; %>
			<c:forEach items="${listaContactoClientes}" var="cliente_contacto">				
				<tr>
					<td><c:out value="${cliente_contacto.nombre}"></c:out></td>
					<td><c:out value="${cliente_contacto.ncorto}"></c:out></td>
					<td><a href="javascript: cargar_cn_parametro(2,4,'cont_cliente','CONTACTO CLIENTES','${cliente_contacto.nombre}');" class="parent"><img  src="resources/imgs/edit.png" height="20" width="20"></a></td>
					<td><a href="javascript: cargar_cn_parametro(2,3,'cont_cliente','CONTACTO CLIENTES','${cliente_contacto.nombre}');" class="parent"><img  src="resources/imgs/trash.png" height="20" width="20"></a></td>									
				</tr>
				
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="javascript:cargar_cn_parametro(2,5,'cliente','CONTACTO CLIENTES',${idcliente});">AGREGAR CONTACTO CLIENTE</a>##
	<a href="javascript:cargar_sn_parametros(1,1,'cliente','CLIENTES')">REGRESAR</a>
</center>

</body>
</html>