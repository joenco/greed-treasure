package BD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_coordenada_arma")
@Proxy(lazy = false)
public class CoordenadaArma {
	private int id;
	private int x;
	private int y;
	private ArmaTerreno armaTerrenoRef;

	@Id
	  // @GeneratedValue(strategy = GenerationType.AUTO) // We can't do this
	  @GeneratedValue(generator = "take-from-foreign")

	  // Generates the ID based in persona's id
	  @GenericGenerator( //
	  /*      */name = "take-from-foreign", //
	  /*  */strategy = "foreign", //
	  /**/parameters = {@Parameter(name = "property", value = "armaTerrenoRef")})
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

	@OneToOne
    @PrimaryKeyJoinColumn
	public ArmaTerreno getArmaTerrenoRef() {
		return armaTerrenoRef;
	}

	public void setArmaTerrenoRef(ArmaTerreno armaTerrenoRef) {
		this.armaTerrenoRef = armaTerrenoRef;
	}

}
