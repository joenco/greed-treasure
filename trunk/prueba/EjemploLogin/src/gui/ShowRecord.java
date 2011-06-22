package gui;

import org.hibernate.Session;

import db.SessionHibernate;
import db.User;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

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
		
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();

	    user = (User) session.load(User.class, user.getId());

	    Column col = new Column();
	    add(col);

	    col.add(new Label("----------------------------------------"));
	    col.add(new Label("Usuario: "+user.getNick()+"    Oro: "+user.getCantOro()+"    Nro de Victorias: "+user.getVictoria()+"    Nro de Derrotas: "+user.getDerrota()));
	    col.add(new Label("----------------------------------------"));

		add(col);

		session.getTransaction().commit();
		session.close();

	}
	
}
