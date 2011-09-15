package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.Panel;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.CellRenderer;
import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.Caballero;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaExtremidades extends Panel {
	
	private Usuario usuario;
	private TestTableModel tableDtaModel;
	String extremidad;

	public TablaExtremidades(Usuario usuario) {

		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		
		Column col = new Column();
		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		ETable table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);

		table.setEasyview(true);

		table.setBorder(new Border(1, Color.GREEN, Border.STYLE_NONE));
		table.setInsets(new Insets(30, 20, 50, 20));
		Label label = new Label("ARMAS");
		
		col.add(label);
		col.add(table);
	}

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(1));
		tableColumn.setHeadValue("Extremidad");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);
		return tableColModel;
	}

	private CellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.DEFAULT));

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();
				Label ret = new Label();
				//ret.setText(extremidad);
				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);

			return ret;
			}
		});
		return nestedCellRenderer;
	}
	
}
	
	

