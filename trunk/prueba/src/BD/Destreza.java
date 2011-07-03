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

@Entity
@Table(name = "t_destreza")
@Proxy(lazy = false)
public class Destreza {

	private int id;
	private int minBatalla;
	private int ataque;
	private String nombre;
	private List<CaballeroDestreza> caballeroDestrezaList = new ArrayList<CaballeroDestreza>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinBatalla() {
		return minBatalla;
	}

	public void setMinBatalla(int minBatalla) {
		this.minBatalla = minBatalla;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "destrezaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<CaballeroDestreza> getCaballeroDestrezaList() {
		return caballeroDestrezaList;
	}

	public void setCaballeroDestrezaList(List<CaballeroDestreza> muchosList) {
		this.caballeroDestrezaList = muchosList;
	}

}
