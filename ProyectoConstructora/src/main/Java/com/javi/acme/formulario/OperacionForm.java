package com.javi.acme.formulario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import java.util.Set;

import javax.persistence.OneToMany;

import com.javi.acme.formulario.OperacionAcreedorForm;;



@Entity
@Table(name="operacion")
public class OperacionForm 
{
	@Id
	@Column(name="idoperacion")
	private Integer idoperacion;
		
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="movncorto")
	private String movncorto;
	
	@Column(name="folio")
	private int folio;
	
	@Column(name="nocuenta")
	private String nocuenta;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="importe")
	private Double importe;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="tipo")
	private int tipo;
	
	@Column(name="orden")
	private int orden;
	
	@Column(name="destin")
	private String destin;
	
	@Column(name="usuario")
	private String usuario;
	
	
	
	public Integer getIdoperacion() {
		return idoperacion;
	}

	public void setIdoperacion(Integer idoperacion) {
		this.idoperacion = idoperacion;
	}

	

	@OneToMany(targetEntity= OperacionForm.class)
	private Set<OperacionAcreedorForm> operacionesAcreedor;
		
	public Set<OperacionAcreedorForm> getOperacionesAcreedor() {
		return operacionesAcreedor;
	}

	public void setOperacionesAcreedor(
			Set<OperacionAcreedorForm> operacionesAcreedor) {
		this.operacionesAcreedor = operacionesAcreedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMovncorto() {
		return movncorto;
	}

	public void setMovncorto(String movncorto) {
		this.movncorto = movncorto;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getNocuenta() {
		return nocuenta;
	}

	public void setNocuenta(String nocuenta) {
		this.nocuenta = nocuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getDestin() {
		return destin;
	}

	public void setDestin(String destin) {
		this.destin = destin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	

}
