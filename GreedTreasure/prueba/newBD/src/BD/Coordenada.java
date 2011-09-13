package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import BD.PlantillaTerreno;

@Entity
@Table(name = "t_coordenada")
@Proxy(lazy = false)
public class Coordenada {

	private int id;
	private int x;
	private int y;
	private PlantillaTerreno idRef;
	private Tile idTileRef;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	@ManyToOne
	public PlantillaTerreno getIdRef() {
		return idRef;
	}

	public void setIdRef(PlantillaTerreno idRef) {
		this.idRef = idRef;
	}

	@ManyToOne
	public Tile getIdTileRef() {
		return idTileRef;
	}

	public void setIdTileRef(Tile idTileRef) {
		this.idTileRef = idTileRef;
	}
}
