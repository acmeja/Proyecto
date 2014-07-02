package com.javi.acme.servicios;
import java.util.List;
import com.javi.acme.formulario.AcreedorForm;
public interface AcreedorService
{
	public void agregarAcreedor(AcreedorForm acreedor);
	public List<AcreedorForm> mostrarAcreedores();
	public void eliminarAcreedor(Integer idacreedor);
	public void actualizarAcreedor(AcreedorForm acreedor);
	public AcreedorForm mostrarAcreedor(int idacreedor);
}
