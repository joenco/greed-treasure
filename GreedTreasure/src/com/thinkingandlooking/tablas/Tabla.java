package com.thinkingandlooking.tablas;

import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import java.util.List;
import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableSelModel;
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;

public abstract class Tabla  extends ETable{

	protected TestTableModel tableDtaModel;
	

	public Tabla() {
		
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		setInsets(new Insets(8, 8,8, 8));
		
		// ----------------------------------------
		// Los modelos de la tabla
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(4);

		// ----------------------------------------
		// La Tabla
		// ----------------------------------------

		
		setTableDtaModel(tableDtaModel);
		setTableColModel(tableColModel);
		setTableSelModel(tableSelModel);

		setEasyview(true);

		setBorder(new Border(5, Color.BLACK, Border.STYLE_GROOVE	));
		setCellSpacing(new Extent(10));
		
}

	public abstract void crearTabla (List<Object> a);

	public abstract TableColModel initTableColModel() ;
	
	
}
