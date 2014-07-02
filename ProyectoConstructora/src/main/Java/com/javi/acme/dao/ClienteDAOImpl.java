package com.javi.acme.dao;

import java.util.List;
import java.util.ArrayList;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javi.acme.formulario.ClienteForm;
import com.javi.acme.formulario.ContactoClienteForm;
import com.javi.acme.util.HibernateUtil;



public class ClienteDAOImpl implements ClienteDAO
{
	//CLIENTE........................................................................
	public void agregarCliente(ClienteForm cliente)
	{
		Transaction trns= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(cliente);
		try
		{
			trns = session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		}catch (RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	public List<ClienteForm> mostrarClientes()
	{
		List<ClienteForm> clientes = new ArrayList<ClienteForm>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			clientes = session.createQuery("from ClienteForm").list();			
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		
		return clientes;
	}
	
	public void eliminarCliente(Integer id)
	{
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try
		{
			trns = session.beginTransaction();			
			ClienteForm cliente = (ClienteForm) session.load(ClienteForm.class,new Integer(id));
			session.delete(cliente);
			session.getTransaction().commit();
		}
		catch(RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	public void actualizarCliente(ClienteForm cliente)
	{
		Transaction trns= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			session.update(cliente);;
			session.getTransaction().commit();
		}		
		catch (RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	public ClienteForm mostrarCliente(int id)
	{
		ClienteForm cliente = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			String queryString = "from ClienteForm where idcliente= :id ";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			cliente = (ClienteForm) query.uniqueResult();
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return cliente;
	}
	//CONTACTO CLIENTE.............................................................................
	
	public void agregarContactoCliente(ContactoClienteForm contactoCliente)
	{
		Transaction trns= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(contactoCliente.getIdcliente()+"  "+contactoCliente.getNombre()+"  "+contactoCliente.getNcorto());		
		ClienteForm clienteForm = this.mostrarCliente(contactoCliente.getIdcliente());
		//session.persist(clienteForm);
		//contactoCliente.setIdcliente(clienteForm.getIdcliente());
		session.save(contactoCliente);
		try
		{
			trns = session.beginTransaction();
			session.save(contactoCliente);
			session.getTransaction().commit();
		}
		catch(RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	public List<ContactoClienteForm> mostrarContactoClientes(Integer id)
	{
		List<ContactoClienteForm> contactoClientes = new  ArrayList<ContactoClienteForm>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			String queryString= "FROM ContactoClienteForm  WHERE idcliente= :id ";
							  //+ "WHERE cc.idcliente= :id";
			
			Query query = session.createQuery(queryString);
			query.setInteger("id",id);
			contactoClientes =query.list();
			trns.commit();
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	
		return contactoClientes;
		
	}
	
	public void eliminarContactoCliente(String nombre)
	{
		Transaction  trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			Query query = session.createQuery("from ContactoClienteForm where  nombre = :nombrecliente ");			
			query.setString("nombrecliente",nombre);
			ContactoClienteForm contactoCliente = (ContactoClienteForm) query.uniqueResult();
			session.delete(contactoCliente);
			trns.commit();
		}
		catch(RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	public void actualizarContactoCliente(ContactoClienteForm contactoCliente)
	{
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();			
			//session.update(contactoCliente);
			String Strtxt = "UPDATE cliente_contacto SET nombre='"+contactoCliente.getNombre()+"',ncorto='"+contactoCliente.getNcorto() +"'"
			   		     + " WHERE nombre='"+contactoCliente.getNombre()+"' AND idcliente='"+contactoCliente.getIdcliente()+"'";
			System.out.println(Strtxt);
			Query query = session.createQuery(Strtxt);
			System.out.println(Strtxt);
			query.executeUpdate();			
			trns.commit();
		}
		catch(RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	public ContactoClienteForm mostrarContactoCliente( String nombre)
	{
		Transaction trns = null;
		ContactoClienteForm contactoCliente = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			System.out.println("Eliminar contacto cliente: "+nombre);
			Query query = session.createQuery("from ContactoClienteForm where nombre= :nombrecliente");
			query.setString("nombrecliente", nombre);
			contactoCliente = (ContactoClienteForm) query.uniqueResult();
			trns.commit();
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return contactoCliente;
	}
}
