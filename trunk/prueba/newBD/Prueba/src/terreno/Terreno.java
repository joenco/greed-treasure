package terreno;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "t_terreno")
@Proxy(lazy = false)
public class Terreno {

  private int id;
  private String x;
  private String y;
  private String tipo;
  private String usuario; 

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getX(){
	  return x;
  }
  
  public void setX(String x){
	  this.x = x;
  }

  public String getY(){
	  return y;
  }
  
  public void setY(String y){
	  this.y = y;
  }

  public String getTipo(){
	  return tipo;
  }
  
  public void setTipo(String tipo){
	  this.tipo = tipo;
  }
  
  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
}
