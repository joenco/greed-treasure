//package BD;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Proxy;
//
//@Entity
//@Table(name = "t_ataque")
//@Proxy(lazy = false)
//
//public class Ataque {
//	private int id;
//	private Usuario usuario1Ref;
//	private Usuario usuario2Ref;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	@ManyToOne
//	public Usuario getUsuario1() {
//		return usuario1Ref;
//	}
//
//	public void setUsuario1(Usuario usuario1Ref) {
//		this.usuario1Ref = usuario1Ref;
//	}
//
//	@ManyToOne
//	public Usuario getUsuario2() {
//		return usuario2Ref;
//	}
//
//	public void setUsuario2(Usuario usuario2Ref) {
//		this.usuario2Ref = usuario2Ref;
//	}
//	
//	
//
//}
