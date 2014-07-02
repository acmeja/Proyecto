package com.javi.acme.controlador;

import com.javi.acme.formulario.AcreedorForm;
import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.servicios.ClienteService;
import com.javi.acme.servicios.ClienteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.stereotype.Controller;

import com.javi.acme.formulario.ContactoClienteForm;

@Controller
public class ClienteController
{
	private ClienteService clienteService = new ClienteServiceImpl();
	//CLIENTE.............................................................................................
	@RequestMapping(value="/agregarCliente.acme",method=RequestMethod.POST)
	public ModelAndView guardarCliente(@ModelAttribute("clienteForm") ClienteForm cliente)
	{
		clienteService.agregarCliente(cliente);
		return new ModelAndView("mostrarClientes","listaClientes",clienteService.mostrarClientes());
	}
	
	@RequestMapping(value="/actualizarCliente.acme",method= RequestMethod.POST)
	public ModelAndView actualizarCliente(@ModelAttribute("clienteForm") ClienteForm cliente)
	{
		clienteService.actualizarCliente(cliente);
		return new ModelAndView("mostrarClientes","listaClientes",clienteService.mostrarClientes());
	}
	
	@RequestMapping(value="/eliminarCliente.acme/{clienteId}",method= RequestMethod.GET)
	public ModelAndView eliminarCliente(@PathVariable("clienteId") Integer clienteId)
	{
		clienteService.eliminarCliente(clienteId);
		return new ModelAndView("mostrarClientes","listaClientes",clienteService.mostrarClientes());		
	}
	
	@RequestMapping(value="/modificarCliente.acme/{clienteId}",method = RequestMethod.GET)
	public ModelAndView modificarAcreedor(@PathVariable("clienteId") Integer clienteId)
	{
		ClienteForm cliente = clienteService.mostrarCliente(clienteId);
		ModelAndView modelo= new ModelAndView("agregarCliente");
		modelo.addObject("mensajeCliente","MODIFICAR CLIENTE");
		modelo.addObject("clienteForm",cliente);
		return modelo;
	}
	
	@RequestMapping(value="/volverCliente.acme", method = RequestMethod.GET)
    public ModelAndView volverCliente() {
        ModelAndView modelo= new ModelAndView("agregarCliente");
        modelo.addObject("mensajeCliente","AGREGAR CLIENTE");
        modelo.addObject("clienteForm", new ClienteForm());
        return modelo;
    }
	@RequestMapping(value="/mostrarClientes.acme",method=RequestMethod.GET)
	public ModelAndView mostrarClientes()
	{
		return new ModelAndView("mostrarClientes","listaClientes",clienteService.mostrarClientes());
	}
	
	//CONTACTO CLIENTES.........................................................................................
	@RequestMapping(value="mostrarContactoClientes.acme/{clienteId}",method=RequestMethod.GET)
	public ModelAndView mostrarContactoClientes(@PathVariable("clienteId") Integer clienteId)
	{
		ModelAndView model = new ModelAndView("mostrarContactoClientes","listaContactoClientes",clienteService.mostrarContactoClientes(clienteId));
		model.addObject("idcliente",clienteId);
		return  model;
	}
	
	@RequestMapping(value="/volverContactoCliente.acme/{clienteId}",method=RequestMethod.GET)
	public ModelAndView volverContactoCliente(@PathVariable("clienteId") Integer clienteId)
	{
		ModelAndView modelo = new ModelAndView("agregarContactoCliente");
		modelo.addObject("mensajeContactoCliente","AGREGAR CONTACTO CLIENTE");
		modelo.addObject("idcliente",clienteId);
		ContactoClienteForm contactoCliente = new ContactoClienteForm();
		contactoCliente.setIdcliente(clienteId);
		modelo.addObject("contactoClienteForm",contactoCliente);
		return modelo;
	}
	
	@RequestMapping(value="/agregarContactoCliente.acme",method=RequestMethod.POST)
	public ModelAndView guardarContactoCliente(@ModelAttribute("contactoClienteForm") ContactoClienteForm contactoCliente)
	{
		
		clienteService.agregarContactoCliente(contactoCliente);
		ModelAndView model = new ModelAndView("mostrarContactoClientes","listaContactoClientes",clienteService.mostrarContactoClientes(contactoCliente.getIdcliente()));
		model.addObject("idcliente",contactoCliente.getIdcliente());		
		return model;
	}
	
	@RequestMapping(value="/eliminarContactoCliente.acme/{nombre}",method=RequestMethod.GET)
	public ModelAndView eliminarContactoCliente(@PathVariable("nombre") String nombre)
	{		
		ContactoClienteForm contactoCliente = clienteService.mostrarContactoCliente(nombre);
		clienteService.eliminarContactoCliente(nombre);
		ModelAndView model = new ModelAndView("mostrarContactoClientes","listaContactoClientes",clienteService.mostrarContactoClientes(contactoCliente.getIdcliente()));
		model.addObject("idcliente",contactoCliente.getIdcliente());				
		return model;
		
			
	}
	
	@RequestMapping(value="/modificarContactoCliente.acme/{nombre}", method=RequestMethod.GET)
	public ModelAndView modificarContactoCliente(@PathVariable("nombre") String nombre)
	{
		ModelAndView modelo = new ModelAndView("agregarContactoCliente");
		modelo.addObject("mensajeContactoCliente","MODIFICAR CONTACTO CLIENTE");
		ContactoClienteForm contactoCliente = clienteService.mostrarContactoCliente(nombre);
		//modelo.addObject("idcliente",contactoCliente.getIdcliente());
		modelo.addObject("contactoClienteForm",contactoCliente);
		return modelo;
	}
	
	@RequestMapping(value="/actualizarContactoCliente.acme", method=RequestMethod.POST)
	public ModelAndView actualizarContactoCliente(@ModelAttribute("contactoClienteForm") ContactoClienteForm contactoCliente)
	{
		clienteService.actualizarContactoCliente(contactoCliente);
		ModelAndView model = new ModelAndView("mostrarContactoClientes","listaContactoClientes",clienteService.mostrarContactoClientes(contactoCliente.getIdcliente()));
		model.addObject("idcliente",contactoCliente.getIdcliente());				
		return model;
	
	}
	
}
