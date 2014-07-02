package com.javi.acme.formulario;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class BaseDatosForm
{
	@Column(name="basededatos")
	private Integer basededatos;

	public Integer getBasededatos() {
		return basededatos;
	}

	public void setBasededatos(Integer basededatos) {
		this.basededatos = basededatos;
	}
	


	
	
}
