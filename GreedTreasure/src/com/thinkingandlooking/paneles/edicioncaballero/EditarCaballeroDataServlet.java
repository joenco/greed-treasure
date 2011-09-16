package com.thinkingandlooking.paneles.edicioncaballero;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;



public class EditarCaballeroDataServlet extends HttpServlet{
	String	IdLogin;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) //
    throws ServletException, IOException {
		
	    IdLogin  = req.getParameter("login");
		
		byte[] data = pintarArma();
		
		res.setContentType("image/png");
	    res.getOutputStream().write(data);
	}
	
	private byte[] pintarArma() throws IOException {
		
		
    	BufferedImage caballero = BufferedImageCache.getInstance().getBufferedImage(IdLogin,EnumConsultas.CONSULTA_EDICION_IMAGEN_CABALLERO);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(caballero, "png", baos);
      
		return baos.toByteArray();
	}
}