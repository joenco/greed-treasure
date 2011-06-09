package com.thinkinglooking.terreno;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


/**
  Clase que representa el tablero esta integrada por coordenadas y cada usuario posee
  Su propio Terreno
 */


public class Terreno {
	
	private String idUsuario;
	private char [][] matriz;
	private static int  tamanioTiles;

	
	//constructor que inicializa un terreno 
	public Terreno ( )
	{
		 idUsuario=new String ("-1");
		 matriz=null;
		 tamanioTiles=40;
	 
	}
	
	//Constructor que crea un terreno con (nxn) pixeles 
	public Terreno (String idUsuario,int dim) 
	{
		this.idUsuario =  idUsuario;
		tamanioTiles=40;
		setDimension(dim);
		
	}
	

	
	public void setDimension(int dim)
	{
		if( dim < 10)
			dim=10;
		
		this.matriz    = new char [dim][dim];
		
	}
	
	

	public  byte[] pintarTerreno() throws IOException 
	{
		 
		int dimension= matriz.length;
	
		//Pruebas
		//System.out.printf("eso es dimension %d",dimension);
    	//	System.err.print(dimension);
		
		
		BufferedImage bimg = new BufferedImage(dimension*tamanioTiles,dimension*tamanioTiles,
								 BufferedImage.TYPE_3BYTE_BGR);

	    Graphics2D g2d = (Graphics2D) bimg.getGraphics();

	    g2d.setBackground(Color.WHITE);
	    g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());
	    
	    File file =  new File(getClass().getResource("pulgoso.gif").getPath());
	    BufferedImage pulgoso = ImageIO.read(file);
	    
	   
	    //System.out.printf("dimensiones %d %d %d %d",anchoTiles,altoTiles,pixelesX,pixelesY);
	    
	    for (int i=0;i<matriz.length;i++) {
	    	for(int j=0;j<matriz.length;j++)
		    	{
			       
				     g2d.setColor(Color.BLACK);
				     g2d.drawRect(i*tamanioTiles, j*tamanioTiles, tamanioTiles,tamanioTiles);
			         g2d.drawImage(pulgoso,i*tamanioTiles, j*tamanioTiles, tamanioTiles,tamanioTiles, null);
				        
		    	}
	      }
	  

	    g2d.dispose();

	   // Write to a a byte array instead of a file
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bimg, "png", baos);

	    return baos.toByteArray();
		
	}
	
	public void cargarTerreno(int userId)
	 {
		 //buscar En base de datos y cargar objeto por ahora no
		  //   idUsuario=String.valueOf(userId);
		//	 matriz=new char[16][16];
			// pixelesX=5000/16;
			 //pixelesY=560/16;
		// return true;
		 
	 }

	public int getDimensionMatriz()
	{
		return matriz.length;
	}
	
	public static int getSizeTiles()
	{
		return tamanioTiles;
	}
		
}
	
