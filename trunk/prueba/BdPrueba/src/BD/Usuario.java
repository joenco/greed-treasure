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

import BD.FondoArma;

@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class Usuario {

	private int login;
	private String name;
	private PlantillaTerreno idRef;
	private List<FondoArma> fonAList = new ArrayList<FondoArma>();

	@Id
	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@ManyToOne
	public PlantillaTerreno getidRef() {
		return idRef;
	}

	public void setidRef(PlantillaTerreno idRef) {
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
