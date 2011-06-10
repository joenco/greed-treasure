package com.thinkinglooking.terreno;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jonathan Monsalve y Jesus Gaviria <br>
 *         Created on Jun 9, 2011
 */

public class DynTerrenoDataServlet extends HttpServlet {

	
	  protected void doGet(HttpServletRequest req, HttpServletResponse res) //
	      throws ServletException, IOException {

	    String	userIdStr  =req.getParameter("user_id");
	    String 	coordenadaX=req.getParameter("coordenada_x");
	    String  coordenadaY=req.getParameter("coordenada_y");
	    char  	arma=		req.getParameter("caracter_arma").charAt(0);
	    int userIdInt = -1;

	    try {
	      userIdInt = Integer.parseInt(userIdStr);
	    } catch (NumberFormatException e) {
	      // ----------------------------------------
	      // Do nothing, userIdInt will remain in -1
	      // ----------------------------------------
	    }

	    Terreno terreno= new Terreno(userIdStr); //ojo si retorna nulo entonces es que aun no tiene terreno deberia mandar a elegir uno
	    System.out.printf("eso es %s %s %c \n",coordenadaX,coordenadaY,arma);
	    if(arma != '0')
	    	terreno.addArmaTerreno(Integer.valueOf(coordenadaX),Integer.valueOf(coordenadaY),arma);
	    res.setContentType("image/png");
	    res.getOutputStream().write(terreno.pintarTerreno());
	  }
}
