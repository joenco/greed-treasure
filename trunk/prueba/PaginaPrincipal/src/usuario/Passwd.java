package usuario;

import org.hibernate.Session;
import db.SessionHibernate;
import db.User;
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

/**
 * @author Anna Lezama
 *  @modificado por: Jorge Ortega
 */

public class Passwd extends ContentPane {

	private User user; 
	private HtmlLayout htmlLayout;

	public Passwd(User user) {
	this.user = user;
		initGUI();
	}

	private void initGUI() {
		// setBackground(new Color(197, 217, 161));

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		user = (User) session.load(User.class, user.getId());
		session.getTransaction().commit();
		session.close();


		loadHtmlTemplate("welcome.html");

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("!Solicitud de contraseña!");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("formLogin");
		Column col = new Column();
		col.add(new Label("Hola "+user.getName()+" "+user.getLastName()));
		col.add(new Label("Su contraseña es: "+user.getPass()));
		col.setLayoutData(hld);
		add(col);
		htmlLayout.add(col);

		hld = new HtmlLayoutData("createAccount");
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
