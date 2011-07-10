package ArmaBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name ="t_armas")
@Proxy(lazy = false)
public class Arma {
	private int id;
	public String nombre;
	public int ataque;
	public int defensa;
	public int alcance;
	public int municiones;
	public int oro;
	public Boolean act;
	public Usuario userRef;
	public byte[] imagen;
	
	public Arma (){
		//vacio..
	}
	public Arma(String nombre, int ataque, int defensa, int alcance, int municiones, int oro, Usuario userRef){
		this.nombre=nombre;
		this.ataque=ataque;
		this.defensa=defensa;
		this.municiones=municiones;
		this.oro=oro;
		this.alcance=alcance;
		this.act=true;
		this.userRef=userRef;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getAlcance() {
		return alcance;
	}
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	public int getMuniciones() {
		return municiones;
	}
	public void setMuniciones(int municiones) {
		this.municiones = municiones;
	}
	public int getOro() {
		return oro;
	}
	public void setOro(int oro) {
		this.oro = oro;
	}
	public Boolean getAct() {
		return act;
	}
	public void setAct(Boolean act) {
		this.act = act;
	}
	@ManyToOne
	public Usuario getUserRef() {
		return userRef;
	}
	public void setUserRef(Usuario userRef) {
		this.userRef = userRef;
	}
	public Arma usar(){
		this.act=false;
		return this;
	}
	public void devolver(Usuario userRef){
		this.act=true;
	}
	@Lob
	@Column(length = 70000)
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}
