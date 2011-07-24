package com.thinkingandlooking.paneles.ataque;

import org.hibernate.Session;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;


public class AtacarTerreno extends Panel {

		private User atacante;
		private User atacado;
	    private Session session;
	
	public AtacarTerreno(int idAtacante , int idAtacado) {
		
	    iniciarSesion();
		cargarUsuarios( idAtacante , idAtacado);
		initGUI();
		cerrarSesion();
		
	}

	private void cerrarSesion() {
		session.getTransaction().commit();
		session.close();
	}

	private void iniciarSesion() {
		session = SessionHibernate.getInstance().getSession();
	    session.beginTransaction();
	}
	
	

	private void cargarUsuarios(int idAtacante, int idAtacado) {
		

	    atacante = (User) session.load(User.class, idAtacante);
	    atacado  = (User) session.load(User.class, idAtacado);
	}

	private void initGUI() {

		Column col = new Column();
	    add(col);
	    col.add(new Label("********************************"));
	    col.add(new Label("Atacando a "+atacado.getNick()));
	    col.add(new Label("********************************"));
	    col.add(new Label("Estas atacando el terreno: "+atacado.getTerreno()));
	    add(col);

		}
	
	
}
