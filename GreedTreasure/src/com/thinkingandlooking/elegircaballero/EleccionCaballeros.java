package com.thinkingandlooking.elegircaballero;

import org.hibernate.Query;
import org.hibernate.Session;



import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;

import echopoint.HtmlLayout;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.list.DefaultListModel;
import echopoint.layout.HtmlLayoutData;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class EleccionCaballeros extends ContentPane  {

	Usuario usuario;
	HtmlLayout htmlLayout;

	
	private SelectField selectCaballero;
	private DefaultListModel listModel;
	
	public EleccionCaballeros (Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {

		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("caballeros.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("Elija un caballero!");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("caballeros");
		Label lblTerreno = new Label("Hola "+usuario.getLogin()+", te hace falta un caballero, elije el que mas te guste.");
		lblTerreno.setLayoutData(hld);
		htmlLayout.add(lblTerreno);
		listModel = new DefaultListModel(ConsultasModeloCaballero.getModelosCaballerosProvicional());
		selectCaballero = new SelectField(listModel);
		selectCaballero.setLayoutData(hld);
		htmlLayout.add(selectCaballero);

		hld = new HtmlLayoutData("buttons");
		Row row =new Row();

		Button btnModifiedAccount = new Button("Elejir");
		btnModifiedAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnModifiedAccount.setBackground(new Color(117, 145, 118));
		btnModifiedAccount.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.CENTER));
		btnModifiedAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bntModifiedAccountClicked();
			}
		});
		row.add(btnModifiedAccount);

		row.setLayoutData(hld);
		htmlLayout.add(row);

		add(htmlLayout);
	}

	protected void bntModifiedAccountClicked() {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		String nombreModeloCaballero = new String();
		nombreModeloCaballero =(String) selectCaballero.getSelectedItem();
		String str = "FROM ModeloCaballero WHERE nombreModelo=:nombreModelo";
		
		Query query = session.createQuery(str);
		query.setString("nombreModelo",nombreModeloCaballero);
		ModeloCaballero modeloCaballero= (ModeloCaballero)query.uniqueResult();
		
		Caballero caballero = new Caballero();
		caballero.setAtaque(modeloCaballero.getAtaqueBase());
		caballero.setDefensa(modeloCaballero.getDefensaBase());
		caballero.setNivel(1);
		caballero.setVida(100);
		caballero.setOro(1000);
		caballero.setModeloCaballeroRef(modeloCaballero);
		modeloCaballero.getfonTList().add(caballero);
		
		usuario.setCaballero(caballero);
		caballero.setUsuario(usuario);
		
		session.save(modeloCaballero);
		session.save(caballero);
		session.update(usuario);
		System.out.println(modeloCaballero.getAtaqueBase()+" def: "+modeloCaballero.getDefensaBase()+" nom:"+modeloCaballero.getNombreModelo());
		session.getTransaction().commit();
		session.close();
		((MainApp)ApplicationInstance.getActive()).startElegirTerreno(usuario);
		
	}

}
