package com.thinkinglooking.terreno;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


import javax.imageio.ImageIO;



/**
  Clase que representa el tablero esta integrada por coordenadas y cada usuario posee
  Su propio Terreno
 */


public class Terreno {
	
	private String idUsuario;
	private char [][] matrizTerreno;
	private char [][] matrizArmas;
	private static int  tamanioTiles;

	
	//constructor que inicializa un terreno 
	public Terreno ( )
	{
		 idUsuario=new String ("-1");
		 matrizTerreno=null;
		 matrizArmas=null;
		 tamanioTiles=40;
		 
	 
	}
	
	//Constructor que crea un terreno con (nxn) pixeles 
	public Terreno (String idUsuario) 
	{
		this.idUsuario =  idUsuario;
		tamanioTiles=40;
		setDimension(16); //ojo consultar en base de datos cual es la dimension del terreno del usuario correspondiente
		cargarMatrizTerreno();
		
		//cargarMatrizArmas();
		this.matrizArmas   = new char [getDimensionmatrizTerreno()][getDimensionmatrizTerreno()];
		 
		  matrizArmas[1][1]='a';
	      matrizArmas[1][5]='b';
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
	    		  
	    		    Imagen= irc.getBufferedImage(obtenerPathTileTerreno(matrizTerreno[i][j]));	    	       
				    g2d.setColor(Color.BLACK);
				    // g2d.drawRect(i*tamanioTiles, j*tamanioTiles, tamanioTiles,tamanioTiles);
			        g2d.drawImage(Imagen,j*tamanioTiles, i*tamanioTiles, tamanioTiles,tamanioTiles, null);
			        
			        if(matrizArmas==null)
			        	continue;
			        System.out.printf("%c \n",matrizArmas[i][j]);
			        
			        Imagen= irc.getBufferedImage(obtenerPathTileArma(matrizArmas[i][j]));
			        if(Imagen==null)
			        	continue;
			        g2d.drawImage(Imagen,j*tamanioTiles, i*tamanioTiles, tamanioTiles,tamanioTiles, null);
			        
		    	}
	      }
	  

	    g2d.dispose();

	   // Write to a a byte array instead of a file
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bimg, "png", baos);

	    return baos.toByteArray();
		
	}
	
	public void cargarMatrizTerreno()
	 {
		
		  matrizTerreno=TerrenoLoader.loadData(Integer.parseInt(idUsuario));
	 }

	public int getDimensionmatrizTerreno()
	{
		return matrizTerreno.length; 
	}
	
	public static int getSizeTiles()
	{
		return tamanioTiles;
		
	}
	
	public void addArmaTerreno(int x, int y, char arm)
	 {
		System.out.printf("subio \n");
		 if(matrizArmas==null)
				this.matrizArmas   = new char [getDimensionmatrizTerreno()][getDimensionmatrizTerreno()];
		 
		 // matrizArmas[1][1]=arm;
	     // matrizArmas[1][5]=arm;
		 
		  if(matrizArmas[x][y]== 0)
		  {
			  //descontar arma de lista de armas disponibles para que no se muestre en tabla
			  matrizArmas[x][y]=arm;
		  }
		  else
		  {
			  //regresar arma actual en esa posicion a la lista de armas disponibles
			  //para actualizar tabla
			  //luego si añadir a terreno y descontar de tabla
		  }
			 
	}
	
	public void sustituirArmaTerreno(int viejaX,int viejaY,int nuevaX,int nuevaY)
	{
		
		if (matrizArmas[viejaX][viejaY]==0)
				return ;
		if(matrizArmas[nuevaX][nuevaY]!= 0);
			// devolver esta arma a la tabla equi a inventario
			
		
			  matrizArmas[nuevaX][nuevaY]= matrizArmas[viejaX][viejaY];
			  matrizArmas[viejaX][viejaY]=0;
			  
			  
		
	}
	
	
	public  String obtenerPathTileTerreno (char caracter)
	{
		String imagen=new String();
		
		switch (caracter) {
			case 'a':
				imagen="./Images/terreno/a.gif";
				break;
				
			case 'b':
				imagen="./Images/terreno/b.gif";
				break;
				
			case 'c':
				imagen="./Images/terreno/c.gif";
				break;
			case 'd':
				imagen="./Images/terreno/d.gif";
				break;
			case 'e':
				imagen="./Images/terreno/e.gif";
				break;
			case 'f':
				imagen="./Images/terreno/f.gif";
				break;
			case 'g':
				imagen="./Images/terreno/f.gif";
				break;
			case 'h':
				imagen="./Images/terreno/h.gif";
				break;
			case 'i':
				imagen="./Images/terreno/i.gif";
				break;
			case 'j':
				imagen="./Images/terreno/j.gif";
				break;
			case 'k':
				imagen="./Images/terreno/k.gif";
				break;
			case 'l':
				imagen="./Images/terreno/l.gif";
				break;
			case 'm':
				imagen="./Images/terreno/m.gif";
				break;
			case 'n':
				imagen="./Images/terreno/n.gif";
				break;
			case 'o':
				imagen="./Images/terreno/o.gif";
				break;
			case 'p':
				imagen="./Images/terreno/p.gif";
				break;
			case 'q':
				imagen="./Images/terreno/q.gif";
				break;
			case 'r':
				imagen="./Images/terreno/r.gif";
				break;
			case 's':
				imagen="./Images/terreno/s.gif";
				break;
			case 't':
				imagen="./Images/terreno/t.gif";
				break;
			case 'u':
				imagen="./Images/terreno/u.gif";
				break;
			case 'v':
				imagen="./Images/terreno/v.gif";
				break;
			case 'w':
				imagen="./Images/terreno/w.gif";
				break;
			case 'x':
				imagen="./Images/terreno/x.gif";
				break;
			case 'y':
				imagen="./Images/terreno/y.gif";
				break;
			case 'z':
				imagen="./Images/terreno/y.gif";
				break;
				
			default:
				
				break;
		}
		
		return(imagen);
	
	}
	
	public  String obtenerPathTileArma(char caracter)
	{
		String imagen=new String();
		
		switch (caracter) {
			case 'a':
				imagen="./Images/armas/Gallina.gif";
				break;
				
			case 'b':
				imagen="./Images/armas/Luz.gif";
				break;
				
			case 'c':
				imagen="./Images/armas/LanzaRocas.jpg";
				break;
			case 'd':
				imagen="./Images/armas/TrampaLava.gif";
				break;
			case 'e':
				imagen="./Images/armas/Superlobo.gif";
				break;
			case 'g':
				imagen="./Images/armas/Dragon.gif";
				break;
	
			default:
				imagen="nulo";
				break;
		}
		
		return(imagen);
	
	}
	
		
}
	
