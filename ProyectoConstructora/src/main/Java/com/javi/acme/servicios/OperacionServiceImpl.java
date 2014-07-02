package com.javi.acme.servicios;
import java.util.List;

import com.javi.acme.dao.OperacionDAO;
import com.javi.acme.dao.OperacionDAOImpl;
import com.javi.acme.formulario.OperacionForm;

public class OperacionServiceImpl implements OperacionService 
{
	private OperacionDAO operacionDAO = new OperacionDAOImpl();
	
	public List<OperacionForm> mostrarOperaciones()
	{
		return operacionDAO.mostrarOperaciones();
	}

}
