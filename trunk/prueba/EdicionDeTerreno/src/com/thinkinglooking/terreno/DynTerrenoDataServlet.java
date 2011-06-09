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

	    Terreno terreno= new Terreno(userIdStr,16);
	    res.setContentType("image/png");
	    res.getOutputStream().write(terreno.pintarTerreno());
	  }
}
