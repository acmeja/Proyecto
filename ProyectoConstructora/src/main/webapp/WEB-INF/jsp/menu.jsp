<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>MENU</title>
		
		<link href="resources/css/style.css"  rel="stylesheet"/>
		<link href="resources/dialogo/css/jquery-ui.css"  rel="stylesheet"/>
		<link href="resources/css/jquery.spin.css"  rel="stylesheet"/>
		
		<script type="text/javascript" src="resources/dialogo/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="resources/dialogo/js/jquery-ui.js"></script>
		<script type="text/javascript" src="resources/js/menu_ctrl.js"></script>
		<script type="text/javascript" src="resources/js/jquery.spin.js"></script>
		<script type="text/javascript" >
		</script>	
</head>
<body style="background-color:#EBEBEB">
<!-- Start css3menu.com BODY section -->
<ul id="css3menu1" class="topmenu" align="center">
<input type="checkbox" id="css3menu-switcher" class="switchbox"><label onclick="" class="switch" for="css3menu-switcher"></label>	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;"><span>BANCOS</span></a>
	<ul>
	<spring:url var="operaciones" value="/mostrarOperaciones.html"/>
		<li class="subfirst"><a href="${operaciones}">OPERACIONES</a></li>
		<li><a href="#">BANCO</a></li>
		<li class="sublast"><a href="#"><span>CUENTAS</span></a>
		<ul>
			<li class="subfirst"><a href="#">CHEQUES</a></li>
			<li class="sublast"><a href="#">CONSULTAR</a></li>
		</ul></li>
	</ul></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;"><span>CLIENTES</span></a>
	<ul>
		<li class="subfirst">
			<a href="javascript:cargar_sn_parametros(1,1,'cont_cliente','CLIENTES')">CONSULTAR</a>
		</li>
		<li><a href="#">SALDOS</a></li>
		<li class="sublast"><a href="#">OBRA</a></li>
	</ul></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">PROVEEDORES</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">EQUIPO</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">COMISIONISTAS</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">COBRANZA</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">DEUDORES</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">ACREEDORES</a>
		<ul>
			<li class="subfirst"><a href="javascript:cargar_sn_parametros(0,1,'cont_acreedor','ACREEDORES')">CONSULTAR</a></li>			
		</ul>
	</li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">ESTIMACIONES</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">EMPRESA</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">EMPLEADO</a></li>
	<li class="topmenu"><a href="#" style="height:16px;line-height:16px;">AGENDA</a></li>
</ul>
<!-- End css3menu.com BODY section -->
<div id="divprincipal" name="divprincipal">

</div>
<div id="divoper" style="font-size: 62.5%;" title="Operaciones Generales">

</div>

</body>
</html>