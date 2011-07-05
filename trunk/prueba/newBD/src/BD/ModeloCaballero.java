package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

public class ModeloCaballero {
	private int id;
	private int defensaBase;
	private int ataqueBase;
	private byte[] imgEdicion;
	private byte[] imgTerreno;
	private List<Caballero> caballeroList = new ArrayList<Caballero>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefensaBase() {
		return defensaBase;
	}

	public void setDefensaBase(int defensaBase) {
		this.defensaBase = defensaBase;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public void setAtaqueBase(int ataqueBase) {
		this.ataqueBase = ataqueBase;
	}

	public byte[] getImgEdicion() {
		return imgEdicion;
	}

	public void setImgEdicion(byte[] imgEdicion) {
		this.imgEdicion = imgEdicion;
	}

	public byte[] getImgTerreno() {
		return imgTerreno;
	}

	public void setImgTerreno(byte[] imgTerreno) {
		this.imgTerreno = imgTerreno;
	}
	
	
	@OneToMany(mappedBy = "idRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Caballero> getfonTList() {
		return caballeroList;
	}

	public void setfonTList(List<Caballero> caballeroList) {
		this.caballeroList = caballeroList;
	}

}
