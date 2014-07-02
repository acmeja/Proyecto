package com.javi.acme.dao;

import com.javi.acme.formulario.AcreedorForm;
import java.util.List;

public interface AcreedorDAO
{
	public void agregarAcreedor (AcreedorForm acreedor);
	public List<AcreedorForm> mostrarAcreedores();
	public void eliminarAcreedor(Integer id);
	public void actualizarAcreedor(AcreedorForm acreedor);
	public AcreedorForm mostrarAcreedor(int id);
	
}
