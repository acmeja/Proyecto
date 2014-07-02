package com.javi.acme.servicios;
import java.util.List;

import com.javi.acme.dao.AcreedorDAO;
import com.javi.acme.dao.AcreedorDAOImpl;
import com.javi.acme.formulario.AcreedorForm;

public class AcreedorServiceImpl implements AcreedorService
{
	private AcreedorDAO acreedorDAO = new AcreedorDAOImpl();

	public void agregarAcreedor(AcreedorForm acreedor) {
		acreedorDAO.agregarAcreedor(acreedor);
	}

	public List<AcreedorForm> mostrarAcreedores()
	{
		return acreedorDAO.mostrarAcreedores();
	}

	public void eliminarAcreedor(Integer id) {
		acreedorDAO.eliminarAcreedor(id);
	}

	public void actualizarAcreedor(AcreedorForm acreedor) {
		acreedorDAO.actualizarAcreedor(acreedor);
	}

	public AcreedorForm mostrarAcreedor(int id) {
		return acreedorDAO.mostrarAcreedor(id);
	}
	


}
