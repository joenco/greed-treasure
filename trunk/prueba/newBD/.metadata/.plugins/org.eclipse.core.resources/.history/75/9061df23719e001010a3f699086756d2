package prueba;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)

public class Usuario {
	private int id;
	private String nombre;
	private String clave;
	private String login;
	private Caballero caballero;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	 @OneToOne(cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 public Caballero getCaballero() {
			return caballero;
	}
	public void setCaballero(Caballero caballero) {
			this.caballero = caballero;
	}
	
}
