package BDArmas;

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
@Table(name = "t_modeloarma")
@Proxy(lazy = false)
public class ModeloArma {
	public int id;
	public int defensa;
	public int municiones_base;
	public int alcance;
	public int oro;
	public int nivel;
	public List<ArmaCastillo> armaCast = new ArrayList<ArmaCastillo>();
	public List<ArmaTerreno> armaTer = new ArrayList<ArmaTerreno>();
	public byte[] imagen;

	public ModeloArma(int id, int defensa, int municiones_base, int alcanse,
			int oro, int nivel) {
		this.id = id;
		this.defensa = defensa;
		this.municiones_base = municiones_base;
		this.alcance = alcanse;
		this.oro = oro;
		this.nivel = nivel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getMuniciones_base() {
		return municiones_base;
	}

	public void setMuniciones_base(int municiones_base) {
		this.municiones_base = municiones_base;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
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

	public List<ArmaCastillo> getArmaCast() {
		return armaCast;
	}

	@OneToMany(mappedBy = "modelRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public void setArmaCast(List<ArmaCastillo> armaCast) {
		this.armaCast = armaCast;
	}

	@OneToMany(mappedBy = "Refmodel")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<ArmaTerreno> getArmaTer() {
		return armaTer;
	}

	public void setArmaTer(List<ArmaTerreno> armaTer) {
		this.armaTer = armaTer;
	}

	@Lob
	@Column(length = 70000)
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}