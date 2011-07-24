package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import echopoint.model.RectangleSection;

public class EditarCaballeroDataServlet extends HttpServlet{
	String	IdPos;
	String	IdArma;	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) //
    throws ServletException, IOException {
//		IdPos = new String(req.getParameter("idPos"));
//		IdArma  = new String( req.getParameter("idArma"));
	    IdPos  = req.getParameter("idPos");
		IdArma  = req.getParameter("idArma");
		
		byte[] data = pintarArma();
		
		res.setContentType("image/png");
	    res.getOutputStream().write(data);
	}
	private byte[] pintarArma() throws IOException {
		BufferedImage bimg = new BufferedImage(400, 400,BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = (Graphics2D) bimg.getGraphics();
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, bimg.getWidth(), bimg.getHeight());
		
		File file1 = new File(getClass().getResource("caballero1.png").getPath());
		BufferedImage caballero = ImageIO.read(file1);
		
		g2d.drawImage(caballero, 0, 0, null);

		if(!IdArma.isEmpty()){
			String con;
			con = IdArma.concat(".png");
			BufferedImage arma = ImageIO.read(getPath(con));
		
			if (IdPos.equals("CABEZA")){
				g2d.drawImage(arma, 175, 25, null);
				System.out.print(IdArma);
			}
			else
				if (IdPos.equals("ManoIzquierda")){
					g2d.drawImage(arma, 75, 225, null);
					System.out.print(IdArma);
				}
				else 
					if (IdPos.equals("ManoDerecha")){
						g2d.drawImage(arma, 325, 225, null);
						System.out.print(IdArma);
					}
					else 
						if (IdPos.equals("Torso")){
							g2d.drawImage(arma, 175, 225, null);
							System.out.print(IdArma);
						}
		}
		g2d.dispose();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bimg, "png", baos);

		return baos.toByteArray();
	}
	private File getPath(String con){
		return new File(getClass().getResource(con).getPath());
	}
}