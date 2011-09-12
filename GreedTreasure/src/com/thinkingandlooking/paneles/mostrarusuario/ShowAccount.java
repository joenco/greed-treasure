package com.thinkingandlooking.paneles.mostrarusuario;

import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;


public class ShowAccount extends Panel {

	private User user;

	public ShowAccount(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().getSession();
	    session.beginTransaction();

	    user = (User) session.load(User.class, user.getId());

	    Column col = new Column();
	    add(col);

	    col.add(new Label("Nombre: " + user.getName()));
	    col.add(new Label("Apellido: " + user.getLastName()));
	    col.add(new Label("País: " + user.getCountry()));
	    col.add(new Label("Tu email es: " + user.getEmail()));
	    col.add(new Label("Tu nick/Apodo es: " + user.getNick()));
	    col.add(new Label("Tu tienes "+ user.getCantOro() +" monedas de oro"));
	    col.add(new Label("Tu nivel es: "+ user.getNivel()));
	    col.add(new Label("Nro de Victorías: "+ user.getVictoria())); 
	    col.add(new Label("Nro de Derrotas: "+user.getDerrota()));

	    add(col);

		session.getTransaction().commit();
		session.close();

	}
	
}
