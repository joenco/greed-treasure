package com.thinkingandlooking.paneles.elegirterreno;

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
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class Terrenos extends Panel {

	User user;
	HtmlLayout htmlLayout;

	
	private SelectField selectTerreno;
	private DefaultListModel listModel;
	
	public Terrenos(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {

		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("terrenos.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("Elija un terreno!");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("terreno");
		Label lblTerreno = new Label("Hola "+user.getNick()+", te hace falta un terreno, elije el que mas te guste.");
		lblTerreno.setLayoutData(hld);
		htmlLayout.add(lblTerreno);
		listModel = new DefaultListModel(new String[] {
				"Playa caribe", "Alpes rocoso", "Antartida arenosa", "Desierto pantanoso"
		} );
		selectTerreno = new SelectField(listModel);
		selectTerreno.setLayoutData(hld);
		htmlLayout.add(selectTerreno);

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
		Session session = SessionHibernate.getInstance().getSession();
		session.beginTransaction();
		String terreno = new String();
		terreno =(String) selectTerreno.getSelectedItem();
		
		user.setTerreno(terreno);

		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		((MainApp)ApplicationInstance.getActive()).startPerfil(user);
		
	}

}
