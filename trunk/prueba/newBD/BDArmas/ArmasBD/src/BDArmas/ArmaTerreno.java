package BDArmas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_armaterreno")
@Proxy(lazy = false)
public class ArmaTerreno {
	public int id;
	public int municiones_actual;
	public int x;
	public int y;
	public boolean en_uso;
	public Usuario Refuser;
	public ModeloArma Refmodel;

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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEn_uso() {
		return en_uso;
	}

	public void setEn_uso(boolean en_uso) {
		this.en_uso = en_uso;
	}

	@ManyToOne
	public Usuario getRefuser() {
		return Refuser;
	}

	public void setRefuser(Usuario refuser) {
		Refuser = refuser;
	}

	@ManyToOne
	public ModeloArma getRefmodel() {
		return Refmodel;
	}

	public void setRefmodel(ModeloArma refmodel) {
		Refmodel = refmodel;
	}
}
