package db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "usera")
@Proxy(lazy = false)
public class User {

  private int id;
  private String nick;
  private String cantoro;
  private String nivel;
  private String victoria;
  private String derrota;
  private String pass;
  private String name;
  private String lastname;
  private String country;
  private String email;
  private String terreno;
  private String caballero;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getNick() {
    return nick;
  }
  
  public void setCantOro(String cantoro) {
	    this.cantoro= cantoro;
	  }

  public String getCantOro() {
    return cantoro;
  }
  
  public void setNivel(String nivel) {
    this.nivel= nivel;
  }

  public String getNivel() {
    return nivel;
  }

  public void setVictoria(String victoria) {
    this.victoria= victoria;
  }

  public String getVictoria() {
    return victoria;
  }

  public void setDerrota(String derrota) {
    this.derrota= derrota;
  }

  public String getDerrota() {
    return derrota;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getPass() {
    return pass;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  public void setLastName(String lastname) {
	    this.lastname = lastname;
	  }

	  public String getLastName() {
	    return lastname;
	  }
	  
	  public void setCountry(String country) {
		    this.country = country;
		  }

		  public String getCountry() {
		    return country;
		  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setTerreno(String terreno) {
	    this.terreno = terreno;
	  }

	  public String getTerreno() {
	    return terreno;
	  }

  public void setCaballero(String caballero) {
	    this.caballero = caballero;
	  }

	  public String getCaballero() {
	    return caballero;
	  }

}
