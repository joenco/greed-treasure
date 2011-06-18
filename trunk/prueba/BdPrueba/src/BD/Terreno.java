package BD;

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


import BD.FondoTerreno;


@Entity
@Table(name = "t_terreno")
@Proxy(lazy = false)
public class Terreno {

	private int id;
	private boolean esOcupable;
	private List<FondoTerreno> fontList = new ArrayList<FondoTerreno>();
	private String imagen;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setEsOcupable(boolean ban) {
		this.esOcupable = ban;
	}

	public boolean getEsOcupable() {
		return esOcupable;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen() {
		return imagen;
	}

	
	
	@OneToMany(mappedBy = "idTerrenoRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<FondoTerreno> getfonTList() {
		return fontList;
	}

	public void setfonTList(List<FondoTerreno> fontList) {
		this.fontList = fontList;
	}
}
