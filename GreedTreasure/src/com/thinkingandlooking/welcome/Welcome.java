package com.thinkingandlooking.welcome;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.utils.*;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;


public class Welcome extends ContentPane {

	private HtmlLayout htmlLayout;

	public Welcome() {
		super();
		initGUI();
	}

	private void initGUI() {
		// setBackground(new Color(197, 217, 161));

		loadHtmlTemplate("/com/thinkingandlooking/utils/template.html");

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("Bienvenido al Juego de GREED TREASURE!! Ingrese sus datos o registrese para jugar!");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("elemento1");
    	FormLogin formLogin = new FormLogin();
		formLogin.setLayoutData(hld);
		formLogin.getActionListenerProxyError()
				.addActionListener(listenerError);
		formLogin.getActionListenerProxyOk().addActionListener(listenerOk);
		htmlLayout.add(formLogin);

		hld = new HtmlLayoutData("elemento2");
		Button btn = new Button("Registrarse");
		btn.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btn.setBackground(new Color(117, 145, 118));
		btn.setWidth(new Extent(70));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCreateAccountClicked();
			}
		});
		btn.setLayoutData(hld);
		htmlLayout.add(btn);

		Button btn1 = new Button("Recuperar contraseña");
		btn1.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btn1.setBackground(new Color(117, 145, 118));
		btn1.setWidth(new Extent(70));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRecuperarPasswdClicked();
			}
		});
		btn1.setLayoutData(hld);
		htmlLayout.add(btn1);

		add(htmlLayout);
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
		
		if(usuario.getCaballero()== null)
			((MainApp) ApplicationInstance.getActive()).startElegirCaballero(usuario);
		
		else if (usuario.getCaballero().getIdRef() == null)
			((MainApp) ApplicationInstance.getActive()).startElegirTerreno(usuario);
		
		((MainApp) ApplicationInstance.getActive()).startPerfil(usuario);
			
	}

	private void btnCreateAccountClicked() {
		((MainApp) ApplicationInstance.getActive()).startCreateAccount();
		
	}

	private void btnRecuperarPasswdClicked() {
		((MainApp)ApplicationInstance.getActive()).startRecuperarPass();
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
