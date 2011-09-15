package com.thinkingandlooking.paneles.tablaenemigos;


import org.hibernate.Query;
import org.hibernate.Session;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableDtaModel;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.utils.GUIStyles;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.paneles.ataque.AtacarTerreno;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.database.*;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


public class TablaEnemigo extends Panel {

	private TestTableModel tableDtaModel;
	private Usuario usuario;
	HtmlLayout htmlLayout;
	Perfil perfil;
	

	// --------------------------------------------------------------------------------

	public TablaEnemigo(Usuario usuario, Perfil perfil) {
		this.usuario = usuario;
		this.perfil=perfil;
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		
		
		setInsets(new Insets(8, 8, 8, 8));
		
		try {
			htmlLayout = new HtmlLayout( 
					getClass().getResourceAsStream("atacarTerreno.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		HtmlLayoutData hld;
		
		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("LISTA DE ENEMIGOS PARA ATACAR");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);
	

		hld = new HtmlLayoutData("panel");
		Column col = new Column();
		

		// ----------------------------------------
		// Los modelos de la tabla
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		// ----------------------------------------
		// La Tabla
		// ----------------------------------------

		ETable table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);

		table.setEasyview(true);

		table.setBorder(new Border(1, Color.GREEN, Border.STYLE_NONE));
		table.setInsets(new Insets(30, 20, 50, 20));
		col.add(table);

		// ----------------------------------------
		// El control de la navegación
		// ----------------------------------------

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		col.add(tableNavigation);
		crearTabla();

		
		col.setLayoutData(hld);
		htmlLayout.add(col);
		add(htmlLayout);
	}
	
	
	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				return caballero.getUsuario().getLogin();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Enemigo");

		lcr = new LabelCellRenderer();
    	lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
			Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				return caballero.getNivel();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Nivel");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
    	lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				int victorias=0;
				Session session = SessionHibernate.getInstance().openSession();
				session.beginTransaction();
				String str = "FROM Ataque WHERE atacanteRef=:att_id OR atacadoRef=:att_id";
				Query query = session.createQuery(str);
				query.setInteger("att_id", caballero.getId());
				
				
				for (Object obj : query.list()) {
					Ataque ataque = (Ataque) obj;
					if((ataque.getAtacanteRef().getId()== caballero.getId()) && ataque.isGanador())
						victorias++;
					else if ((ataque.getAtacadoRef().getId()== caballero.getId()) && !ataque.isGanador())
						victorias++;
				}
				session.getTransaction().commit();
			    session.close();
				return victorias ;
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Victorias");

		lcr = new LabelCellRenderer();
	
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
			Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				int derrota=0;
				Session session = SessionHibernate.getInstance().openSession();
				session.beginTransaction();
				String str = "FROM Ataque WHERE atacanteRef=:att_id OR atacadoRef=:att_id";
				Query query = session.createQuery(str);
				query.setInteger("att_id", caballero.getId());
				
				
				for (Object obj : query.list()) {
					Ataque ataque = (Ataque) obj;
					if((ataque.getAtacanteRef().getId()== caballero.getId()) && !ataque.isGanador())
						derrota++;
					
					else if ((ataque.getAtacadoRef().getId()== caballero.getId()) && ataque.isGanador())
						derrota++;
				}
				session.getTransaction().commit();
			    session.close();
		
				return derrota;
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Derrotas");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Actions");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	// --------------------------------------------------------------------------------
	// Configuración de la barra de comandos de render
	// --------------------------------------------------------------------------------

	private NestedCellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.DEFAULT));

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				Button ret = new Button("ATACAR");
				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setToolTipText("Atacar jugador");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAtkClicked(table, row);
					}
				});
				return ret;
			}
		});
		// ---------------------------------------------comienza---------------------------------------------
		return nestedCellRenderer;
	}
	

	// --------------------------------------------------------------------------------

	private void btnAtkClicked(ETable table, int row) {
		TableDtaModel model = table.getTableDtaModel();
		Caballero usuarioContrincante = (Caballero) model.getElementAt(row);
		AtacarTerreno atacarEnemigo = new AtacarTerreno(usuario.getId(),usuarioContrincante.getId() );
		perfil.updatePanel(atacarEnemigo);
	
	}
	// --------------------------------------------------------------------------------
	public void crearTabla() {
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		Caballero caballero;
		String str = "FROM Caballero WHERE id<>:att_id";
		Query query = session.createQuery(str);
		query.setParameter("att_id", usuario.getCaballero().getId());
		
		
		 for (Object obj : query.list()) {
			 
			 caballero=(Caballero)obj;
			
			 if ((caballero.getNivel() >=usuario.getCaballero().getNivel()) ) {
			
				 tableDtaModel.add(caballero);
			 }
			 
			
	     }
		 System.out.println("bien");
		 System.out.println(tableDtaModel.getTotalRows());
		 if(tableDtaModel.getTotalRows()==0)
		 {	
			 final WindowPane windowPane=new WindowPane();
			 windowPane.setTitle("Sin Contrincantes!!");
			 windowPane.setClosable(false);
			 windowPane.setMovable(false);
			 windowPane.setModal(true);
			 Label lbl=new Label();
			 lbl.setText("Usted no tiene contricantes de su mismo nivel o superior");
			 
			 Column col=new Column();
			 col.add(lbl);

			 Button btnOK = new Button("Aceptar");
			 btnOK.setAlignment(new Alignment(Alignment.CENTER, Alignment.CENTER));
			 btnOK.addActionListener(new ActionListener() {
		     
				 public void actionPerformed(ActionEvent arg0) {
					windowPane.userClose();
					((MainApp)ApplicationInstance.getActive()).startPerfil(usuario);
							
					}
				});
			 col.add(btnOK);
			 windowPane.add(col);
			perfil.add(windowPane);
			 
		 }
	
	session.getTransaction().commit();
    session.close();
  }
}


