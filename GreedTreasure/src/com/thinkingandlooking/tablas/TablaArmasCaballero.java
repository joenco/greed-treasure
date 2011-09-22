package com.thinkingandlooking.tablas;

import java.awt.Image;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.AwtImageReference;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
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

import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BufferImageCellRender;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaCaballero;
import com.thinkingandlooking.database.Caballero;
import com.thinkingandlooking.database.ModeloArmaCaballero;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaArmasCaballero extends Tabla {
	Usuario usuario;
	TextField Text3;
	ArmaCaballero ac = new ArmaCaballero();
	ModeloArmaCaballero modeloArmaCaballero = new ModeloArmaCaballero();
	SelectField cant;
	WindowPane windowPane;

	public TablaArmasCaballero(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public void crearTabla(List<Object> a) {
		for (Object obj : a) {
			ModeloArmaCaballero mac = (ModeloArmaCaballero) obj;
			tableDtaModel.add(mac);
		}
	}

	@Override
	public TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaCaballero modeloArmasCaballero = (ModeloArmaCaballero) element;

				return (new AwtImageReference((Image) BufferedImageCache
						.getInstance().getBufferedImage(
								modeloArmasCaballero.getNombre(),
								EnumConsultas.CONSULTA_MODELO_ARMA_CABALLERO)));

			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("IMAGEN");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		BufferImageCellRender icr = new BufferImageCellRender();
		icr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		tableColumn.setDataCellRenderer(icr);
		tableColModel.getTableColumnList().add(tableColumn);

		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaCaballero modeloArmascaballero = (ModeloArmaCaballero) element;
				return modeloArmascaballero.getNombre();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("NOMBRE");

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
				ModeloArmaCaballero modeloArmascaballero = (ModeloArmaCaballero) element;
				return modeloArmascaballero.getAtaque();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ATAQUE");

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
				ModeloArmaCaballero modeloArmascaballero = (ModeloArmaCaballero) element;
				return modeloArmascaballero.getDefensa();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("DEFENSA");

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
				ModeloArmaCaballero modeloArmascaballero = (ModeloArmaCaballero) element;
				return modeloArmascaballero.getOro();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ORO");

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

		tableColumn = new TableColumn();
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

	private NestedCellRenderer initNestedCellRenderer() {

		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.DEFAULT));

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				Button button = new Button("Comprar");
				button.setStyle(GUIStyles.DEFAULT_STYLE);

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnClicked(table, row);
					}

				});
				return button;
			}
		});
		return nestedCellRenderer;
	}

	private void btnClicked(ETable table, int row) {

		TableDtaModel model = table.getTableDtaModel();
		modeloArmaCaballero = (ModeloArmaCaballero) model.getElementAt(row);

		windowPane = new WindowPane();
		windowPane.setModal(true);
		windowPane.setTitleBackground(new Color(11, 46, 5));
		windowPane.setTitleForeground(Color.WHITE);
		windowPane.setBackground(new Color(50, 217, 11));
		windowPane.setTitle("Compra Maldito");

		DefaultListModel listModel = new DefaultListModel(new String[] { "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10" });
		cant = new SelectField(listModel);
		cant.setSelectedItem("1");
		//

		cant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Text3.setText("  "
						+ Integer.toString(Integer.parseInt((String) cant
								.getSelectedItem())
								* modeloArmaCaballero.getOro()) + "   ");
			}
		});

		//

		Row row2 = new Row();
		Label paneText = new Label("Desea comprar  ");
		Label paneText2 = new Label("  " + modeloArmaCaballero.getNombre()
				+ " por ");

		// aux = Integer.parseInt((String)
		// cant.getSelectedItem())
		// * modeloArmaTerreno.getOro();

		Text3 = new TextField();

		Text3.setText("  "
				+ Integer.toString(Integer.parseInt((String) cant
						.getSelectedItem()) * modeloArmaCaballero.getOro())
				+ "   ");
		Text3.setEditable(false);
		Label paneText4 = new Label(" monedas de oro");
		Text3.setBackground(Color.YELLOW);
		Text3.setForeground(Color.BLACK);

		row2.add(paneText);
		row2.add(cant);
		row2.add(paneText2);
		row2.add(Text3);
		row2.add(paneText4);
		/*************************************************************************/
		Button acceptbtn = new Button("OK");
		acceptbtn.setStyle(GUIStyles.DEFAULT_STYLE);
		acceptbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accptBtnClicked();
			}

		});

		/*************************************************************************/
		Column COL = new Column();
		COL.add(row2);
		COL.add(acceptbtn);

		windowPane.add(COL);

		((MainApp) ApplicationInstance.getActive()).getDefaultWindow()
				.getContent().add(windowPane);

	}

	protected void accptBtnClicked() {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String nombreModeloCaballero = new String();
		nombreModeloCaballero = modeloArmaCaballero.getNombre();
		String str = "FROM ModeloArmaCaballero WHERE nombre=:nombreModelo";

		Query query = session.createQuery(str);
		query.setString("nombreModelo", nombreModeloCaballero);
		ModeloArmaCaballero modeloArmaCaballero = (ModeloArmaCaballero) query
				.uniqueResult();

		String str2 = "FROM Caballero WHERE id=:idRef";
		Query query2 = session.createQuery(str2);
		query2.setInteger("idRef", usuario.getId());
		Caballero caballero = (Caballero) query2.uniqueResult();

		if (caballero.getOro() - modeloArmaCaballero.getOro()
				* Integer.parseInt((String) cant.getSelectedItem()) < 0) {

			final WindowPane windowPaneFallo = new WindowPane();
			windowPaneFallo.setModal(true);
			windowPaneFallo.setTitleBackground(new Color(11, 46, 5));
			windowPaneFallo.setTitleForeground(Color.WHITE);
			windowPaneFallo.setBackground(new Color(50, 217, 11));
			windowPaneFallo.setTitle("Eres muy pobre");
			windowPaneFallo.setClosable(false);
			Label textFallo = new Label(
					"No tienes oro suficiente para la compra");
			windowPaneFallo.add(textFallo);
			Button fallobtn = new Button();
			fallobtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					windowPaneFallo.userClose();
					windowPane.userClose();
				}
			});
		}

		caballero.setOro(caballero.getOro() - modeloArmaCaballero.getOro()
				* Integer.parseInt((String) cant.getSelectedItem()));

		ac.setArmaCaballeroRef(usuario.getCaballero());
		caballero.getArmaCaballeroList().add(ac);

		modeloArmaCaballero.getArmaCaballero().add(ac);
		ac.setModelRef(modeloArmaCaballero);

		session.update(caballero);
		session.update(modeloArmaCaballero);
		session.save(ac);

		session.getTransaction().commit();
		session.close();

		windowPane.userClose();

	}

}
