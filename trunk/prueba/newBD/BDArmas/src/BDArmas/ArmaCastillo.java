package BDArmas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_armacastillo")
@Proxy(lazy = false)
public class ArmaCastillo {
	public int id;
	public int municiones_actual;
	public boolean en_uso;
	public Usuario userRef;
	public ModeloArma modelRef;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuniciones_actual() {
		return municiones_actual;
	}

	public void setMuniciones_actual(int municiones_actual) {
		this.municiones_actual = municiones_actual;
	}

	public boolean isEn_uso() {
		return en_uso;
	}

	public void setEn_uso(boolean en_uso) {
		this.en_uso = en_uso;
	}

	@ManyToOne
	public Usuario getUserRef() {
		return userRef;
	}

	public void setUserRef(Usuario userRef) {
		this.userRef = userRef;
	}

	@ManyToOne
	public ModeloArma getModelRef() {
		return modelRef;
	}

	public void setModelRef(ModeloArma modelRef) {
		this.modelRef = modelRef;
	}

	public void usar(Usuario user) {
		this.en_uso = true;
	}

	public void devolver(Usuario user) {
		this.en_uso = false;
	}
}
