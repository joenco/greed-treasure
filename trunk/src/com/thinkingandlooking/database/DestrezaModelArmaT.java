package com.thinkingandlooking.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_destreza_model_arma_t")
@Proxy(lazy = false)
public class DestrezaModelArmaT {
	private int id;
	private ModeloArmaTerreno modelArmaTRef;
	private Destreza destrezaMRef;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public ModeloArmaTerreno getModelArmaTRef() {
		return modelArmaTRef;
	}

	public void setModelArmaTRef(ModeloArmaTerreno modelArmaTRef) {
		this.modelArmaTRef = modelArmaTRef;
	}

	@ManyToOne
	public Destreza getDestrezaMRef() {
		return destrezaMRef;
	}

	public void setDestrezaMRef(Destreza destrezaMRef) {
		this.destrezaMRef = destrezaMRef;
	}

}
