package com.javi.acme.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javi.acme.formulario.AcreedorForm;
import com.javi.acme.util.HibernateUtil;

public class AcreedorDAOImpl implements AcreedorDAO 
{
	
	public void agregarAcreedor(AcreedorForm acreedor)
	{
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.save(acreedor);
		try
		{
			trns = session.beginTransaction();
			session.save(acreedor);
			session.getTransaction().commit();			
		}
		catch (RuntimeException e)
		{
			if(trns!= null)
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
	public List<AcreedorForm> mostrarAcreedores()
	{
		List<AcreedorForm> acreedores = new ArrayList<AcreedorForm>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			acreedores = session.createQuery("from AcreedorForm").list();
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
		return acreedores;
	}
	
	public void eliminarAcreedor(Integer id)
	{
		Transaction trns= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			AcreedorForm acreedor = (AcreedorForm) session.load(AcreedorForm.class, new Integer(id));
			session.delete(acreedor);
			session.getTransaction().commit();
		}
		catch(RuntimeException e)
		{
			if (trns != null)
			{
				trns.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	public void actualizarAcreedor(AcreedorForm acreedor)
	{
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			session.update(acreedor);
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
	public  AcreedorForm mostrarAcreedor(int idacreedor)
	{
		AcreedorForm acreedor = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			String queryString = "from AcreedorForm where idacreedor = :idacreedor";
			Query query = session.createQuery(queryString);
			query.setInteger("idacreedor", idacreedor);
			acreedor = (AcreedorForm) query.uniqueResult();
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
		return acreedor;
	}
}
