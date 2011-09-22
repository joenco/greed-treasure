package com.thinkingandlooking.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_arma_caballero")
@Proxy(lazy = false)
public class ArmaCaballero {
	private int id;
	private int municiones_actuales;
	private int extremidad;
	private ModeloArmaCaballero modelRef;
	private Caballero armaCaballeroRef;

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

	public int getExtremidad() {
		return extremidad;
	}

	public void setExtremidad(int extremidad) {
		this.extremidad = extremidad;
	}

	
	@ManyToOne
	public ModeloArmaCaballero getModelRef() {
		return modelRef;
	}

	public void setModelRef(ModeloArmaCaballero modelRef) {
		this.modelRef = modelRef;
	}

	@ManyToOne
	public Caballero getArmaCaballeroRef() {
		return armaCaballeroRef;
	}

	public void setArmaCaballeroRef(Caballero armaCaballeroRef) {
		this.armaCaballeroRef = armaCaballeroRef;
	}

}
