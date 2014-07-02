package com.javi.acme.formulario;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="operacion_acreedor")
public class OperacionAcreedorForm
{
	@Id
	@Column(name="idoperacionacreedor")
	private int idoperacionacreedor;
	
	@ManyToOne
	@JoinColumn(name="idoperacion")
	private OperacionForm operacionForm;
	
	@Column(name="destino")
	private String destino;
	
	@Column(name="subdestino")
	private String subdestino;
	
	@ManyToOne
	@JoinColumn(name="idacreedor")
	private AcreedorForm acreedorForm;
	

}
