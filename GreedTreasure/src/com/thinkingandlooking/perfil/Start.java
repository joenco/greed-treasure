package com.thinkingandlooking.perfil;

import org.hibernate.Session;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;



public class Start extends Panel{
	
	private Usuario usuario;

	public Start(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();
	    
	    usuario = (Usuario) session.load(Usuario.class, usuario.getId());
	    
	    Column col = new Column();
	    col.add(new Label("Hola "+usuario.getLogin()));
	    if (usuario.getCaballero()!= null)
	    {	
		    col.add(new Label("Tu Castillo y Caballero estan listos para recibir órdenes!"));
		    col.add(new Label("Tu terreno es: "+usuario.getCaballero().getIdRef().getName()));
	    }
	    
	    else
	    	col.add(new Label("Escoge un caballero!!"));
	    	
	    add(col);
	    
	    session.getTransaction().commit();
		session.close();
		
	}

}