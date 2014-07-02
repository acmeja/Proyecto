
/*
 Controla y Hace peticiones al servidor en base los elementos del menu 
 alguna otra peticion dentro de un formulario
*/

var menu_matriz = new Array(5);


/*REQUEST ACREEDORES*/
menu_matriz[0] = new Array(6);
menu_matriz[0][0] = "agregarAcreedor.acme";
menu_matriz[0][1] = "mostrarAcreedores.acme";
menu_matriz[0][2] = "actualizarAcreedor.acme";
menu_matriz[0][3] = "eliminarAcreedor.acme";
menu_matriz[0][4] = "modificarAcreedor.acme";
menu_matriz[0][5] = "volverAcreedor.acme";

/*REQUEST's CLIENTES */
menu_matriz[1] = new Array(6);
menu_matriz[1][0] = "agregarCliente.acme";
menu_matriz[1][1] = "mostrarClientes.acme";
menu_matriz[1][2] = "actualizarCliente.acme";
menu_matriz[1][3] = "eliminarCliente.acme";
menu_matriz[1][4] = "modificarCliente.acme";
menu_matriz[1][5] = "volverCliente.acme";

/*REQUEST's CONTACTOS CLIENTE */
menu_matriz[2] = new Array(6);
menu_matriz[2][0] = "agregarContactoCliente.acme";
menu_matriz[2][1] = "mostrarContactoClientes.acme";
menu_matriz[2][2] = "actualizarContactoCliente.acme";
menu_matriz[2][3] = "eliminarContactoCliente.acme";
menu_matriz[2][4] = "modificarContactoCliente.acme";
menu_matriz[2][5] = "volverContactoCliente.acme";


function cargar_sn_parametros(x,y,cont,tit)
{
	var nomconte = "#"+crear_ventana_dialog(cont,tit);
	$(nomconte).dialog({ height: 600 },{ width: 1300 });

	$.ajax({
			type: "GET",
			url: menu_matriz[x][y],
			beforeSend: function()
			{
				///$(nomconte).html("<div class=\"spin\" data-spin />");
				$(nomconte).html("Cargando...");
			},
			context: document.body
			}).
			done(function(data)
					{
						$(nomconte).html(data);
					}
			
	);	
}

function cargar_cn_parametro(x,y,cont,tit,param)
{
	if ( y == 3) // la variable "y" indica la posicion del request para eliminar 
	{																// por lo tanto se debe tener cuidado al momento de poner el request en esta posicion
		if (confirm("¿ESTA SEGURO DE REALIZAR ESTA ACCIÓN?"))
		{
			var nomconte = "#"+crear_ventana_dialog(cont,tit);
			$(nomconte).dialog({ height: 600 },{ width: 1300 });

			$.ajax({
					type: "GET",
					url: menu_matriz[x][y]+"/"+param,
					beforeSend: function()
					{
						//$(nomconte).html("<div class=\"spin\" data-spin />");
						$(nomconte).html("Cargando...");
					},
					context: document.body
					}).
					done(function(data)
							{
								$(nomconte).html(data);
							}
				
			);	

		}
		
	}
	else
	{
		var nomconte = "#"+crear_ventana_dialog(cont,tit);
		$(nomconte).dialog({ height: 600 },{ width: 1300 });

		$.ajax({
				type: "GET",
				url: menu_matriz[x][y]+"/"+param,
				beforeSend: function()
				{
					//$(nomconte).html("<div class=\"spin\" data-spin />");
					$(nomconte).html("Cargando...");
				},
				context: document.body
				}).
				done(function(data)
						{
							$(nomconte).html(data);
						}
			
		);	

	}
}

function submit_enviar_formulario(x,y,cont,tit,form)
{

	var nomconte = "#"+crear_ventana_dialog(cont,tit);
	$(nomconte).dialog({ height: 600 },{ width: 1300 });

	
	alert(menu_matriz[x][y]);
	$.ajax
	({
		type: "POST",
		url: menu_matriz[x][y],
		data: $("#"+form).serialize(),
		beforeSend: function()
			{
				//$(nomconte).html("<div class=\"spin\" data-spin />");
				$(nomconte).html("Cargando...");
			},
		success: function (data)
		{
			$(nomconte).html(data);
		}
	});

}

function crear_ventana_dialog(iddiv,titulo)
{

	if (document.getElementById(iddiv) == null)
	{
		$("#divprincipal").append("<div id=\""+iddiv+"\" style=\"font-size: 62.5%;\" title=\""+titulo+"\"></div>");
	}

	return iddiv;

}

