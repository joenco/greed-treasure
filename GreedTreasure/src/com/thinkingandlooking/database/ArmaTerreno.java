package com.thinkingandlooking.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_arma_terreno")
@Proxy(lazy = false)
public class ArmaTerreno {
	private int id;
	private int municiones_actuales;
	private CoordenadaArma coorArmaRef;
	private ModeloArmaTerreno modelRef;
	private Caballero caballeroRef;

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuniciones_actuales() {
		return municiones_actuales;
	}

	public void setMuniciones_actuales(int municiones_actuales) {
		this.municiones_actuales = municiones_actuales;
	}

	
	
	 @OneToOne(cascade = CascadeType.ALL, mappedBy = "armaTerrenoRef")
	public CoordenadaArma getCoorArmaRef() {
		return coorArmaRef;
	}

	public void setCoorArmaRef(CoordenadaArma coorArmaRef) {
		this.coorArmaRef = coorArmaRef;
	}
	
	@ManyToOne
	public ModeloArmaTerreno getModelRef() {
		return modelRef;
	}

	public void setModelRef(ModeloArmaTerreno modelRef) {
		this.modelRef = modelRef;
	}

	@ManyToOne
	public Caballero getCaballeroRef() {
		return caballeroRef;
	}

	public void setCaballeroRef(Caballero caballeroRef) {
		this.caballeroRef = caballeroRef;
	}

}
