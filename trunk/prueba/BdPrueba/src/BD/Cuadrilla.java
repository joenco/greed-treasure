package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;
import javax.persistence.Column;
import javax.persistence.Lob;

import BD.Coordenada;







@Entity
@Table(name = "t_cuadrilla")
@Proxy(lazy = false)
public class Cuadrilla {

	private int id;
	private boolean esOcupable;
	private List<Coordenada> fontList = new ArrayList<Coordenada>();
	private byte[] img;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setEsOcupable(boolean ban) {
		this.esOcupable = ban;
	}

	public boolean getEsOcupable() {
		return esOcupable;
	}


	@Lob
	  @Column(length = 70000)
	  public byte[] getImg() {
	    return img;
	  }

	  public void setImg(byte[] img) {
	    this.img = img;
	  }
	  
	
	@OneToMany(mappedBy = "idCuadrillaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Coordenada> getfonTList() {
		return fontList;
	}

	public void setfonTList(List<Coordenada> fontList) {
		this.fontList = fontList;
	}
}
