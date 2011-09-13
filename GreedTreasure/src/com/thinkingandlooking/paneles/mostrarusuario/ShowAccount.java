package com.thinkingandlooking.paneles.mostrarusuario;

import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;


public class ShowAccount extends Panel {

	private Usuario usuario;

	public ShowAccount(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();

	    usuario = (Usuario) session.load(Usuario.class, usuario.getId());

	    Column col = new Column();
	    add(col);

	    col.add(new Label("Nombre: " + usuario.getNombre()));
	    col.add(new Label("Apellido: " + usuario.getApellido()));
	    col.add(new Label("País: " + usuario.getPais()));
	    col.add(new Label("Tu email es: " + usuario.getEmail()));
	    col.add(new Label("Tu nick/Apodo es: " + usuario.getLogin()));
	    col.add(new Label("Tu tienes "+ usuario.getCaballero().getOro() +" monedas de oro"));
	    col.add(new Label("Tu nivel es: "+ usuario.getCaballero().getNivel()));
	  //  col.add(new Label("Nro de Victorías: "+ usuario.getVictoria())); 
	  // col.add(new Label("Nro de Derrotas: "+usuario.getDerrota()));

	    add(col);

		session.getTransaction().commit();
		session.close();

	}
	
}
