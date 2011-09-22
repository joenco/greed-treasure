package com.thinkingandlooking.paneles.edicionterreno;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynTerrenoDataServlet extends HttpServlet {

	
	  protected void doGet(HttpServletRequest req, HttpServletResponse res) //
	      throws ServletException, IOException {
		  
		
		String	userLogin =req.getParameter("user_login");


	    Terreno terreno= new Terreno(userLogin); 
   
	 	res.setContentType("image/png");
	    res.getOutputStream().write(terreno.pintarTerreno());
	 	    	 
	    
	  }
}
