package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_modelo_caballero")
@Proxy(lazy = false)
public class ModeloCaballero {
	private int id;
	private int defensaBase;
	private int ataqueBase;
	private String nombreModelo;
    private byte[] imgEdicion;
	private byte[] imgTerreno;
	private List<Caballero> caballeroList = new ArrayList<Caballero>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefensaBase() {
		return defensaBase;
	}

	public void setDefensaBase(int defensaBase) {
		this.defensaBase = defensaBase;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public void setAtaqueBase(int ataqueBase) {
		this.ataqueBase = ataqueBase;
	}

	@Column(unique = true)
	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	@Lob
	@Column(length = 100000)
	public byte[] getImgEdicion() {
		return imgEdicion;
	}

	public void setImgEdicion(byte[] imgEdicion) {
		this.imgEdicion = imgEdicion;
	}
	@Lob
	@Column(length = 100000)
	public byte[] getImgTerreno() {
		return imgTerreno;
	}

	public void setImgTerreno(byte[] imgTerreno) {
		this.imgTerreno = imgTerreno;
	}

	@OneToMany(mappedBy = "modeloCaballeroRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public List<Caballero> getfonTList() {
		return caballeroList;
	}

	public void setfonTList(List<Caballero> caballeroList) {
		this.caballeroList = caballeroList;
	}

}
