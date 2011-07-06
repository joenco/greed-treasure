package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import BD.Caballero;
import BD.Destreza;

@Entity
@Table(name = "t_caballerodestreza")
@Proxy(lazy = false)

public class CaballeroDestreza {
	
	private int id;
	private Caballero caballeroRef;
	private Destreza destrezaRef;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Caballero getCaballeroRef() {
		return caballeroRef;
	}

	public void setCaballeroRef(Caballero caballeroRef) {
		this.caballeroRef = caballeroRef;
	}

	@ManyToOne
	public Destreza getDestrezaRef() {
		return destrezaRef;
	}

	public void setDestrezaRef(Destreza destrezaRef) {
		this.destrezaRef = destrezaRef;
	}
}
