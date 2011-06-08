package com.thinkinglooking.terreno;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import nextapp.echo.app.Color;

/**
 * @author Demián Gutierrez <br>
 *         Created on Jun 24, 2008
 */
public class DynTerrenoDataServlet extends HttpServlet {

	 // Here we create a buffered image dynamically and then we transform it
	  // to a byte array in order to stream it to the client.
	  private byte[] loadImage() throws IOException {
	    BufferedImage bimg = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);

	    Graphics2D g2d = (Graphics2D) bimg.getGraphics();

	
	    g2d.clearRect(0, 0,bimg.getWidth(), bimg.getHeight());
	
	    g2d.setBackground(Color.BLACK);
	    g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());
	    
	    File file = new File(getClass().getResource("puente.gif").getPath());
	    BufferedImage pulgoso = ImageIO.read(file);
	    g2d.setColor(Color.blue);
	    g2d.fillOval(5, 5,	200,200);
	    
	   g2d.drawImage(pulgoso, 5,5, null);

	  

	    g2d.dispose();

	    // Write to a a byte array instead of a file
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bimg, "png", baos);

	    return baos.toByteArray();
	  }

	  // --------------------------------------------------------------------------------

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res) //
	      throws ServletException, IOException {

	    String userIdStr = req.getParameter("user_id");

	    int userIdInt = -1;

	    try {
	      userIdInt = Integer.parseInt(userIdStr);
	      System.out.printf("id enviado y leido %d",userIdInt);
	    } catch (NumberFormatException e) {
	      // ----------------------------------------
	      // Do nothing, userIdInt will remain in -1
	      // ----------------------------------------
	    }

	   
	   // byte[] data = loadImage();
        Terreno terreno= new Terreno("2",16,640,640);
	    res.setContentType("image/png");
	    res.getOutputStream().write(terreno.pintarTerreno());
	  }
}
