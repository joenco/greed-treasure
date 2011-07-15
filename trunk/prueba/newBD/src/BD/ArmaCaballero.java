package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import BD.Usuario;
import BD.ModeloArma;

@Entity
@Table(name = "t_arma_caballero")
@Proxy(lazy = false)
public class ArmaCaballero {
	private int id;
	private int municiones_actuales;
	private boolean en_inv;
	private String extremidad;
	private Usuario idUser;
	private ModeloArma refModel;

	public ArmaCaballero(ModeloArma a) {
		this.municiones_actuales = a.getMuniciones_base();
		this.en_inv = true;
	}

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

	public String getExtremidad() {
		return extremidad;
	}

	public void setExtremidad(String extremidad) {
		this.extremidad = extremidad;
	}

	@ManyToOne
	public Usuario getIdUser() {
		return idUser;
	}

	public void setIdUser(Usuario idUser) {
		this.idUser = idUser;
	}

	@ManyToOne
	public ModeloArma getRefModel() {
		return refModel;
	}

	public void setRefModel(ModeloArma refModel) {
		this.refModel = refModel;
	}
}
