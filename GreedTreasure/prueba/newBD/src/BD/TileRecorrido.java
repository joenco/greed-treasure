package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_tile_recorrido")
@Proxy(lazy = false)
public class TileRecorrido {
	private int id;
	private int x;
	private int y;
	private Ataque ataqueRef;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@ManyToOne
	public Ataque getAtaqueRef() {
		return ataqueRef;
	}

	public void setAtaqueRef(Ataque ataqueRef) {
		this.ataqueRef = ataqueRef;
	}

}
