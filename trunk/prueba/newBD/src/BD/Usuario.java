package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import BD.Perfil;

import BD.PlantillaTerreno;

@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class Usuario {

	private String login;
	private int password;
	private String email;
	private int oro;
	private String pais;
	private String nombre;
	private int nivel;
	private PlantillaTerreno idRef;
	private Perfil perfil;
	private Caballero caballero;
	private List<Ataque> ataqueList = new ArrayList<Ataque>();
	private List<Ataque> ataqueRecibidoList = new ArrayList<Ataque>();
	
	// private List<FondoArma> fonAList = new ArrayList<FondoArma>();

	@Id
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	@ManyToOne
	public PlantillaTerreno getidRef() {
		return idRef;
	}

	public void setIdRef(PlantillaTerreno idRef) {
		this.idRef = idRef;
	}

	@OneToOne(mappedBy = "usuario")
	public Perfil getPersona() {
		return perfil;
	}

	public void setPersona(Perfil perfil) {
		this.perfil = perfil;
	}

	@OneToOne(mappedBy = "usuario")
	public Caballero getCaballero() {
		return caballero;
	}

	public void setCaballero(Caballero caballero) {
		this.caballero = caballero;
	}
	
	@OneToMany(mappedBy = "usuario1Ref")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Ataque> getAtaqueList() {
		return ataqueList;
	}

	public void setAtaqueList(List<Ataque> ataqueList) {
		this.ataqueList = ataqueList;
	}
	
	
	@OneToMany(mappedBy = "usuario2Ref")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Ataque> getAtaqueRecibidoList() {
		return ataqueRecibidoList;
	}

	public void setAtaqueRecibidoList(List<Ataque> ataqueRecibidoList) {
		this.ataqueRecibidoList = ataqueRecibidoList;
	}

	

	/*
	 * @OneToMany(mappedBy = "loginRef")
	 * 
	 * @LazyCollection(LazyCollectionOption.TRUE)
	 * 
	 * @Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN }) public
	 * List<FondoArma> getfonAList() { return fonAList; }
	 * 
	 * public void setfonAList(List<FondoArma> fonAList) { this.fonAList =
	 * fonAList; }
	 */
}
