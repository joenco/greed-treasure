package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_ataque")
@Proxy(lazy = false)
public class Ataque {
	private int id;
	private Caballero atacanteRef;
	private Caballero atacadoRef;
	private boolean activo;
	private List<TileRecorrido> ataqueTileRecorridoList = new ArrayList<TileRecorrido>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Caballero getAtacanteRef() {
		return atacanteRef;
	}

	public void setAtacanteRef(Caballero atacanteRef) {
		this.atacanteRef = atacanteRef;
	}

	@ManyToOne
	public Caballero getAtacadoRef() {
		return atacadoRef;
	}

	public void setAtacadoRef(Caballero atacadoRef) {
		this.atacadoRef = atacadoRef;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(mappedBy = "ataqueRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<TileRecorrido> getAtaqueTileRecorridoList() {
		return ataqueTileRecorridoList;
	}

	public void setAtaqueTileRecorridoList(
			List<TileRecorrido> ataqueTileRecorridoList) {
		this.ataqueTileRecorridoList = ataqueTileRecorridoList;
	}

}
