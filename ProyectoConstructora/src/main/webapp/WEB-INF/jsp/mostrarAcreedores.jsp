<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA DE ACREEDORES</title>
<style type="text/css">
	tr:nth-child(2n+1)
	{		
		color:white;
		background-color: #F06A21;
	}
	
</style>
</head>
<body>
<center>
	<br><br><br>
	<div style="font-size:15px">LISTA DE ACREEDORES</div>
	<br>
	<br>
	<c:if test="${!empty listaAcreedores}">
		<table >
			<tr>
				<th><strong>NOMBRE</strong></th>
				<th><strong>N. CORTO</strong></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${listaAcreedores}" var="acreedor">				
				<tr>
					<td><c:out value="${acreedor.nombre}"></c:out></td>
					<td><c:out value="${acreedor.ncorto}"></c:out>
					<spring:url var="modificar" value="/modificarAcreedor.acme/${acreedor.idacreedor}" />
					<spring:url var="eliminar" value="/eliminarAcreedor.acme/${acreedor.idacreedor}" />
					<td><a href="javascript: cargar_cn_parametro(0,4,'cont_acreedor','ACREEDORES',${acreedor.idacreedor});" class="parent"><img  src="resources/imgs/edit.png" height="20" width="20"></a></td>
					<td><a href="javascript: cargar_cn_parametro(0,3,'cont_acreedor','ACREEDORES',${acreedor.idacreedor});" class="parent"><img  src="resources/imgs/trash.png" height="20" width="20"></a></td>									
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<spring:url value="/volverAcreedor.acme" var="volver" />
	<a href="javascript:cargar_sn_parametros(0,5,'cont_acreedor','ACREEDORES')">AGREGAR ACREEDOR</a>
</center>
</body>
</html>