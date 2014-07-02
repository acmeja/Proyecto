package com.javi.acme.controlador;

import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javi.acme.formulario.AcreedorForm;
import com.javi.acme.servicios.AcreedorService;
import com.javi.acme.servicios.AcreedorServiceImpl;


@Controller
public class AcreedorController
{
	private AcreedorService acreedorService = new AcreedorServiceImpl();
	
	@RequestMapping(value="/agregarAcreedor.acme",method = RequestMethod.POST)
	public ModelAndView guardarAcreedor(@ModelAttribute("acreedorForm") AcreedorForm acreedor)
	{
		acreedorService.agregarAcreedor(acreedor);
		return new ModelAndView("mostrarAcreedores","listaAcreedores", acreedorService.mostrarAcreedores());
	}
	@RequestMapping(value="/actualizarAcreedor.acme",method= RequestMethod.POST)
	public ModelAndView actualizarAcreedor(@ModelAttribute("acreedorForm") AcreedorForm acreedor)
	{
		acreedorService.actualizarAcreedor(acreedor);
		return new ModelAndView("mostrarAcreedores","listaAcreedores", acreedorService.mostrarAcreedores());
	}
	
	@RequestMapping(value="/eliminarAcreedor.acme/{acreedorId}",method= RequestMethod.GET)
	public ModelAndView eliminarAcreedor(@PathVariable("acreedorId") Integer acreedorId)
	{
		acreedorService.eliminarAcreedor(acreedorId);
		return new ModelAndView("mostrarAcreedores","listaAcreedores",acreedorService.mostrarAcreedores());		
	}
	
	@RequestMapping(value="/modificarAcreedor.acme/{acreedorId}",method = RequestMethod.GET)
	public ModelAndView modificarAcreedor(@PathVariable("acreedorId") Integer acreedorId)
	{
		AcreedorForm acreedor = acreedorService.mostrarAcreedor(acreedorId);
		ModelAndView modelo= new ModelAndView("agregarAcreedor");
		modelo.addObject("mensajeAcreedor","MODIFICAR ACREEDOR");
		modelo.addObject("acreedorForm",acreedor);
		return modelo;
	}
	
	@RequestMapping(value="/volverAcreedor.acme", method = RequestMethod.GET)
    public ModelAndView volverAcreedor() {
        ModelAndView modelo= new ModelAndView("agregarAcreedor");
        modelo.addObject("mensajeAcreedor","AGREGAR ACREEDOR");
        modelo.addObject("acreedorForm", new AcreedorForm());
        return modelo;
    }
	
	@RequestMapping(value="/mostrarAcreedores.acme", method=RequestMethod.GET)
	public ModelAndView mostrarAcreedores()
	{
		return new ModelAndView("mostrarAcreedores","listaAcreedores",acreedorService.mostrarAcreedores());
	}
 
}
