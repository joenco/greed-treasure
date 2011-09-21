package com.thinkingandlooking.tablas;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaEdicionArmaTerreno extends TablaBaseModeloArmaTerreno {
	
	private Usuario usuario;

	public TablaEdicionArmaTerreno(Usuario usuario) {
		super();
		this.usuario=usuario;
		
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

		TableDtaModel model = table.getTableDtaModel();
		ModeloArmaTerreno armaTerreno = (ModeloArmaTerreno) model.getElementAt(row);
		TablaVentaArmaTerreno tablaVenta=new TablaVentaArmaTerreno(usuario);
		tablaVenta.crearTabla(MetodosArmaTerreno.tablaPorArma(usuario,armaTerreno.getNombre()) );
//		WindowPane a=new WindowPane();
//		a.add(tablaVenta);
//		((MainApp)getApplicationInstance().getActive())a.getco
//	
	}

	// --------------------------------------------------------------------------------

}
