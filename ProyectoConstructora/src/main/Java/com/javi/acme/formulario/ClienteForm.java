package com.javi.acme.formulario;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cliente")
@SequenceGenerator(name="SQ_cliente",sequenceName="SQ_cliente")
public class ClienteForm implements Serializable
{
	@Id
	@Column(name="idcliente")
	@GeneratedValue
	private Integer idcliente;
	
	@Column(name="razon")
	private String razon;
	
	@Column(name="ncorto")
	private String ncorto;
	
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="activo")
	private Integer activo;
	
	
	@OneToMany(mappedBy="cliente")
	private Set<ContactoClienteForm> cliente = new HashSet<ContactoClienteForm>();
	
	
	
	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getNcorto() {
		return ncorto;
	}

	public void setNcorto(String ncorto) {
		this.ncorto = ncorto;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public Set<ContactoClienteForm> getClientes() {
		return cliente;
	}

	public void setClientes(Set<ContactoClienteForm> clientes) {
		this.cliente = clientes;
	}

	
	
}
