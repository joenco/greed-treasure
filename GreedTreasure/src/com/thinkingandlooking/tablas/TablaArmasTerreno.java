package com.thinkingandlooking.tablas;


import org.hibernate.Query;
import org.hibernate.Session;
import nextapp.echo.app.Column;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.list.DefaultListModel;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableDtaModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaTerreno;
import com.thinkingandlooking.database.Caballero;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.utils.GUIStyles;


public class TablaArmasTerreno extends TablaBaseModeloArmaTerreno {
	String nombreBoton;
	Usuario usuario;
	ArmaTerreno am = new ArmaTerreno();
	ModeloArmaTerreno modeloArmaTerreno = new ModeloArmaTerreno();
	TextField Text3 ;

	public TablaArmasTerreno(String nombreBoton, Usuario usuario) {
		super();
		this.nombreBoton = nombreBoton;
		this.usuario = usuario;
	}

	public TableColModel initTableColModel() {

		TableColModel tableColModel = super.initTableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ACCION");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		lcr.setBackground(Color.ORANGE);
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

				Button button = new Button(nombreBoton);
				button.setStyle(GUIStyles.DEFAULT_STYLE);
				button.setToolTipText(nombreBoton);

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnClicked(table, row);
					}
				});
				return button;
			}
		});
		System.err.println("ALGOOOOOOOOOOOOO");
		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnClicked(ETable table, int row) {

		TableDtaModel model = table.getTableDtaModel();
		modeloArmaTerreno = (ModeloArmaTerreno) model.getElementAt(row);

		if (usuario.getCaballero().getOro() >= modeloArmaTerreno.getOro()
				&& usuario.getCaballero().getNivel() >= modeloArmaTerreno
						.getNivel()) {

			final WindowPane windowPane = new WindowPane();
			windowPane.setModal(true);
			windowPane.setTitleBackground(new Color(11, 46, 5));
			windowPane.setTitleForeground(Color.WHITE);
			windowPane.setBackground(new Color(50, 217, 11));
			windowPane.setTitle("Compra Maldito");

			DefaultListModel listModel = new DefaultListModel(new String[] {
					"1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
			final SelectField cant = new SelectField(listModel);
			cant.setSelectedItem("1");
			//
			
			cant.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					
					Text3.setText("  " + Integer.toString(Integer.parseInt((String) cant.getSelectedItem())
									* modeloArmaTerreno.getOro()) + "   ");
				}
			});
			 		
			 //

			Row row2 = new Row();
			Label paneText = new Label("Desea comprar  ");
			Label paneText2 = new Label("  " + modeloArmaTerreno.getNombre()
					+ " por ");

			//aux = Integer.parseInt((String) cant.getSelectedItem())
			//		* modeloArmaTerreno.getOro();


			Text3 = new TextField();
			
			Text3.setText("  " + Integer.toString(Integer.parseInt((String) cant.getSelectedItem())
							* modeloArmaTerreno.getOro()) + "   ");
			Text3.setEditable(false);
			Label paneText4 = new Label(" monedas de oro");
			Text3.setBackground(Color.YELLOW);
			Text3.setForeground(Color.BLACK);

			row2.add(paneText);
			row2.add(cant);
			row2.add(paneText2);
			row2.add(Text3);
			row2.add(paneText4);

			Button acceptbtn = new Button("OK");
			acceptbtn.setStyle(GUIStyles.DEFAULT_STYLE);
			acceptbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Session session = SessionHibernate.getInstance()
							.openSession();
					session.beginTransaction();

					String nombreModeloTerreno = new String();
					nombreModeloTerreno = modeloArmaTerreno.getNombre();
					String str = "FROM ModeloArmaTerreno WHERE nombre=:nombreModelo";

					Query query = session.createQuery(str);
					query.setString("nombreModelo", nombreModeloTerreno);
					ModeloArmaTerreno modeloArmaTerreno = (ModeloArmaTerreno) query
							.uniqueResult();

					am.setMuniciones_actuales(modeloArmaTerreno
							.getMuniciones_base());

					String str2 = "FROM Caballero WHERE id=:idRef";
					Query query2 = session.createQuery(str2);
					query2.setInteger("idRef", usuario.getId());
					Caballero caballero = (Caballero) query2.uniqueResult();

					am.setCaballeroRef(usuario.getCaballero());
					caballero.getArmaTerrenoList().add(am);
					// usuario.getCaballero().getArmaTerrenoList().add(am);//EXPLOTA

					modeloArmaTerreno.getArmaTerrenoList().add(am);
					am.setModelRef(modeloArmaTerreno);

					caballero.setOro(caballero.getOro()
							- modeloArmaTerreno.getOro()
							* Integer.parseInt((String) cant.getSelectedItem()));

					// session.update(usuario);
					session.update(caballero);
					session.update(modeloArmaTerreno);
					session.save(am);

					session.getTransaction().commit();
					session.close();

					windowPane.userClose();
				}

			});
			Column COL = new Column();
			COL.add(row2);
			COL.add(acceptbtn);
			windowPane.add(COL);

			((MainApp) ApplicationInstance.getActive()).getDefaultWindow()
					.getContent().add(windowPane);

		}

	}

	/*
	 * protected void acceptbtnClicked(Usuario usuario2, ArmaTerreno am,
	 * ModeloArmaTerreno modeloArmaTerreno) {
	 * 
	 * Session session = SessionHibernate.getInstance().openSession();
	 * session.beginTransaction();
	 * usuario2.getCaballero().getArmaTerrenoList().add(am);
	 * usuario2.getCaballero() .setOro(usuario2.getCaballero().getOro() -
	 * am.getModelRef().getOro());
	 * modeloArmaTerreno.getArmaTerrenoList().add(am); session.update(usuario2);
	 * session.update(modeloArmaTerreno);
	 * 
	 * }
	 */
}
