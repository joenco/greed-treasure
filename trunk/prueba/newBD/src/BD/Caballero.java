package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import BD.CaballeroDestreza;

@Entity
@Table(name = "t_caballero")
@Proxy(lazy = false)
public class Caballero {
	private int id;
	private int ataque;
	private int defensa;
	private int vida;
	private Usuario usuario;
	private ModeloCaballero idRef;
	private List<CaballeroDestreza> caballeroDestrezaList = new ArrayList<CaballeroDestreza>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@OneToOne(orphanRemoval = true)
	@PrimaryKeyJoinColumn
	@Cascade({CascadeType.ALL})
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	public ModeloCaballero getIdRef() {
		return idRef;
	}

	public void setIdRef(ModeloCaballero idRef) {
		this.idRef = idRef;
	}
	
	
	  @OneToMany(mappedBy = "caballeroRef", orphanRemoval = true)
	  @LazyCollection(LazyCollectionOption.TRUE)
	  @Cascade({CascadeType.ALL})
	public List<CaballeroDestreza> getCaballeroDestrezaList() {
		return caballeroDestrezaList;
	}

	public void setCaballeroDestrezaList(List<CaballeroDestreza> muchosList) {
		this.caballeroDestrezaList = muchosList;
	}
}
