package com.javi.acme.servicios;

import java.util.List;

import com.javi.acme.dao.ClienteDAO;
import com.javi.acme.dao.ClienteDAOImpl;
import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.formulario.ContactoClienteForm;

public class ClienteServiceImpl implements ClienteService
{
	private ClienteDAO clienteDAO = new ClienteDAOImpl();
	//CLIENTE..............................................................................
	public void agregarCliente (ClienteForm cliente)
	{
		clienteDAO.agregarCliente(cliente);
	}
	public List<ClienteForm> mostrarClientes()
	{
		return clienteDAO.mostrarClientes();
	}
	public void eliminarCliente(Integer id)
	{
		clienteDAO.eliminarCliente(id);
	}
	public void actualizarCliente(ClienteForm cliente)
	{
		clienteDAO.actualizarCliente(cliente);
	}
	public ClienteForm mostrarCliente(int id)
	{
		return clienteDAO.mostrarCliente(id);
	}
	
	//CONTACTO CLIENTE.............................................................
	public void agregarContactoCliente(ContactoClienteForm contactoCliente)
	{
		clienteDAO.agregarContactoCliente(contactoCliente);
	}	
	public List<ContactoClienteForm> mostrarContactoClientes(Integer id)
	{
		return clienteDAO.mostrarContactoClientes(id);
	}
	public void eliminarContactoCliente(String nombre)
	{
		clienteDAO.eliminarContactoCliente( nombre);
	}
	public void actualizarContactoCliente(ContactoClienteForm contactoCliente)
	{
		clienteDAO.actualizarContactoCliente(contactoCliente);
	}
	public ContactoClienteForm mostrarContactoCliente( String nombre)
	{
		return clienteDAO.mostrarContactoCliente( nombre);
	}

}
