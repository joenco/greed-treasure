/*
 * Created on 13/04/2007
 */
package com.thinkingandlooking.paneles.edicionterreno;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thinkingandlooking.database.MetodosTerreno;



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
  
  
}
