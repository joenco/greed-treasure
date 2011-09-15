package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.image.BufferedImage;


public class ArmaEnExtremidad {
	private String extremidad;
	private BufferedImage bi;
	
	public ArmaEnExtremidad(String estre, BufferedImage bi) {
		extremidad = estre;
		this.bi = bi;
	}

	public BufferedImage getBi() {
		return bi;
	}

	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}

	public void setExtremidad(String extremidad) {
		this.extremidad = extremidad;
	}

	public String getExtremidad() {
		return extremidad;
	}
}
