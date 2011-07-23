package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import BD.Usuario;
import BD.ModeloArma;

@Entity
@Table(name = "t_arma_terreno")
@Proxy(lazy = false)
public class ArmaTerreno {
	private int id;
	private int municiones_actuales;
	private boolean en_inv;
	private Usuario refUser;
	private ModeloArma modelRef;
	private coordenadaArma refCoor;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuniciones_actuales() {
		return municiones_actuales;
	}

	public void setMuniciones_actuales(int municiones_actuales) {
		this.municiones_actuales = municiones_actuales;
	}

	public boolean isEn_inv() {
		return en_inv;
	}

	public void setEn_inv(boolean en_inv) {
		this.en_inv = en_inv;
	}

	@ManyToOne
	public Usuario getRefUser() {
		return refUser;
	}

	public void setRefUser(Usuario refUser) {
		this.refUser = refUser;
	}

	@ManyToOne
	public ModeloArma getModelRef() {
		return modelRef;
	}

	public void setModelRef(ModeloArma modelRef) {
		this.modelRef = modelRef;
	}
	
	@OneToOne(mappedBy = "refArma")
	public coordenadaArma getRefCoor() {
		return refCoor;
	}

	public void setRefCoor(coordenadaArma refCoor) {
		this.refCoor = refCoor;
	}

}
