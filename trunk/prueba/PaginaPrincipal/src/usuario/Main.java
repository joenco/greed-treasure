package usuario;

import nextapp.echo.app.Border;
import tablaEnemigo.TablaEnemigo;
import nextapp.echo.app.TextField;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import db.User;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

/**
 * @author Anna Lezama
 *  @modificado por: Jorge Ortega
 */

public class Main extends ContentPane {

	User user;
	HtmlLayout htmlLayout;
	private TextField txtTerreno;

	public Main(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("main.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// setBackground(new Color(197, 217, 161));
		
				HtmlLayoutData hld;

		hld = new HtmlLayoutData("buttons_top");
		Row row = initButtons();
		row.setLayoutData(hld);
		htmlLayout.add(row);
		hld = new HtmlLayoutData("buttons_left");
		Grid grid = initButtons1();
		grid.setLayoutData(hld);
		htmlLayout.add(grid);

		hld = new HtmlLayoutData("panel");
		ShowRecord showrecord = new ShowRecord(user);
		showrecord.setId("panel");
		showrecord.setLayoutData(hld);
		htmlLayout.add(showrecord);
		Start start = new Start(user);
		start.setId("panel");
		start.setLayoutData(hld);
		htmlLayout.add(start);

		add(htmlLayout);
		
		txtTerreno = new TextField();
		txtTerreno.setText(user.getTerreno());
	}

	private Row initButtons() {
		Row row = new Row();
		row.setCellSpacing(new Extent(5));

		Button btnStart = new Button("Ïnicio");
		btnStart.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnStart.setBackground(new Color(117, 145, 118));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStartClicked();
			}
		});

		row.add(btnStart);

		Button btnShowAccount = new Button("Ver Perfil");
		btnShowAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnShowAccount.setBackground(new Color(117, 145, 118));
		btnShowAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnShowAccountClicked();
			}
		});

		row.add(btnShowAccount);

		Button btnModifiedAccount = new Button("Modificar Perfil");
		btnModifiedAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnModifiedAccount.setBackground(new Color(117, 145, 118));
		btnModifiedAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnModifiedAccountClicked();
			}
		});

		row.add(btnModifiedAccount);

		Button btnHistorialDiario = new Button("Ataques de hoy");
		btnHistorialDiario.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnHistorialDiario.setBackground(new Color(117, 145, 118));
		btnHistorialDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHistorialDiarioClicked();
			}
		});

		row.add(btnHistorialDiario);

		Button btnHistorialGlobal = new Button("Historial de ataques");
		btnHistorialGlobal.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnHistorialGlobal.setBackground(new Color(117, 145, 118));
		btnHistorialGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHistorialGlobalClicked();
			}
		});

		row.add(btnHistorialGlobal);

		Button btnLogOut = new Button("Salir");
		btnLogOut.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnLogOut.setBackground(new Color(117, 145, 118));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLogOutClicked();
			}
		});

		row.add(btnLogOut);

		return row;
	}
	


	private Grid initButtons1() {
		Grid grid = new Grid(1);

		Button btnAtacarCastillo = new Button("Atacar Castillo");
		btnAtacarCastillo.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnAtacarCastillo.setBackground(new Color(117, 145, 118));
		btnAtacarCastillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtacarCastilloClicked();
			}
		});

		grid.add(btnAtacarCastillo);
		
		Button btnEditionCastillo = new Button("Editar Castillo");
		btnEditionCastillo.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnEditionCastillo.setBackground(new Color(117, 145, 118));
		btnEditionCastillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditionCastilloClicked();
			}
		});

		grid.add(btnEditionCastillo);

		Button btnEditionCaballero = new Button("Editar Caballero");
		btnEditionCaballero.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnEditionCaballero.setBackground(new Color(117, 145, 118));
		btnEditionCaballero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditionCaballeroClicked();
			}
		});

		grid.add(btnEditionCaballero);

		Button btnComprarArmas = new Button("Comprar armas");
		btnComprarArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnComprarArmas.setBackground(new Color(117, 145, 118));
		btnComprarArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnComprarArmasClicked();
			}
		});

		grid.add(btnComprarArmas);

		Button btnVenderArmas = new Button("Vender armas");
		btnVenderArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnVenderArmas.setBackground(new Color(117, 145, 118));
		btnVenderArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVenderArmasClicked();
			}
		});

		grid.add(btnVenderArmas);
		
		Button btnInventarioArmas = new Button("Inventario de armas");
		btnInventarioArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnInventarioArmas.setBackground(new Color(117, 145, 118));
		btnInventarioArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInventarioArmasClicked();
			}
		});

		grid.add(btnInventarioArmas);

		return grid;
	}

	private void btnHistorialDiarioClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Aquí debe ir el historial de ataques del día del jugador");
		updateLabel(label);
	}

	private void btnHistorialGlobalClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Aquí debe ir el historial completo de ataques del jugador");
		updateLabel(label);
	}

	private void btnAtacarCastilloClicked() {
		if (txtTerreno.getText().equals("sin terreno")) {
			removeAll();
			Terrenos terrenos = new Terrenos(user);
			add(terrenos);
		} else {
			ShowRecord showrecord = new ShowRecord(user);
			updatePanel(showrecord);
			TablaEnemigo tablaEnemigo = new TablaEnemigo(user);
			updatePanel(tablaEnemigo);
		}
	}

	private void btnEditionCastilloClicked() {
		if (txtTerreno.getText().equals("sin terreno")) {
			removeAll();
			Terrenos terrenos = new Terrenos(user);
			add(terrenos);
		} else {
			ShowRecord showrecord = new ShowRecord(user);
			updatePanel(showrecord);
			Label label = new Label("Aquí se mostrara el terreno y las armas que se colocaran en el mismo para la defensa del castillo, tu terreno es "+user.getTerreno());
			updateLabel(label);
		}
	}

	private void btnEditionCaballeroClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Aquí se mostrara al caballero y las armas que puede utilizar para su ataque y defensa");
		updateLabel(label);
	}

	private void btnComprarArmasClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Se mostrara una tabla con las armas que el jugador puede comprar");
		updateLabel(label);
	}
	
	private void btnVenderArmasClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Se mostrara una tabla con las armas que el jugador puede vender");
		updateLabel(label);
	}

	private void btnInventarioArmasClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		Label label = new Label("Aquí se mostrara una tabla con todas las armas que el jugador posee y que ha comprado");
		updateLabel(label);
	}

	private void btnStartClicked() {
		Start star = new Start(user);
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		updatePanel(star);
	}

	private void btnLogOutClicked() {
		removeAll();
		add(new Welcome());
	}

	private void btnModifiedAccountClicked() {
		ModifiedAccount modifiedAccount = new ModifiedAccount(user);
		ShowRecord showrecord = new ShowRecord(user);
		modifiedAccount.getActionListenerProxyError().addActionListener(listenerError);
		modifiedAccount.getActionListenerProxyOk().addActionListener(listenerOk);
		updatePanel(showrecord);
		updatePanel(modifiedAccount);
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
		ShowAccount showAccount = new ShowAccount(user);
		updatePanel(showAccount);
		WindowPane win = (WindowPane) evt.getSource();
		add(win);
	}
	
	private void btnShowAccountClicked() {
		ShowRecord showrecord = new ShowRecord(user);
		updatePanel(showrecord);
		ShowAccount showAccount = new ShowAccount(user);
		updatePanel(showAccount);
	}

	private void updateLabel(Label label) {
		HtmlLayoutData hld;
		hld = new HtmlLayoutData("panel");

		label.setId("panel");
		label.setLayoutData(hld);
		htmlLayout.remove(htmlLayout.getComponent("panel"));
		htmlLayout.add(label);
	}

	private void updatePanel(Panel panel) {
		panel.setId("panel");

		HtmlLayoutData hld = new HtmlLayoutData("panel");
		panel.setLayoutData(hld);

		htmlLayout.remove(htmlLayout.getComponent("panel"));
		htmlLayout.add(panel);

	}

}
