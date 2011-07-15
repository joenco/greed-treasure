package usuario;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import db.SessionHibernate;
import db.User;
import tablaEnemigo.EnemigoBean;
import tablaEnemigo.EnemigoBeanLoader;
import echopoint.HtmlLayout;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.list.DefaultListModel;
import echopoint.layout.HtmlLayoutData;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

/**
 * @autor: Jorge Ortega
 */

public class AtacarTerreno extends ContentPane {

		User user;
		EnemigoBean userEnemigo;
	HtmlLayout htmlLayout;

	private Label terreno;
	
	public AtacarTerreno(User user, EnemigoBean userEnemigo) {
		this.user = user;
	this.userEnemigo = userEnemigo;
		initGUI();
	}

	private void initGUI() {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		user = (User) session.load(User.class, user.getId());

		session.getTransaction().commit();
		session.close();

		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("atacarTerreno.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		HtmlLayoutData hld;

		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("<---- Atacando a "+userEnemigo.getNick()+"---->");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("terreno");
		Label lblTerreno = new Label("Hola "+user.getNick());
		lblTerreno.setLayoutData(hld);
		htmlLayout.add(lblTerreno);
		terreno =new Label();
		terreno.setText(userEnemigo.getNick());
		terreno.setLayoutData(hld);
		htmlLayout.add(terreno);

		hld = new HtmlLayoutData("buttons");
		Row row =new Row();

		Button btnSalir = new Button("Dejar de atacar");
		btnSalir.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnSalir.setBackground(new Color(117, 145, 118));
		btnSalir.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.CENTER));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bntSalirClicked();
			}
		});
		row.add(btnSalir);

		row.setLayoutData(hld);
		htmlLayout.add(row);

		add(htmlLayout);
	}

	protected void bntSalirClicked() {
		removeAll();
		Main main = new Main(user);
		add(main);
	}

/*
	private void modified() {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		terreno = new String();
		terreno =(String) selectTerreno.getSelectedItem();
		
		user.setTerreno(terreno);

		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
*/
	//public ActionListenerProxy getActionListenerProxyError() {
//		return actionListenerProxyError;
//	}
	
//	public ActionListenerProxy getActionListenerProxyOk() {
		//return actionListenerProxyOk;
	//}

}
