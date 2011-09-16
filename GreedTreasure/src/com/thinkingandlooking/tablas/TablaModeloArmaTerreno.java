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
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaModeloArmaTerreno extends TablaBaseModeloArmaTerreno {

	public TablaModeloArmaTerreno() {
		super();
		}

	public TableColModel initTableColModel() {
		
			TableColModel tableColModel =super.initTableColModel();
			   
			TableColumn tableColumn;
			LabelCellRenderer lcr;
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
