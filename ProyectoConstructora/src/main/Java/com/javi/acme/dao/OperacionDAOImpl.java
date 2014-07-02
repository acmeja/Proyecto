package com.javi.acme.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.javi.acme.formulario.OperacionForm;
import com.javi.acme.util.HibernateUtil;


public class OperacionDAOImpl implements OperacionDAO
{
	public List<OperacionForm> mostrarOperaciones()
	{
		List<OperacionForm> operaciones = new ArrayList<OperacionForm>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns = session.beginTransaction();
			operaciones = session.createQuery("from OperacionForm where nocuenta='0222435202' and tipo=2 order by orden").list();			
		}catch(RuntimeException e)
		{
			e.printStackTrace();
		}finally
		{
			session.flush();
			session.close();
		}
		return operaciones;
	}
	
}
