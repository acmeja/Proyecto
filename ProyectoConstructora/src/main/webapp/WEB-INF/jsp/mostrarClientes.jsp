<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CLIENTES</title>
</head>
<body>
<center>
	<br><br><br>
	<div style="font-size:15px">LISTA DE CLIENTES</div>
	<br>
	<br>
	<c:if test="${!empty listaClientes}">
		<table >
			<tr>
				<th><strong>RAZON</strong></th>
				<th><strong>N. CORTO</strong></th>
				<th><strong>RFC</strong></th>
				<th><strong>MAIL</strong></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${listaClientes}" var="cliente">				
				<tr>
					<td><c:out value="${cliente.razon}"></c:out></td>
					<td><c:out value="${cliente.ncorto}"></c:out></td>
					<td><c:out value="${cliente.rfc}"></c:out></td>
					<td><c:out value="${cliente.mail}"></c:out></td>
					<td><a href="javascript: cargar_cn_parametro(1,4,'cont_cliente','CLIENTES',${cliente.idcliente});" class="parent" title="MODIFICAR"><img  src="resources/imgs/edit.png" height="20" width="20"></a></td>
					<td><a href="javascript: cargar_cn_parametro(1,3,'cont_cliente','CLIENTES',${cliente.idcliente});" class="parent" title="ELIMINAR"><img  src="resources/imgs/trash.png" height="20" width="20"></a></td>									
					<td><a href="javascript: cargar_cn_parametro(2,1,'cont_cliente','CONTACTO CLIENTES',${cliente.idcliente});" class="parent" title="CONTACTO(S)"><img  src="resources/imgs/contact.jpg" height="20" width="20"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<a href="javascript:cargar_sn_parametros(1,5,'cont_cliente','CLIENTES')">AGREGAR CLIENTE</a>
</center>
</body>
</html>