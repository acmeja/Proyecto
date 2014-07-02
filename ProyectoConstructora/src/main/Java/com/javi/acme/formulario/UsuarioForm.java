package com.javi.acme.formulario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="usuario")
public class UsuarioForm
{
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="password")
    private String password;

    @Column(name="usuario")
    private String usuario;
    
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public String toString(){ return "Usuario: "+this.nombre;}
    
    

}
