<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <% java.text.DateFormat df= new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LISTA DE OPERACIONES</title>

</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">OPERACIONES</div>
<br><br>
<c:if test="${!empty listaOperaciones}">
<table border="1"  >
<tr >
<td>ID</td>
<td>No.</td>
<td>DIA</td>
<td>FECHA</td>
<td>FOLIO</td>
<td>MOV</td>
<td>DESCRIPCION</td>
<td>CARGO</td>
<td>ABONO</td>
<td>SALDO</td>
<td>DESTINO</td>
<td>CONT/REM.</td>
</tr>
<c:forEach items="${listaOperaciones}" var="operacion">
<tr  >
<td><c:out value="${operacion.idoperacion}"/></td>
<td><c:out value="${operacion.orden}"/></td>
<td><c:out value="${df. operacion.fecha}"/></td>
<td>
	<fmt:formatDate type="date" value="${operacion.fecha}"  dateStyle="long"  />	
	<fmt:formatNumber type="number" value="${operacion.importe}" pattern="$#,##0.00" var="importe" />	
	<fmt:formatNumber type="number" value="${operacion.saldo}" pattern="$#,##0.00" var="saldo" />
	<c:out value="${fechaoper}" />
</td>
<td><c:out value="${operacion.folio}"/></td>
<td><c:out value="${operacion.movncorto}"/></td>
<td><c:out value="${operacion.descripcion}"/></td>
<c:if test="${operacion.movncorto == 'NDPC' || operacion.movncorto == 'DEP' || operacion.movncorto == 'ESP' }">
	<td>
		<c:out value="${importe}"/>
	</td>
	<td></td>	
</c:if>
<c:if test="${operacion.movncorto != 'NDPC' && operacion.movncorto != 'DEP' && operacion.movncorto != 'ESP' }">	
	<td></td>	
	<td><c:out value="${importe}"/></td>
</c:if>
<td><c:out value="${saldo}"/></td>
<td><c:out value="${operacion.destin}"/></td>
<td></td>
<spring:url var="modificar" value="/modificarComponentes.html/${operacion.idoperacion}"/>
<spring:url var="eliminar" value="/eliminarComponentes.html/${operacion.idoperacion}"/>
 <td><a href="${modificar}" class="parent"><img  src="resources/imgs/edit.png" height="20" width="20"></a></td>
  <td><a href="${eliminar}" class="parent"><img  src="resources/imgs/trash.png" height="20" width="20"></a></td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<spring:url var="volver" value="/volverComponente.html"/>
<a href="${volver}" >Agrega un nuevo componente</a>
</center>
</body>
</html>