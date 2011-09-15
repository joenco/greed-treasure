package com.thinkingandlooking.tablas;

import java.util.List;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableDtaModel;
import com.minotauro.echo.table.event.TableDtaModelEvent;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.ImageCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;
import com.thinkingandlooking.utils.GUIStyles;


public class tablaModeloArmaTerreno extends tabla {

	public tablaModeloArmaTerreno() {
		super();
	}

	@Override
	public void crearTabla(List<Object> a) {
		for (Object obj : a) {
			ModeloArmaTerreno ma = (ModeloArmaTerreno) obj;
			tableDtaModel.add(ma);
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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;

			return new HttpImageReference("imagenes_tabla?nombreArma="+modeloArmasTerreno.getNombre());
				 
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

		ImageCellRenderer icr = new ImageCellRenderer();
		icr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		
		tableColumn.setDataCellRenderer(icr);
		tableColModel.getTableColumnList().add(tableColumn);
		
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getNombre();
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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getAtaque();
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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getDefensa();
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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getAlcance();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ALCANCE");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				
				return modeloArmasTerreno.getArmaTerrenoList().size();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("NUM ARMAS");

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
	
		// *******************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getOro();
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
		
		// *******************************************************************
        
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ACCIONES");

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

				

				Button usar = new Button("Usar");
				usar.setStyle(GUIStyles.DEFAULT_STYLE);
				usar.setToolTipText("USAR");

				usar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnUsarClicked(table, row);
					}
				});
				return usar;
			}
		});

		// ---------------------------------------------comienza---------------------------------------------

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
	// --------------------------------------------------------------------------------
	
private void btnUsarClicked(ETable table, int row) {
		
/*		TableDtaModel model = table.getTableDtaModel();

		ModeloArmaTerreno ModeloArmaTerreno = (ModeloArmaTerreno) model.getElementAt(row);

		ModeloArmaTerreno.setnumeroArmas(ModeloArmaTerreno.getArmaTerrenoList().size() - 1);
		model.getTableDtaModelEvtProxy().fireActionEvent(
				new TableDtaModelEvent(model));
		label.setText("selecciono: "+ModeloArmaTerreno.getNombreArma());

		if (ModeloArmaTerreno.getnumeroArmas() == 0)
			tableDtaModel.del(tableDtaModel.getElementAt(row));
	*/}

// --------------------------------------------------------------------------------

private void btnVenderClicked(ETable table, int row) {

/*	TableDtaModel model = table.getTableDtaModel();
	ModeloArmaTerreno armaBean = (ModeloArmaTerreno) model.getElementAt(row);
	inputWindow inputWindow = new inputWindow(armaBean);
	add(inputWindow);
*/
}

// --------------------------------------------------------------------------------


}
