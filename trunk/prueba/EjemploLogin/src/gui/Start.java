package gui;

import org.hibernate.Session;

import db.SessionHibernate;
import db.User;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

/**
 * @author Anna Lezama
 *  @modificado por: Jorge Ortega
 */

public class Start extends Panel{
	
	private User user;

	public Start(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();
	    
	    user = (User) session.load(User.class, user.getId());
	    
	    Column col = new Column();
	    col.add(new Label("Hola "+user.getNick()));
	    col.add(new Label("Tu Castillo y Caballero estan listos para recibir órdenes!"));

	    add(col);
	    
	    session.getTransaction().commit();
		session.close();
		
	}

}
