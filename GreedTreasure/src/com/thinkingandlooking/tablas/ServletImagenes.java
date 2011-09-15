package com.thinkingandlooking.tablas;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkingandlooking.paneles.edicioncaballero.ImageCacheCaballero;

public class ServletImagenes extends HttpServlet{ 
	
	String	nombreArma;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) //
    throws ServletException, IOException {
		
	    nombreArma  = req.getParameter("nombreArma");
		
		byte[] data = pintarArma();
		
		res.setContentType("image/png");
	    res.getOutputStream().write(data);
	}
	
	
	private byte[] pintarArma() throws IOException {
		
		
    	BufferedImage caballero = ImageCacheCaballero.getInstance().getBufferedImage(new String("tico"));//nombreArma);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
		ImageIO.write(caballero, "png", baos);
	
	
		return baos.toByteArray();
	}

}
