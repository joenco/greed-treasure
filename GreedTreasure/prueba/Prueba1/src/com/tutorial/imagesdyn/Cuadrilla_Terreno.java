package com.tutorial.imagesdyn;

import java.awt.Image;


public class Cuadrilla_Terreno {

	public String name;
	public int bx;
	public int by;
	public int tx;
	public int ty;
	public Image image;
  
	  public Cuadrilla_Terreno(String name, int bx, int by, int tx, int ty) {
		    this.name = name;
		    this.bx = bx;
		    this.by = by;
		    this.tx = tx;
		    this.ty = ty;
	  }
	  
  public Cuadrilla_Terreno(String name, int bx, int by, int tx, int ty, Image image) {
    this.name = name;
    this.bx = bx;
    this.by = by;
    this.tx = tx;
    this.ty = ty;
    this.image = image;
    
  }
  
}
  
  

