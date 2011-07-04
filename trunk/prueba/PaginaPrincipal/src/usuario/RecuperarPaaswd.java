package usuario;

import db.User;
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

/**
 * @author Anna Lezama
 *  @modificado por: Jorge Ortega
 */

public class RecuperarPaaswd extends ContentPane {

	private HtmlLayout htmlLayout;

	public RecuperarPaaswd() {
		initGUI();
	}

	private void initGUI() {
		// setBackground(new Color(197, 217, 161));

		loadHtmlTemplate("welcome.html");

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("Olvido su contraseña? Ingrese los datos para recuperarla");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("formLogin");
		FormPasswd formPasswd= new FormPasswd();
		formPasswd.setLayoutData(hld);
		formPasswd.getActionListenerProxyError()
				.addActionListener(listenerError);
		formPasswd.getActionListenerProxyOk().addActionListener(listenerOk);
		htmlLayout.add(formPasswd);

		hld = new HtmlLayoutData("createAccount");
		Button btn = new Button("Cancelar");
		btn.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btn.setBackground(new Color(117, 145, 118));
		btn.setWidth(new Extent(70));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancellClicked();
			}
		});
		btn.setLayoutData(hld);
		htmlLayout.add(btn);

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
		User user = (User) evt.getSource();
		removeAll();
		Passwd passwd = new Passwd(user);
		add(passwd);
	}

	private void btnCancellClicked() {
		removeAll();
		add(new Welcome());
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