package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nextapp.echo.app.HttpImageReference;

import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;

public class TablaExtremidadDataServlet extends HttpServlet{
	String	nombreArma;
	EnumConsultas tipoDeConsulta;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) //
    throws ServletException, IOException {
		
		String nombreArma = req.getParameter("arma");
		//HttpImageReference("imagenes_tabla?extremidad="
			//	+ armaEnExtremidad.getRefModel().getNombre()
				//+ "&tipoDeConsulta=CONSULTA_MODELO_ARMA_TERRENO");
		
		
		
	    tipoDeConsulta =
	    		(req.getParameter("tipoDeConsulta").equals("CONSULTA_MODELO_ARMA_TERRENO"))? 
	    				EnumConsultas.CONSULTA_MODELO_ARMA_TERRENO:
	    				EnumConsultas.CONSULTA_MODELO_ARMA_CABALLERO;
	    
	    byte[] data = pintarArma();
		
		
		res.setContentType("image/png");
	    res.getOutputStream().write(data);
	}
	
	
	private byte[] pintarArma() throws IOException {
		
		
    	BufferedImage	byteArma =BufferedImageCache.getInstance().getBufferedImage(nombreArma,tipoDeConsulta);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
		ImageIO.write(byteArma, "png", baos);
	
	
		return baos.toByteArray();
	}
}
