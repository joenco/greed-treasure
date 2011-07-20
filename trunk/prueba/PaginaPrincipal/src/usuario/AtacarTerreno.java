package usuario;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import db.SessionHibernate;
import db.User;
import tablaEnemigo.EnemigoBean;
import tablaEnemigo.EnemigoBeanLoader;
import nextapp.echo.app.Panel;
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

public class AtacarTerreno extends Panel {

		User user;
		EnemigoBean userEnemigo;
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

	    Column col = new Column();
	    add(col);

	    col.add(new Label("********************************"));
	    col.add(new Label("Atacando a "+userEnemigo.getNick()));
	    col.add(new Label("********************************"));
	    col.add(new Label("Estas atacando el terreno: "+userEnemigo.getTerreno()));
	    
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
		col.add(row);
			    add(col);

		session.getTransaction().commit();
		session.close();

	}
	
	protected void bntSalirClicked() {
		removeAll();
		Main main = new Main(user);
		add(main);
	}
	
}
