/*
 * Created on 13/04/2007
 */
package com.thinkingandlooking.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import com.thinkingandlooking.database.MetodosTerreno;
import com.thinkingandlooking.database.ModeloArmaCaballero;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.ModeloCaballero;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;



public class BufferedImageCache {

  private static BufferedImageCache instance;

  private Map<String, BufferedImage> BufferedImageMap = new HashMap<String, BufferedImage>();

  // ----------------------------------------

  private BufferedImageCache() {
    // Empty
  }

  // ----------------------------------------

  public synchronized static BufferedImageCache getInstance() {
    if (instance == null) {
      instance = new BufferedImageCache();
    }

    return instance;
  }

  // ----------------------------------------

  public BufferedImage getBufferedImage(char caracter)throws IOException  {
	  
	  if(caracter==' ')
		  return null;
	  
    String key = BufferedImage.class.getName() + ":" +caracter;
   
    BufferedImage ret = BufferedImageMap.get(key);

    if (ret == null) {
    	
    	byte [] imageInByte=MetodosTerreno.obtenerImg(caracter);
    	InputStream in = new ByteArrayInputStream(imageInByte);
    	ret = ImageIO.read(in);
  	    BufferedImageMap.put(key, ret);
    }

    return ret;
  }
  
 public BufferedImage getBufferedImage(String nombreBuscado,EnumConsultas tipoConsulta)  {
	  
	 if(nombreBuscado.isEmpty())
		 return null;
	 
		
		Session session= SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		BufferedImage ret=null ;
		byte[] imagenByte=null;
		Criteria criteria;
		String key=null;
		
		
			switch (tipoConsulta) {
				case CONSULTA_MODELO_ARMA_TERRENO:

					criteria = session.createCriteria(ModeloArmaTerreno.class).add(
							Restrictions.eq("nombre", nombreBuscado));
					ModeloArmaTerreno modeloArmaTerreno = (ModeloArmaTerreno) criteria.uniqueResult();
					session.close();
				
					key = BufferedImage.class.getName() + ":" +modeloArmaTerreno.getNombre();
					ret= BufferedImageMap.get(key);
					if (ret != null) 
						return ret;
					
					imagenByte = modeloArmaTerreno.getImagen();
					break;
					
					
				case CONSULTA_MODELO_ARMA_CABALLERO:
						
					
					criteria = session.createCriteria(ModeloArmaTerreno.class).add(
							Restrictions.eq("nombre", nombreBuscado));
					ModeloArmaCaballero modeloArmaCaballero = (ModeloArmaCaballero) criteria.uniqueResult();
					session.close();
				
					key = BufferedImage.class.getName() + ":" +modeloArmaCaballero.getNombre();
					ret= BufferedImageMap.get(key);
					if (ret != null) 		
						return ret;
					
					
					imagenByte = modeloArmaCaballero.getImagen();
					break;
					
				case CONSULTA_EDICION_IMAGEN_CABALLERO:
					criteria = session.createCriteria(Usuario.class).add(
							Restrictions.eq("login", nombreBuscado));
					Usuario usuario = (Usuario) criteria.uniqueResult();
					session.close();
					
					ModeloCaballero modeloCaballero=usuario.getCaballero().getModeloCaballeroRef();
					key = BufferedImage.class.getName() + ":" +modeloCaballero.getNombreModelo();
					ret= BufferedImageMap.get(key);
					
					if (ret != null) 
						return ret;
					
					imagenByte = modeloCaballero.getImgEdicion();
					break;
					
	
				default:
					return null;
				
			}
			
			if((tipoConsulta!=EnumConsultas.CONSULTA_EDICION_IMAGEN_CABALLERO))
				imagenByte=convert(imagenByte);
			
			InputStream in = new ByteArrayInputStream(imagenByte);
			
								
				try {
					ret = ImageIO.read(in);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
            BufferedImageMap.put(key, ret);
          
            return ret;
  }
 
 		public byte[] convert(byte[] bytes)
		{
		     ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		     BufferedImage bufferedImage;
		     ByteArrayOutputStream osByteArray = new ByteArrayOutputStream();
			try {
				 bufferedImage = ImageIO.read(inputStream);
				 ImageOutputStream outputStream = ImageIO.createImageOutputStream(osByteArray);
			     ImageIO.write(bufferedImage, "jpg", outputStream);
			     outputStream.flush();
			     outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    
		     return osByteArray.toByteArray();
		 }
  
}
