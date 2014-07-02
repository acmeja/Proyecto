package com.javi.acme.servicios;
import java.util.List;
import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.formulario.ContactoClienteForm;
public interface ClienteService
{
	//CLIENTE..............................................
	public void agregarCliente(ClienteForm cliente);
	public List<ClienteForm> mostrarClientes();
	public void eliminarCliente(Integer id);
	public void actualizarCliente(ClienteForm cliente);
	public ClienteForm mostrarCliente(int id);
	
	//CONTACTO CLIENTE......................................
	public void agregarContactoCliente(ContactoClienteForm contactoCliente);
	public List<ContactoClienteForm> mostrarContactoClientes(Integer id);
	public void eliminarContactoCliente(String nombre);
	public void actualizarContactoCliente(ContactoClienteForm contactoCliente);
	public ContactoClienteForm mostrarContactoCliente(String nombre);
	
	
}
