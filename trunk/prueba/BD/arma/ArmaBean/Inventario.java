package ArmaBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "t_inventario")
@Proxy(lazy = false)
public class Inventario {
	  private int id;
	  private Arma armaRef;
	  private Usuario userRef;
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	  public int getId() {
		return id;
	   }
	  public void setId(int id) {
		this.id = id;
	  }
	  @ManyToOne
	  public Arma getArmaRef() {
		return armaRef;
	  }
	  public void setArmaRef(Arma armaRef) {
		this.armaRef = armaRef;
	  }
	  @ManyToOne
	  public Usuario getUserRef() {
		return userRef;
	  }
	  public void setUserRef(Usuario userRef) {
		this.userRef = userRef;
	  }
}
