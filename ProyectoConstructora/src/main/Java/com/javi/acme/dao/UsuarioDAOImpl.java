package com.javi.acme.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javi.acme.formulario.UsuarioForm;
import com.javi.acme.util.HibernateUtil;
public class UsuarioDAOImpl implements UsuarioDAO {
	 public boolean buscarUsuario(UsuarioForm usuario) {
		 
	        boolean existe=false;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from UsuarioForm where usuario = :usuario and password = :password";
	            Query query = session.createQuery(queryString);
	            query.setString("usuario", usuario.getUsuario());
	            query.setString("password", usuario.getPassword());
	            existe = !(((UsuarioForm) query.uniqueResult())==(null));
	            //Aqui verificamos si la query me trae algun resultado, si no es asi el usuario no existe.
	        } catch (RuntimeException e) {
	            existe = false;
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return existe;
	    }
}
