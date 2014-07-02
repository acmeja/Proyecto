package com.javi.acme.util;

import java.io.File;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javi.acme.formulario.UsuarioForm;
import com.javi.acme.util.archivo_bd;
import com.javi.acme.util.leer_sistema;


public class HibernateUtil 
{
	
	 private static final SessionFactory sessionFactory = buildSessionFactory();
	 private static String arc_sis="";
	    private static SessionFactory buildSessionFactory() 
	    {
	    	 
	        try 
	        {
	        	Integer sistema = new leer_sistema().leer_sist();
	        	switch(sistema)
	        	{
	        		case 2014:
	        			arc_sis = "hibernate2014.cfg.xml";
	        		break;
	        		case 2013:
	        			arc_sis="hibernate2013.cfg.xml";
	        		break;
	        		case 2012:
	        			arc_sis="hibernateprueba.cfg.xml";
	        		break;
	        	}	   
	            // Create the SessionFactory from hibernate.cfg.xml
	        	System.out.println("Sistema en uso: "+arc_sis);
	            return new Configuration().configure(arc_sis).buildSessionFactory();
	        }
	        
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
		        
	        }

	      
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
