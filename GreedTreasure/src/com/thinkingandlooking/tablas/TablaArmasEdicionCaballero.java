package com.thinkingandlooking.tablas;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.AwtImageReference;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BufferImageCellRender;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaCaballero;
import com.thinkingandlooking.database.ModeloArmaCaballero;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaArmasEdicionCaballero extends Tabla {
	Usuario usuario;
	TextField Text3;
	ModeloArmaCaballero ac = new ModeloArmaCaballero();
	ModeloArmaCaballero modeloArmaCaballero = new ModeloArmaCaballero();
	SelectField cant;
	WindowPane windowPane;
	Column column;

	public TablaArmasEdicionCaballero(Usuario usuario,Column column) {
		super();
		this.usuario = usuario;
		this.column = column;
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

				return (new AwtImageReference((Image)BufferedImageCache.getInstance().getBufferedImage(modeloArmasCaballero.getNombre(), EnumConsultas.CONSULTA_MODELO_ARMA_CABALLERO)));

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

				Button button = new Button("Equipar");
				button.setStyle(GUIStyles.DEFAULT_STYLE);

				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnClicked(table, row);
					}

				});
				return button;
			}
		});

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				Button vender = new Button("Vender");
				vender.setStyle(GUIStyles.DEFAULT_STYLE);
				vender.setEnabled(editable);
				vender.setToolTipText("VENDER");

				vender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnVenderClicked(table, row);
					}
				});
				return vender;
			}
		});

		return nestedCellRenderer;
	}
	
	private void btnVenderClicked(ETable table, int row) {
		
	}
	
	private void btnClicked(ETable table, int row) {
		
		/*TableDtaModel model = table.getTableDtaModel();
		ModeloArmaCaballero mArmaCaballero= (ModeloArmaCaballero) model.getElementAt(row);
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String nombreModeloCaballero = new String();
		nombreModeloCaballero = modeloArmaCaballero.getNombre();
		
		String str = "FROM ArmaCaballero WHERE modelRef=:IdModelo";
		
		Query query = session.createQuery(str);
		query.setInteger("IdModelo", mArmaCaballero.getId());
		
		List<Object> list = new ArrayList<Object>();

		for (Object obj : query.list())
			list.add(obj);
		*/
		
		
		//String str2 = "FROM ArmaCaballero  WHERE modelRef=:modelo";
		//Query query2 = session.createQuery(str2);
		//query2.setInteger("modelo", modeloArmaCaballero.getId());//????????
		
		//List<Object> list = new ArrayList<Object>();

		//for (Object obj : query2.list())
		//	list.add(obj);
		
		//armasUsar(list);
		/*
		session.getTransaction().commit();
		session.close();
		*/
		
		
		
		/******************************************************************/
		

		
	}
	private TablaArmasUsarCabB armasUsar(List<Object> listaArmas){
		TablaArmasUsarCabB tabla = new TablaArmasUsarCabB(usuario);
		tabla.crearTabla(listaArmas);
		return tabla;
	}
	

}
