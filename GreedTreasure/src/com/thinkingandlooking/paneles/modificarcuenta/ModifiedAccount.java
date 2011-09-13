package com.thinkingandlooking.paneles.modificarcuenta;

import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.utils.*;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;


public class ModifiedAccount extends Panel {

	private EventListenerList eventListenerListError = //
	new EventListenerList();

	private ActionListenerProxy actionListenerProxyError = //
	new ActionListenerProxy(eventListenerListError);

	private EventListenerList eventListenerListOk = //
	new EventListenerList();

	private ActionListenerProxy actionListenerProxyOk = //
	new ActionListenerProxy(eventListenerListOk);

	private Usuario usuario;

	private TextField txtNombre;
	private TextField txtApellido;
	private TextField txtPais;
	private PasswordField txtPass;
	private TextField txtEmail;

	public ModifiedAccount(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {

		Grid grid = new Grid(2);

		txtNombre = new TextField();
		txtNombre.setText(usuario.getNombre());
		Label lblName = new Label("Nombre");
		grid.add(lblName);
		grid.add(txtNombre);
		
		txtApellido = new TextField();
		txtApellido.setText(usuario.getApellido());
		Label lblLastName = new Label("Apellido");
		grid.add(lblLastName);
		grid.add(txtApellido);
		
		txtPais = new TextField();
		txtPais.setText(usuario.getPais());
		Label lblCountry = new Label("País");
		grid.add(lblCountry);
		grid.add(txtPais);

		txtPass = new PasswordField();
		txtPass.setText(usuario.getPassword());
		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		grid.add(txtPass);

		txtEmail = new TextField();
		txtEmail.setText(usuario.getEmail());
		Label lblEmail = new Label("Email");
		grid.add(lblEmail);
		grid.add(txtEmail);

		Button btnModifiedAccount = new Button("Modificar Cuenta");
		btnModifiedAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnModifiedAccount.setBackground(new Color(117, 145, 118));
		btnModifiedAccount.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.CENTER));
		btnModifiedAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bntModifiedAccountClicked();
			}
		});
		grid.add(btnModifiedAccount);

		add(grid);
	}

	protected void bntModifiedAccountClicked() {
		final WindowPane windowPane = new WindowPane();
		windowPane.setModal(true);
		windowPane.setTitleBackground(new Color(11, 46, 5));
		windowPane.setTitleForeground(Color.WHITE);
		windowPane.setBackground(new Color(197, 217, 161));

		Column col = new Column();
		col.setCellSpacing(new Extent(8));

		Button btnOK = new Button("Aceptar");
		btnOK.setAlignment(new Alignment(Alignment.CENTER, Alignment.CENTER));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				windowPane.userClose();
			}
		});

		Label lbl = new Label();

		if (!validateFields()) {

			windowPane.setTitle("Campos Obligatorios");

			lbl.setText("Faltan algunos campos por rellenar. Por favor ingrese todos sus datos");

			col.add(lbl);
			col.add(btnOK);
			windowPane.add(col);
			actionListenerProxyError.fireActionEvent(new ActionEvent(windowPane, null));
			return;
		}
		
		modified();
		
		windowPane.setTitle("Cuenta Modificada");

		lbl.setText("Su cuenta fue modificada con éxito!");

		col.add(lbl);
		col.add(btnOK);
		windowPane.add(col);
		
		actionListenerProxyOk.fireActionEvent(new ActionEvent(windowPane, null));

	}
	
	private void modified() {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		usuario.setPassword(txtPass.getText());
		usuario.setNombre(txtNombre.getText());
		usuario.setApellido(txtApellido.getText());
		usuario.setPais(txtPais.getText());
		usuario.setEmail(txtEmail.getText());
		session.update(usuario);
		
		session.getTransaction().commit();
		session.close();
	}

	private boolean validateFields() {
		if (txtNombre.getText().equals("")) {
			return false;
		}
		if (txtApellido.getText().equals("")) {
			return false;
		}
		if (txtPais.getText().equals("")) {
			return false;
		}
		if (txtPass.getText().equals("")) {
			return false;
		}
		if (txtEmail.getText().equals("")) {
			return false;
		}
		return true;
	}
	
	public ActionListenerProxy getActionListenerProxyError() {
		return actionListenerProxyError;
	}
	
	public ActionListenerProxy getActionListenerProxyOk() {
		return actionListenerProxyOk;
	}

}
