package com.thinkingandlooking.perfil;


import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;


/**
 * @autor: Jorge Ortega
 */

public class ShowRecord extends Panel {

	private User user;

	public ShowRecord(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().getSession();
	    session.beginTransaction();

	    user = (User) session.load(User.class, user.getId());

	    Column col = new Column();
	    add(col);

	    col.add(new Label("----------------------------------------"));
	    col.add(new Label("| Usuario: "+user.getNick()+"  |  Nivel: "+user.getNivel()+"  |  Oro: "+user.getCantOro()+"  |  Nro de Victorias: "+user.getVictoria()+"  |  Nro de Derrotas: "+user.getDerrota()+"|"));
	    col.add(new Label("----------------------------------------"));

		add(col);

		session.getTransaction().commit();
		session.close();

	}
	
}
