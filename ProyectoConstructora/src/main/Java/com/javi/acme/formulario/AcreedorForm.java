package com.javi.acme.formulario;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="acreedor")
public class AcreedorForm
{
	@Id
	@Column(name="idacreedor") 
	private int idacreedor;
	
	@Column(name="nombre") 
	private String nombre;
	
	@Column(name="ncorto")
	private String ncorto;
	
	@Column(name="activo")
	private int  activo; 
	
	/*
	@Column(name="idpersona")
	private int idpersona;*/


	public int getIdacreedor() {
		return idacreedor;
	}


	public void setIdacreedor(int idacreedor) {
		this.idacreedor = idacreedor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNcorto() {
		return ncorto;
	}


	public void setNcorto(String ncorto) {
		this.ncorto = ncorto;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}
/*

	public int getIdpersona() {
		return idpersona;
	}


	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
*/
}
