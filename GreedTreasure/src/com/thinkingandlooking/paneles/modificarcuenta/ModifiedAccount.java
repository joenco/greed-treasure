package com.thinkingandlooking.paneles.modificarcuenta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.utils.*;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;
import nextapp.echo.app.list.DefaultListModel;


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
	String txtPaisS;
	private TextField txtNombre;
	private TextField txtApellido;
	private PasswordField txtPass;
	private TextField txtEmail;
	private SelectField selectPais;
	
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
		
		
		
		DefaultListModel listModel = new DefaultListModel(new String[] {
				"Afganistan", "Africa del Sur", "Albania", "Alemania", "Andorra", "Angola", "Antillas Holandesas", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarusia", "Belgica", "Belice", "Benin", "Bermudas", "Bolivia", "Bosnia", "Brasil", "Bulgaria", "Burundi", "Butan", "Camboya", "Camerún", "Canada", "Chile", "China", "Chipre", "Colombia", "Congo", "Corea del Norte", "Corea del Sur", "Costa de Marfíl", "Costa Rica", "Croasia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Arabes Unidos", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Francia", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Groenlandia", "Guatemala", "Guinea", "Haití", "Holanda", "Honduras", "Hong Kong", "Hungría", "India", "Indonesia", "Irak", "Iran", "Irlanda", "Islandia", "Islas Virgenes (U.S.)", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kenia", "Kuwait", "Kyrgyzstan", "Libia", "Lituania", "Luxemburgo", "Macedonia", "Madagascar", "Malasia", "Mali", "Malta", "Marruecos", "Martinica", "Mexico", "Mónaco", "Mongolia", "Nicaragua", "Nigeria", "Noruega", "Pakistan", "Palestina", "Panamá", "Paraguay", "Perú", "Polonia", "Portugal", "Puerto Rico", "Qatar", "Reino Unido", "Republica Checa", "Republica Democratica del Congo", "Republica Dominicana", "Republica Eslovaca", "Ruanda", "Rumania", "Rusia", "Sahara", "San Marino", "Santa Lucía", "Santa Sede (Vaticano)", "Senegal", "Singapur", "Siría", "Somalia", "Suecia", "Suiza", "Sur Africa", "Surinam", "Tailandia", "Taiwan", "Tanzania", "Togo", "Trinidad & Tobago", "Turquía", "Ucrania", "Uganda", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yugoslavia", "Zambia", "Zimbabwe" } );
		
		selectPais = new SelectField(listModel);
		selectPais.setSelectedItem("Venezuela");
		Label lblCountry = new Label("País");
		grid.add(lblCountry);
		grid.add(selectPais);

		
		
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
		
		txtPaisS = new String();
		txtPaisS = (String) selectPais.getSelectedItem();
		
		
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
		/********************************************/
		
		
		
		Pattern pat = Pattern.compile("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,10})$");
        Matcher mat = pat.matcher(txtPass.getText());

        if (!mat.find()) {
       
        	windowPane.setTitle("Contraseña no segura!!!");

        	lbl.setText("La contraseña debe tener entre 6 y 10 caracteres, por lo menos un digito, un alfanumérico, y no puede contener caracteres especiales.");

        	col.add(lbl);
        	col.add(btnOK);
        	windowPane.add(col);
        	((MainApp)ApplicationInstance.getActive()).getDefaultWindow().getContent().add(windowPane);
        	return;
        }
        
		pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(txtEmail.getText());

        if (!mat.find()) {
        	windowPane.setTitle("Correo inválido!!");

        	lbl.setText("Por favor escriba un correo válido.");

        	col.add(lbl);
        	col.add(btnOK);
        	windowPane.add(col);
        	((MainApp)ApplicationInstance.getActive()).getDefaultWindow().getContent().add(windowPane);
        	return;
        }
		
		
		
		/********************************************/		
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
		usuario.setPais(txtPaisS);
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
