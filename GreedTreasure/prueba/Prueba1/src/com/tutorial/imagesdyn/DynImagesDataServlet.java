package com.tutorial.imagesdyn;

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

/**
 * @author Demián Gutierrez <br>
 *         Created on Jun 24, 2008
 */
public class DynImagesDataServlet extends HttpServlet {

  // Here we create a buffered image dynamically and then we transform it
  // to a byte array in order to stream it to the client.
  private byte[] loadImage(List<Cuadrilla_Terreno> cuadrilla_terrenoList) throws IOException {
    BufferedImage bimg = new BufferedImage(360, 360, BufferedImage.TYPE_INT_BGR);

    Graphics2D g2d = (Graphics2D) bimg.getGraphics();

    // Leer la imagen lo menos posible...
    File file = new File(getClass().getResource("pulgoso.gif").getPath());
    BufferedImage pulgoso = ImageIO.read(file);
    
   File file1 = new File(getClass().getResource("msn.gif").getPath());
    BufferedImage msn = ImageIO.read(file1);
    
    //g2d.setBackground(Color.CYAN);
    g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());

    for (Cuadrilla_Terreno cuadrilla_terreno : cuadrilla_terrenoList) {
     
  /*   g2d.fillOval(cuadrilla_terreno.bx - cuadrilla_terreno.ty, cuadrilla_terreno.ty - cuadrilla_terreno.ty,
          2 * cuadrilla_terreno.tx, 2 * cuadrilla_terreno.tx);*/

        if (cuadrilla_terreno.name == "msn")
        g2d.drawImage(msn, cuadrilla_terreno.tx, cuadrilla_terreno.ty, 60, 60, null);
    	
    	if (cuadrilla_terreno.name == "pulgoso")
    	g2d.drawImage(pulgoso, cuadrilla_terreno.tx, cuadrilla_terreno.ty, 60, 60, null);
        
      	if (cuadrilla_terreno.name == "pulga")
        	g2d.drawImage(pulgoso, cuadrilla_terreno.tx, cuadrilla_terreno.ty, 60, 60, null);


      
    }
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
    } catch (NumberFormatException e) {
      // ----------------------------------------
      // Do nothing, userIdInt will remain in -1
      // ----------------------------------------
    }

    List<Cuadrilla_Terreno> cuadrilla_terrenoList = Cuadrilla_TerrenoLoader.loadData(userIdInt);
    byte[] data = loadImage(cuadrilla_terrenoList);

    res.setContentType("image/png");
    res.getOutputStream().write(data);
  }
}
