package com.thinkingandlooking.tablas;

import java.util.List;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.database.ArmaTerreno;
import com.thinkingandlooking.database.Usuario;

public class TablaVentaArmaTerreno extends Tabla{

	public TablaVentaArmaTerreno(Usuario usuario) {
		super();
	}
	
	
	public void crearTabla(List<Object> a) {
		
		for (Object obj : a) {
			ArmaTerreno	armaTerreno = (ArmaTerreno) obj;
			tableDtaModel.add(armaTerreno);
		}
		
	}

	
	public TableColModel initTableColModel() {


		TableColModel tableColModel = new TableColModel();
		   
		TableColumn tableColumn;
		LabelCellRenderer lcr;
		
		// *******************************************************************
		
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ArmaTerreno ArmasTerreno = (ArmaTerreno) element;
				return ArmasTerreno.getMuniciones_actuales();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("MUNICIONES");

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
	
	

}
