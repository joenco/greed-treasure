package com.thinkingandlooking.recuperarpass;

import org.hibernate.Session;
import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;


public class Passwd extends ContentPane {

	private Usuario usuario; 
	private HtmlLayout htmlLayout;

	public Passwd(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		// setBackground(new Color(197, 217, 161));
		try {
			htmlLayout = new HtmlLayout(
					//
					getClass().getResourceAsStream("recuperapass.html"),
					"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("!Solicitud de contraseña!");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("elemento1");
		Column col = new Column();
		col.add(new Label("Hola "+usuario.getNombre()+" "+usuario.getApellido()));
		col.add(new Label("Su contraseña es: "+usuario.getPassword()));
		col.setLayoutData(hld);
		add(col);
		htmlLayout.add(col);

		hld = new HtmlLayoutData("elemento2");
		Button btnStart = new Button("Volver al ínicio");
		btnStart.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnStart.setBackground(new Color(117, 145, 118));
		btnStart.setWidth(new Extent(70));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartClicked();
			}
		});
		btnStart.setLayoutData(hld);
		htmlLayout.add(btnStart);

		add(htmlLayout);
	}

	private void btnStartClicked() {

		((MainApp)ApplicationInstance.getActive()).startWelcome();
	}

	private void loadHtmlTemplate(String templateName) {
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream(templateName), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
