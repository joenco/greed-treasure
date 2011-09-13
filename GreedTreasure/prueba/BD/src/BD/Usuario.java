package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import BD.PlantillaTerreno;

@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class Usuario {

	private int password;
	private String login;
	private PlantillaTerreno idRef;
	private List<FondoArma> fonAList = new ArrayList<FondoArma>();

	@Id
	public int getPassword() {
		return password;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	@ManyToOne
	public PlantillaTerreno getidRef() {
		return idRef;
	}

	public void setIdRef(PlantillaTerreno idRef) {
		this.idRef = idRef;
	}

	@OneToMany(mappedBy = "loginRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<FondoArma> getfonAList() {
		return fonAList;
	}

	public void setfonAList(List<FondoArma> fonAList) {
		this.fonAList = fonAList;
	}
}
