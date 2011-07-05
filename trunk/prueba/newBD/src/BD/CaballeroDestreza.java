package BD;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import BD.Caballero;
import BD.Destreza;

public class CaballeroDestreza {
	private int id;
	private Caballero caballeroRef;
	private Destreza destresaRef;

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
	public Destreza getDestresaRef() {
		return destresaRef;
	}

	public void setDestresaRef(Destreza destresaRef) {
		this.destresaRef = destresaRef;
	}
}
