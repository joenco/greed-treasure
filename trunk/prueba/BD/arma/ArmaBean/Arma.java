package ArmaBean;
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
@Table(name ="t_armas")
@Proxy(lazy = false)
public class Arma {
	private int id;
	public String nombre;
	public int ataque;
	public int defensa;
	public int alcance;
	public int municiones;
	public int oro;
	public List <Inventario> inventList = new ArrayList<Inventario>();
	
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
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	public int getMuniciones() {
		return municiones;
	}
	public void setMuniciones(int municiones) {
		this.municiones = municiones;
	}
	public int getOro() {
		return oro;
	}
	public void setOro(int oro) {
		this.oro = oro;
	}
	@OneToMany(mappedBy = "armaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	public List<Inventario> getInventList() {
		return inventList;
	}
	public void setInventList(List<Inventario> inventList) {
		this.inventList = inventList;
	}
	
}
