package gui;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.hibernate.Session;

import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import db.SessionHibernate;
import db.User;


/** 
  Clase que representa el tablero esta integrada por coordenadas y cada usuario posee
  Su propio Terreno
 */


public class Terrenojona {
	
	String idUsuario;
	char [][] matriz;
	int  pixelesX;
	int  pixelesY;
	
	//constructor que inicializa un terreno 
	public Terrenojona ( )
	{
		 idUsuario="-1";
		 matriz=null;
		 pixelesX=0;
		 pixelesY=0;
		
	}
	
	//Constructor que crea un terreno con (nxn) pixeles 
	public Terrenojona (String idUsuario,int dim,int pixeles )
	{
		this.idUsuario = idUsuario;
		setDimension(dim);
		setPixles(pixeles,pixeles);
		
	}
	
	//Constructor que crea un terreno con (nxm) pixeles 
	public Terrenojona (String idUsuario,int dim,int pixelesX,int pixelesY )
	{
		this.idUsuario = idUsuario;
		setDimension(dim);
		setPixles(pixelesX,pixelesY);
	}
		
	
	public void setDimension(int dim)
	{
		if( dim < 10)
			dim=10;
		
		this.matriz    = new char [dim][dim];
		
	}
	
	public void setPixles(int pixelesX,int pixelesY )
	{
		if( pixelesX < 600)
			pixelesX=600;
		
		if( pixelesY < 600)
			pixelesY=600;
		
		this.pixelesX= pixelesX;
		this.pixelesY= pixelesY;
		
	}

	public  byte[] pintarTerreno() throws IOException 
	{
		 
		int dimension= matriz.length;
	
		//Pruebas
		System.out.printf("eso es dimension %d",dimension);
		System.err.print(dimension);
		
		
		
		BufferedImage bimg = new BufferedImage(pixelesX,pixelesY , BufferedImage.TYPE_3BYTE_BGR);

	    Graphics2D g2d = (Graphics2D) bimg.getGraphics();

	

	
	    g2d.setBackground(Color.WHITE);
	    g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());
	    
	    File file =  new File(getClass().getResource("grama.gif").getPath());
	    BufferedImage pulgoso = ImageIO.read(file);
	    
	    int anchoTiles = bimg.getWidth()/dimension;
	    int altoTiles  = bimg.getHeight()/dimension;
	    
	    System.out.printf("dimensiones %d %d %d %d",anchoTiles,altoTiles,pixelesX,pixelesY);
	    
	    for (int i=0;i<matriz.length;i++) {
	    	for(int j=0;j<matriz.length;j++)
		    	{
			       
				        g2d.setColor(Color.BLACK);
				        g2d.drawRect(i*anchoTiles, j*altoTiles, anchoTiles,altoTiles);
				        g2d.drawImage(pulgoso, i*anchoTiles, j*altoTiles, anchoTiles,altoTiles, null);
				        
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
		     idUsuario=String.valueOf(userId);
			 matriz=new char[16][16];
			 pixelesX=5000/16;
			 pixelesY=560/16;
		// return true;
		 
	 }

	public int getDimensionMatriz()
	{
		return matriz.length;
	}
	
	public int getPixelesX()
	{
		return pixelesX;
	}
	
	public int getPixelesY()
	{
		return pixelesY;
	}

	}
	