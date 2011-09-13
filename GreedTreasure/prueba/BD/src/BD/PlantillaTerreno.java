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

import BD.Usuario;
import BD.Coordenada;

@Entity
@Table(name = "t_plantillaTerreno")
@Proxy(lazy = false)
public class PlantillaTerreno {

	private int id;
	private String name;
	private List<Usuario> usuarioList = new ArrayList<Usuario>();
	private List<Coordenada> fonTList = new ArrayList<Coordenada>();

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

	// Relacion uno a muchos con usuario
	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	// Relacion uno a muchos con Coordenada
	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Coordenada> getfonTList() {
		return fonTList;
	}

	public void setfonTList(List<Coordenada> fonTList) {
		this.fonTList = fonTList;
	}

}