/*
 * Created on 13/04/2007
 */
package com.thinkingandlooking.paneles.edicionterreno;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author Demián Gutierrez
 */
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

  public BufferedImage getBufferedImage(String path)throws IOException  {
	  
	  if(path=="nulo")
		  return null;
    String key = BufferedImage.class.getName() + ":" +path;
   
    BufferedImage ret = BufferedImageMap.get(key);

    if (ret == null) {
  
    	File file =  new File(getClass().getResource(path).getPath());
  	    ret= ImageIO.read(file);
  	    BufferedImageMap.put(key, ret);
    }

    return ret;
  }
  
  
}
