package com.javi.acme.dao;

import java.util.List;

import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.formulario.ContactoClienteForm;

public interface ClienteDAO
{
	//CLIENTE...................................................
	public void agregarCliente(ClienteForm clienteForm);
	public List<ClienteForm> mostrarClientes();
	public void eliminarCliente(Integer id);
	public void actualizarCliente(ClienteForm cliente);
	public ClienteForm mostrarCliente(int id);
	
	//CONTACTO CLIENTE...........................................
	public void agregarContactoCliente(ContactoClienteForm contactoClienteForm);
	public List<ContactoClienteForm> mostrarContactoClientes(Integer id);
	public void eliminarContactoCliente( String nombre);
	public void actualizarContactoCliente(ContactoClienteForm cliente);
	public ContactoClienteForm mostrarContactoCliente(String nombre);
	
	
}
