package com.thinkingandlooking.registrousuario;

import org.hibernate.Criteria;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.list.DefaultListModel;
import java.util.regex.*;

import javax.activation.MailcapCommandMap;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
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


public class CreateAccount extends ContentPane {

	private HtmlLayout htmlLayout;
	private TextField txtLogin;
	private TextField txtNombre;
	private TextField txtApellido;
	private String txtPais;
	private SelectField selectPais;
	private PasswordField txtPass;
	private TextField txtEmail;
	private boolean registroExitoso;
	private Usuario usuario;

	public CreateAccount() {
		initGUI();
	}

	private void initGUI() {
		try {
			htmlLayout = new HtmlLayout(
					//
					getClass().getResourceAsStream("createAccount.html"),
					"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	//	setBackground(new Color(197, 217, 161));

		HtmlLayoutData hld;
		registroExitoso=false;
		
		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("Ingrese los datos para crear una cuenta en Greed Treasure");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);

		hld = new HtmlLayoutData("form");
		Grid grid = new Grid(2);

		txtLogin = new TextField();
		Label lblNick = new Label("Nick/Apodo");
		grid.add(lblNick);
		grid.add(txtLogin);

		txtNombre = new TextField();
		Label lblName = new Label("Nombre");
		grid.add(lblName);
		grid.add(txtNombre);

		txtApellido = new TextField();
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
		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		grid.add(txtPass);

		txtEmail = new TextField();
		Label lblEmail = new Label("Email");
		grid.add(lblEmail);
		grid.add(txtEmail);
		
		txtPais = new String();
		txtPais = (String) selectPais.getSelectedItem();

		grid.setLayoutData(hld);
		htmlLayout.add(grid);

		hld = new HtmlLayoutData("buttons");
		Row row = new Row();
		row.setCellSpacing(new Extent(5));

		Button btnCreateAccount = new Button("Crear Cuenta");
		btnCreateAccount.setBorder(new Border(new Extent(2), Color.GREEN, 1));
		btnCreateAccount.setBackground(Color.BLACK);
		btnCreateAccount.setForeground(Color.WHITE);
		btnCreateAccount.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.CENTER));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bntCreateAccountClicked();
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

		row.add(btnCreateAccount);
		row.add(btnCancel);
		row.setLayoutData(hld);
		htmlLayout.add(row);

		add(htmlLayout);

	}

	protected void bntCreateAccountClicked() {
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
				if(registroExitoso)
					((MainApp)ApplicationInstance.getActive()).startElegirCaballero(usuario);
					
			}
		});

		Label lbl = new Label();

		if (!validateFields()) {

			windowPane.setTitle("Campos Obligatorios");

			lbl.setText("Faltan algunos campos por rellenar. Por favor ingrese todos sus datos");

			col.add(lbl);
			col.add(btnOK);
			windowPane.add(col);
			add(windowPane);

			return;
		}

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		if (checkUsuario(session)) {

			session.getTransaction().commit();
			session.close();

			windowPane.setTitle("Nick existente");

			lbl.setText("Este nick ya existe. Intente con otro diferente");

			col.add(lbl);
			col.add(btnOK);
			windowPane.add(col);

			add(windowPane);
			return;
		}
		
		if (checkEmail(session)) {

			session.getTransaction().commit();
			session.close();

			windowPane.setTitle("Correo ya registrado!!");

			lbl.setText("Este correo ya esta asociado a una cuenta, por favor coloque otro.");

			col.add(lbl);
			col.add(btnOK);
			windowPane.add(col);

			add(windowPane);
			return;
		}
		
		Pattern pat = Pattern.compile("(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,10})$");
        Matcher mat = pat.matcher(txtPass.getText());

        if (!mat.find()) {
       
        	windowPane.setTitle("Contraseña no segura!!!");

        	lbl.setText("La contraseña debe tener entre 6 y 10 caracteres, por lo menos un digito, un alfanumérico, y no puede contener caracteres especiales.");

        	col.add(lbl);
        	col.add(btnOK);
        	windowPane.add(col);

        	add(windowPane);
        	return;
        }

        pat = Pattern.compile("^[a-z0-9A-Z][a-zA-Z0-9_]{3,15}$");
        mat = pat.matcher(txtLogin.getText());

        if (!mat.find()) {
        
        	windowPane.setTitle("Nick/Apodo incorrecto!!!");

        	lbl.setText("El Nick debe tener entre 4 y 15 caracteres y ningun caracter especial.");

        	col.add(lbl);
        	col.add(btnOK);
        	windowPane.add(col);

        	add(windowPane);
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

        	add(windowPane);
        	return;
        }

        txtPais = new String();
        txtPais = (String) selectPais.getSelectedItem();

		register(session);

		session.getTransaction().commit();
		session.close();
		registroExitoso=true;
		windowPane.setTitle("Usuario registrado");
		windowPane.setClosable(false);
		windowPane.setMovable(false);
		lbl.setText("Usteda ha sido registrado satisfactoriamente");

		col.add(lbl);
		col.add(btnOK);
		windowPane.add(col);

		add(windowPane);
			
		
	}

	private boolean checkUsuario(Session session) {
		Criteria criteria = session.createCriteria(Usuario.class).add(
				Restrictions.eq("login", txtLogin.getText()));
		if (criteria.list().size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	
	private boolean checkEmail(Session session) {
		Criteria criteria = session.createCriteria(Usuario.class).add(
				Restrictions.eq("email", txtEmail.getText()));
		if (criteria.list().size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	

	private void register(Session session) {
		usuario = new Usuario();
		
		usuario.setLogin(txtLogin.getText());
		usuario.setPassword(txtPass.getText());
		usuario.setPais(txtPais);
		usuario.setEmail(txtEmail.getText());
		usuario.setCaballero(null);
		usuario.setNombre(txtNombre.getText());
		usuario.setApellido(txtApellido.getText());

		
		
		session.save(usuario);
	}

	protected void btnCancelClicked() {
		
		((MainApp)ApplicationInstance.getActive()).startWelcome();
	}

	private boolean validateFields() {
		if (txtLogin.getText().equals("")) {
			return false;
		}
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

}
