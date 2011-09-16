package com.thinkingandlooking.tablas;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaArmasTerreno  extends TablaBaseModeloArmaTerreno{
	
			String nombreBoton;
			
	public TablaArmasTerreno(String nombreBoton) {
			super();
			this.nombreBoton=nombreBoton;
		}

	public TableColModel initTableColModel() {
		
			TableColModel tableColModel =super.initTableColModel();
			   
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


			return nestedCellRenderer;
		}
		// --------------------------------------------------------------------------------
		
	private void btnClicked(ETable table, int row) {
			
	/*		TableDtaModel model = table.getTableDtaModel();

			ModeloArmaTerreno ModeloArmaTerreno = (ModeloArmaTerreno) model.getElementAt(row);

			ModeloArmaTerreno.setnumeroArmas(ModeloArmaTerreno.getArmaTerrenoList().size() - 1);
			model.getTableDtaModelEvtProxy().fireActionEvent(
					new TableDtaModelEvent(model));
			label.setText("selecciono: "+ModeloArmaTerreno.getNombreArma());

			if (ModeloArmaTerreno.getnumeroArmas() == 0)
				tableDtaModel.del(tableDtaModel.getElementAt(row));
		*/}

	

}
