package com.javi.acme.formulario;

import java.io.Serializable;

import javax.persistence.AssociationOverrides;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name="cliente_contacto")
@IdClass(ContactoId.class)
public class ContactoClienteForm implements Serializable
{
	@Id
	@Column(name="idcliente")
	private Integer idcliente;
	
	@Id
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ncorto")
	private String ncorto;
	
	@ManyToOne
	@JoinColumn(name="idcliente",insertable=false, updatable=false, 
            nullable=false)
	private ClienteForm cliente;

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
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

	public ClienteForm getCliente() {
		return cliente;
	}

	public void setCliente(ClienteForm cliente) {
		this.cliente = cliente;
	}
	
	
}
class ContactoId implements Serializable 
{
	private Integer idcliente;
	private String nombre;
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idcliente == null) ? 0 : idcliente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactoId other = (ContactoId) obj;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		return true;
	}
	
}




