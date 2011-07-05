package BD;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
@Table(name = "t_tile")
@Proxy(lazy = false)
public class Tile {

	private char charId;
	private boolean esOcupable;
	private byte[] img;
	private int bonusVida;
	private int defensaAgregada;
	private int ataqueAgregado;

	private List<Coordenada> coordenadaList = new ArrayList<Coordenada>();

	@Id
	public char getCharId() {
		return charId;
	}

	public void setCharId(char charId) {
		this.charId = charId;
	}

	public void setEsOcupable(boolean ban) {
		this.esOcupable = ban;
	}

	public boolean getEsOcupable() {
		return esOcupable;
	}

	public int getBonusVida() {
		return bonusVida;
	}

	public void setBonusVida(int bonusVida) {
		this.bonusVida = bonusVida;
	}

	public int getDefensaAgregada() {
		return defensaAgregada;
	}

	public void setDefensaAgregada(int defensaAgregada) {
		this.defensaAgregada = defensaAgregada;
	}

	public int getAtaqueAgregado() {
		return ataqueAgregado;
	}

	public void setAtaqueAgregado(int ataqueAgregado) {
		this.ataqueAgregado = ataqueAgregado;
	}

	@Lob
	@Column(length = 70000)
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@OneToMany(mappedBy = "idTileRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Coordenada> getCoordenadaList() {
		return coordenadaList;
	}

	public void setCoordenadaList(List<Coordenada> coordenadaList) {
		this.coordenadaList = coordenadaList;
	}

}
