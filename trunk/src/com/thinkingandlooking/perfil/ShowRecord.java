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

	private Usuario usuario;

	public ShowRecord(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();

	    usuario = (Usuario) session.load(Usuario.class, usuario.getId());

	    Column col = new Column();
	    add(col);

	    col.add(new Label("----------------------------------------"));
	    if(usuario.getCaballero() != null)
	    	col.add(new Label("| Usuario: "+usuario.getLogin()+"  |  Nivel: "+usuario.getCaballero().getNivel()+"  |  Oro: "+usuario.getCaballero().getOro()));
	    else
	    	col.add(new Label("| Usuario: "+usuario.getLogin()));
	    col.add(new Label("----------------------------------------"));
	   
	    //+"  |  Nro de Victorias: "+usuario.getVictoria()+"  |  Nro de Derrotas: "+usuario.getDerrota()+"|"
		add(col);

		session.getTransaction().commit();
		session.close();

	}
	
}
