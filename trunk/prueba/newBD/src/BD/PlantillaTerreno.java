package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption; //import org.hibernate.annotations.Proxy;

import BD.Caballero;
import BD.Coordenada;

@Entity
@Table(name = "t_plantillaTerreno")
@Proxy(lazy = false)
public class PlantillaTerreno {

	private int tipo;
	private String name;
	private List<Caballero> caballeroList = new ArrayList<Caballero>();
	private List<Coordenada> coordList = new ArrayList<Coordenada>();

	@Id
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<Caballero> getCaballeroList() {
		return caballeroList;
	}

	public void setCaballeroList(List<Caballero> caballeroList) {
		this.caballeroList = caballeroList;
	}

	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<Coordenada> getFonTList() {
		return coordList;
	}

	public void setFonTList(List<Coordenada> coordList) {
		this.coordList = coordList;
	}

}
