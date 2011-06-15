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
@Table(name = "t_fondoTerreno")
@Proxy(lazy = false)
public class FondoTerreno {

	private int id;
	private int x;
	private int y;
	private PlantillaTerreno idRef;
	private Terreno idTerrenoRef;

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
	public PlantillaTerreno getidRef() {
		return idRef;
	}

	public void setidRef(PlantillaTerreno idRef) {
		this.idRef = idRef;
	}
	
	@ManyToOne
	public Terreno getidTerrenoRef() {
		return idTerrenoRef;
	}

	public void setidTerrenoRef(Terreno idTerrenoRef) {
		this.idTerrenoRef = idTerrenoRef;
	}
}
