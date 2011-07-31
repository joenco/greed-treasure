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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_caballero")
@Proxy(lazy = false)
public class Caballero {

	private int id;
	private int ataque;
	private int defensa;
	private int vida;
	private int nivel;
	private int oro;
	private ModeloCaballero modeloCaballeroRef;
	private PlantillaTerreno idRef;
	private Usuario usuario;
	private List<Ataque> ataqueRealizadosList = new ArrayList<Ataque>();
	private List<Ataque> ataqueRecibidosList = new ArrayList<Ataque>();
	private List<ArmaCaballero> armaCaballeroList = new ArrayList<ArmaCaballero>();
	private List<ArmaTerreno> armaTerrenoList = new ArrayList<ArmaTerreno>();

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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	@ManyToOne
	public ModeloCaballero getModeloCaballeroRef() {
		return modeloCaballeroRef;
	}

	public void setModeloCaballeroRef(ModeloCaballero modeloCaballeroRef) {
		this.modeloCaballeroRef = modeloCaballeroRef;
	}

	@ManyToOne
	public PlantillaTerreno getIdRef() {
		return idRef;
	}

	public void setIdRef(PlantillaTerreno idRef) {
		this.idRef = idRef;
	}

	@OneToMany(mappedBy = "atacanteRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<Ataque> getAtaqueRealizadosList() {
		return ataqueRealizadosList;
	}

	public void setAtaqueRealizadosList(List<Ataque> ataqueRealizadosList) {
		this.ataqueRealizadosList = ataqueRealizadosList;
	}

	@OneToMany(mappedBy = "atacadoRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<Ataque> getAtaqueRecibidosList() {
		return ataqueRecibidosList;
	}

	public void setAtaqueRecibidosList(List<Ataque> ataqueRecibidosList) {
		this.ataqueRecibidosList = ataqueRecibidosList;
	}

	@OneToOne(mappedBy = "caballero")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy = "armaCaballeroRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<ArmaCaballero> getArmaCaballeroList() {
		return armaCaballeroList;
	}

	public void setArmaCaballeroList(List<ArmaCaballero> armaCaballeroList) {
		this.armaCaballeroList = armaCaballeroList;
	}

	@OneToMany(mappedBy = "caballeroRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<ArmaTerreno> getArmaTerrenoList() {
		return armaTerrenoList;
	}

	public void setArmaTerrenoList(List<ArmaTerreno> armaTerrenoList) {
		this.armaTerrenoList = armaTerrenoList;
	}

}
