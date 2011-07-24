package com.thinkingandlooking.perfil;

import org.hibernate.Session;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;



public class Start extends Panel{
	
	private User user;

	public Start(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().getSession();
	    session.beginTransaction();
	    
	    user = (User) session.load(User.class, user.getId());
	    
	    Column col = new Column();
	    col.add(new Label("Hola "+user.getNick()));
	    col.add(new Label("Tu Castillo y Caballero estan listos para recibir órdenes!"));
	    col.add(new Label("Tu terreno es: "+user.getTerreno()));

	    add(col);
	    
	    session.getTransaction().commit();
		session.close();
		
	}

}