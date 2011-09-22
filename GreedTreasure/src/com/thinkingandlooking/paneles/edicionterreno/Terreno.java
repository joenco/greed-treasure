package com.thinkingandlooking.paneles.edicionterreno;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.imageio.ImageIO;

import org.hibernate.Query;
import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;



/**
  Clase que representa el tablero esta integrada por coordenadas y cada usuario posee
  Su propio Terreno
 */


public class Terreno {
	
	private String login;
	private char [][] matrizTerreno;
	private List<ArmaTerreno> listaArmas;
	private static int  tamanioTiles;

	
	//constructor que inicializa un terreno 
	public Terreno ( )
	{
		 login=new String("-1");
		 matrizTerreno=null;
		 listaArmas=null;
		 tamanioTiles=40;
	}
	
	//Constructor que crea un terreno con (nxn) pixeles 
	public Terreno (String login) 
	{
		this.login = login;
		tamanioTiles=25;
		setDimension(16); //ojo consultar en base de datos cual es la dimension del terreno del usuario correspondiente
		cargarMatrizTerreno();
		cargarMatrizArmas();
    

	}
	

	public void setDimension(int dim)
	{
		if( dim < 10)
			dim=10;
		
		this.matrizTerreno    = new char [dim][dim];
	
		
	}
	
	

	public  byte[] pintarTerreno() throws IOException 
	{
		BufferedImage bimg = new BufferedImage(matrizTerreno.length*tamanioTiles,matrizTerreno.length*tamanioTiles,
								 BufferedImage.TYPE_3BYTE_BGR);

	    Graphics2D g2d = (Graphics2D) bimg.getGraphics();

	    g2d.setBackground(Color.WHITE);
	    g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());
	    
	    BufferedImageCache irc = BufferedImageCache.getInstance();
	    BufferedImage Imagen;
	    for (int i=0;i<matrizTerreno.length;i++) {
	    	for(int j=0;j<matrizTerreno.length;j++)
		    	{
	    		    Imagen= irc.getBufferedImage(matrizTerreno[i][j]);	    	       
				    g2d.setColor(Color.BLACK);
				    // g2d.drawRect(i*tamanioTiles, j*tamanioTiles, tamanioTiles,tamanioTiles);
			        g2d.drawImage(Imagen,j*tamanioTiles, i*tamanioTiles, tamanioTiles,tamanioTiles, null);
			  
		    	}
	      }
	    
	    
	    for(ArmaTerreno arma:listaArmas)
	    { 	
	        if(listaArmas.size()==0)
	        	continue;
	        
	        Imagen= irc.getBufferedImage(arma.getModelRef().getNombre(),EnumConsultas.CONSULTA_MODELO_ARMA_TERRENO);
	       
	        if(Imagen==null)
	        	continue;
	      
	        g2d.drawImage(Imagen, arma.getCoorArmaRef().getY()*tamanioTiles,arma.getCoorArmaRef().getX()*tamanioTiles, tamanioTiles,tamanioTiles, null);
	    }
	    g2d.dispose();
	    
	   // Write to a a byte array instead of a file
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bimg, "png", baos);
	    return baos.toByteArray();
	}
	
	public void cargarMatrizTerreno()
	 {
		
		  matrizTerreno=MetodosTerreno.loadData(login); 
	 }
	
	private void cargarMatrizArmas() {
		
		listaArmas=MetodosArmaTerreno.tablaArmaEnUso(login);
		
	}
	
	public int getDimensionmatrizTerreno()
	{
		return matrizTerreno.length; 
	}
	
	public static int getSizeTiles()
	{
		return tamanioTiles;
		
	}
		
}
	
