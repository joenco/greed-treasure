package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import BD.ArmaCaballero;
import BD.ArmaTerreno;

@Entity
@Table(name = "t_modelo_arma")
@Proxy(lazy = false)
public class ModeloArma {
	private int id;
	private String nombre;
	private int defensa;
	private int alcanse;
	private int municiones_base;
	private int oro;
	private int nivel;
	private byte[] imagen;
	private List<ArmaTerreno> armaTerreno = new ArrayList<ArmaTerreno>();
	private List<ArmaCaballero> armaCaballero = new ArrayList<ArmaCaballero>();

	/*public ModeloArma(String nombre, int defensa, int alcanse,
			int municiones_base, int oro, int nivel) {
		this.nombre = nombre;
		this.defensa = defensa;
		this.alcanse = alcanse;
		this.municiones_base = municiones_base;
		this.oro = oro;
		this.nivel = nivel;
	}*/

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

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getAlcanse() {
		return alcanse;
	}

	public void setAlcanse(int alcanse) {
		this.alcanse = alcanse;
	}

	public int getMuniciones_base() {
		return municiones_base;
	}

	public void setMuniciones_base(int municiones_base) {
		this.municiones_base = municiones_base;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Lob
	@Column(length = 70000)
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@OneToMany(mappedBy = "modelRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<ArmaTerreno> getArmaTerreno() {
		return armaTerreno;
	}

	public void setArmaTerreno(List<ArmaTerreno> armaTerreno) {
		this.armaTerreno = armaTerreno;
	}

	@OneToMany(mappedBy = "refModel")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<ArmaCaballero> getArmaCaballero() {
		return armaCaballero;
	}

	public void setArmaCaballero(List<ArmaCaballero> armaCaballero) {
		this.armaCaballero = armaCaballero;
	}
}
