package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import BD.Usuario;
import BD.ModeloArmaCaballero;

;

@Entity
@Table(name = "t_arma_caballero")
@Proxy(lazy = false)
public class ArmaCaballero {
	private int id;
	private int municiones_actuales;
	private String extremidad;
	private Usuario idUser;
	private ModeloArmaCaballero modelRef;
	private Caballero armaCaballeroRef;

	public ArmaCaballero(ModeloArmaCaballero a) {
		this.municiones_actuales = a.getMuniciones_base();
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
	public ModeloArmaCaballero getRefModel() {
		return modelRef;
	}

	public void setRefModel(ModeloArmaCaballero modelRef) {
		this.modelRef = modelRef;
	}

	@ManyToOne
	public Caballero getArmaCaballeroRef() {
		return armaCaballeroRef;
	}

	public void setArmaCaballeroRef(Caballero armaCaballeroRef) {
		this.armaCaballeroRef = armaCaballeroRef;
	}

}
