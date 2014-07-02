package com.javi.acme.formulario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="persona")
public class PersonaForm 
{
@Id
@Column(name="idpersona")
private int idpersona;

@Column(name="nombre")
private String nombre;

@Column(name="ncorto")
private String ncorto;

public int getIdpersona() {
	return idpersona;
}

public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
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



}
