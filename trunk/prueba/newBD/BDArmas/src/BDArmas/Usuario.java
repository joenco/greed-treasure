package BDArmas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class Usuario {
	private int id;
	private String nombre;
	private String clave;
	private String login;
	private String email;
	private int oro;
	private int nivel;
	private String pais;
	private List<ArmaTerreno> Terreno = new ArrayList<ArmaTerreno>();
	private List<ArmaCastillo> Castillo = new ArrayList<ArmaCastillo>();

	public Usuario(String nombre, String clave, String login, String email,
			String pais, int oro, int nivel) {
		this.nombre = nombre;
		this.clave = clave;
		this.login = login;
		this.email = email;
		this.pais = pais;
		this.oro = oro;
		this.nivel = nivel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

	@OneToMany(mappedBy = "Refuser")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<ArmaTerreno> getTerreno() {
		return Terreno;
	}

	public void setTerreno(List<ArmaTerreno> terreno) {
		Terreno = terreno;
	}

	@OneToMany(mappedBy = "userRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<ArmaCastillo> getCastillo() {
		return Castillo;
	}

	public void setCastillo(List<ArmaCastillo> castillo) {
		Castillo = castillo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
