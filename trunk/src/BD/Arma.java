package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption; //import org.hibernate.annotations.Proxy;

import BD.FondoArma;

@Entity
@Table(name = "t_Arma")
@Proxy(lazy = false)
public class Arma {
	private int id;
	private String name;
	private List<FondoArma> fondAList = new ArrayList<FondoArma>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<FondoArma> getfondAList() {
		return fondAList;
	}

	public void setfondAList(List<FondoArma> fondAList) {
		this.fondAList = fondAList;
	}

	

}
