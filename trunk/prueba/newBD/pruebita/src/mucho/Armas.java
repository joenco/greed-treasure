package mucho;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Table(name = "t_arma")
@Proxy(lazy = false)
public class Armas {
	private int id;
	private String modelo;
	private int atact;
	private String nombre;
	private Usuario user;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@ManyToOne
	public Usuario getUser() {
		return user;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAtact() {
		return atact;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAtact(int atact) {
		this.atact = atact;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}

}
