package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_fondoArma")
@Proxy(lazy = false)
public class FondoArma {

	private int id;
	private int x;
	private int y;
	private Usuario loginRef;
	private Arma idRef;

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
	public Usuario getloginRef() {
		return loginRef;
	}

	public void setloginRef(Usuario loginRef) {
		this.loginRef = loginRef;
	}

	@ManyToOne
	public Arma getidRef() {
		return idRef;
	}

	public void setidRef(Arma idRef) {
		this.idRef = idRef;
	}
}
