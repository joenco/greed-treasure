package com.thinkingandlooking.recuperarpass;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;


public class RecuperarPass extends ContentPane {

	private HtmlLayout htmlLayout;

	public RecuperarPass() {
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
		Label lblTitle = new Label("Olvido su contraseña? Ingrese los datos para recuperarla");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("elemento1");
		FormPasswd formPasswd= new FormPasswd();
		formPasswd.setLayoutData(hld);
		formPasswd.getActionListenerProxyError()
				.addActionListener(listenerError);
		formPasswd.getActionListenerProxyOk().addActionListener(listenerOk);
		htmlLayout.add(formPasswd);
		
		

		hld = new HtmlLayoutData("elemento2");
		Row row = new Row();
		row.setCellSpacing(new Extent(5));
		
		Button btn = new Button("Registrarse");
		btn.setBorder(new Border(new Extent(2), Color.GREEN, 1));
		btn.setBackground(new Color(117, 145, 118));
		btn.setWidth(new Extent(70));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCreateAccountClicked();
			}
		});
		
		Button btnCancel = new Button("Cancelar");
		btnCancel.setBorder(new Border(new Extent(2), Color.RED, 1));
		//btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		
		btnCancel.setBackground(new Color(117, 145, 118));
		btnCancel
				.setAlignment(new Alignment(Alignment.CENTER, Alignment.CENTER));
		btnCancel.setWidth(new Extent(60));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelClicked();
			}
		});
		
		row.add(btn);
		row.add(btnCancel);
		row.setLayoutData(hld);
		htmlLayout.add(row);

		add(htmlLayout);
		
		
		
//		btn.setLayoutData(hld);
//		htmlLayout.add(btn);
//		htmlLayout.add(btnCancel);
//
//		add(htmlLayout);
	}
	
	protected void btnCancelClicked() {
		
		((MainApp)ApplicationInstance.getActive()).startWelcome();
	}
	

	ActionListener listenerError = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			listenerErrorPerformed(evt);
		}
	};

	private void listenerErrorPerformed(ActionEvent evt) {
		WindowPane win = (WindowPane) evt.getSource();
		add(win);
	}

	ActionListener listenerOk = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			listenerOkPerformed(evt);
		}
	};

	private void listenerOkPerformed(ActionEvent evt) {
		
		Usuario usuario = (Usuario) evt.getSource();
		((MainApp)ApplicationInstance.getActive()).mostrarInfoPass(usuario);
	}

	private void btnCreateAccountClicked() {
		((MainApp)ApplicationInstance.getActive()).startCreateAccount();
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
