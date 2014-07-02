package com.javi.acme.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javi.acme.formulario.OperacionForm;
import com.javi.acme.servicios.OperacionService;
import com.javi.acme.servicios.OperacionServiceImpl;

@Controller
public class OperacionController
{
	private OperacionService operacionService = new OperacionServiceImpl();	
	private OperacionForm operacionForm = new OperacionForm();
	
	@RequestMapping(value="/mostrarOperaciones.html",method = RequestMethod.GET)
	public ModelAndView ListarOperaciones()
	{
		System.out.println("ENTRA A OPERCIONES");
		return new ModelAndView("mostrarOperaciones","listaOperaciones",operacionService.mostrarOperaciones());	
	}
	
	@RequestMapping(value="/menu.acme",method= RequestMethod.GET)
	public ModelAndView MenuPrincipal()
	{
		
		return new ModelAndView("menu");
	}

}
