package com.thinkingandlooking.tablas;

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

public class ServletImagenes extends HttpServlet{ 
	
	String	nombreArma;
	EnumConsultas tipoDeConsulta;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) //
    throws ServletException, IOException {
		
	    nombreArma     = req.getParameter("nombreArma");
	    tipoDeConsulta =
	    		(req.getParameter("tipoDeConsulta")=="CONSULTA_MODELO_ARMA_TERRENO")? 
	    				EnumConsultas.CONSULTA_MODELO_ARMA_TERRENO:
	    				EnumConsultas.CONSULTA_MODELO_ARMA_CABALLERO; 
		
	    byte[] data = pintarArma();
		
		res.setContentType("image/png");
	    res.getOutputStream().write(data);
	}
	
	
	private byte[] pintarArma() throws IOException {
		
		
    	BufferedImage caballero =BufferedImageCache.getInstance().getBufferedImage(nombreArma,tipoDeConsulta);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
		ImageIO.write(caballero, "png", baos);
	
	
		return baos.toByteArray();
	}

}
