package com.thinkingandlooking.paneles.edicionterreno;


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
		  
		
		String	userLogin =req.getParameter("user_login");
	    String 	coordenadaX=req.getParameter("coordenada_x");
	    String  coordenadaY=req.getParameter("coordenada_y");
	    String 	nuevaCoordenadaX=req.getParameter("nueva_x");
	    String  nuevaCoordenadaY=req.getParameter("nueva_y");
	    char  	arma=		req.getParameter("caracter_arma").charAt(0);
	    


	    Terreno terreno= new Terreno(userLogin); //ojo si retorna nulo entonces es que aun no tiene terreno deberia mandar a elegir uno
	  
	    
	    if (arma == '0' && nuevaCoordenadaX.equals("-1"))
	    {	res.setContentType("image/png");
	    	res.getOutputStream().write(terreno.pintarTerreno());
	    }	
	    else 
	    	{
			     if(!nuevaCoordenadaX.equals("-1") )
			    {
			    	
			    	terreno.sustituirArmaTerreno(Integer.valueOf(coordenadaX),Integer.valueOf(coordenadaY),
			    							 Integer.valueOf(nuevaCoordenadaX),Integer.valueOf(nuevaCoordenadaY	));
			    	
			     }		
			     else if(arma != '0')
				    	terreno.addArmaTerreno(Integer.valueOf(coordenadaX),Integer.valueOf(coordenadaY),arma);
			   
				res.setContentType("image/png");
			    res.getOutputStream().write(terreno.pintarTerreno());
	    	}   
	    
	  }
}
