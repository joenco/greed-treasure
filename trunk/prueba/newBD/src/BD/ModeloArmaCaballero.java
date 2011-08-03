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

@Entity
@Table(name = "t_m_arma_caballero")
@Proxy(lazy = false)
public class ModeloArmaCaballero {
	private int id;
	private String nombre;
	private int defensa;
	private int alcance;
	private int municiones_base;
	private int oro;
	private int nivel;
	private byte[] imagen;
	private List<ArmaCaballero> armaCaballero = new ArrayList<ArmaCaballero>();

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

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
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

	@OneToMany(mappedBy = "refModel")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, })
	public List<ArmaCaballero> getArmaCaballero() {
		return armaCaballero;
	}

	public void setArmaCaballero(List<ArmaCaballero> armaCaballero) {
		this.armaCaballero = armaCaballero;
	}
}
