package com.thinkingandlooking.tablas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.TransitionPane;

import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaTerreno;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaArmaTerrenoUsar extends Tabla{

	 private ArmaTerreno armaActual;

	
	 public TablaArmaTerrenoUsar() {
		super();
		armaActual=null;
		
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

					

					Button usar = new Button("Equipar");
					usar.setStyle(GUIStyles.DEFAULT_STYLE);
					usar.setToolTipText("USAR ARMA");

					usar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btnEquiparClicked(table, row);
						}
					});
					return usar;
				}
			});

			

			return nestedCellRenderer;
		}
		// --------------------------------------------------------------------------------
		
	private void btnEquiparClicked(ETable table, int row) {
			
			TableDtaModel model = table.getTableDtaModel();
			armaActual= (ArmaTerreno) model.getElementAt(row);					
			
		}
	
	public ArmaTerreno getArmaActual()
	{
		return armaActual;
	}
	
	public void setArmaActualnula()
	{
		 armaActual=null;
	}
	

}
