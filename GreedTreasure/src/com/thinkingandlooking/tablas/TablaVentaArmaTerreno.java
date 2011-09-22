package com.thinkingandlooking.tablas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaVentaArmaTerreno extends Tabla{
	
	private Set<ArmaTerreno> carrito;
	private List<CheckBox> listCheck;
	 
	public TablaVentaArmaTerreno(Usuario usuario) {
		super();
		carrito = new HashSet<ArmaTerreno>();
		listCheck=new ArrayList<CheckBox>();
	}
	
	
	public void crearTabla(List<Object> a) {
		
		listCheck=new ArrayList<CheckBox>();
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

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ArmaTerreno ArmasTerreno = (ArmaTerreno) element;
				return ArmasTerreno.getModelRef().getOro();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("GANANCIA POR C/U");

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
		
		tableColumn.setDataCellRenderer(initCheckBoxDataCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);
	

		return tableColModel;
	}
     	// --------------------------------------------------------------------------------
		// Configuración de la barra de comandos de render
		// --------------------------------------------------------------------------------

		private NestedCellRenderer initCheckBoxDataCellRenderer() {


			NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
			nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
					Alignment.DEFAULT));

			nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
				@Override
				public Component getCellRenderer(final ETable table,
						final Object value, final int col, final int row) {

					CheckBox checkbutton = new CheckBox();
					checkbutton.setStyle(GUIStyles.DEFAULT_STYLE);
					checkbutton.setToolTipText("seleccione para luego comprar");
				//	checkbutton.setSelected(true);
					checkbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							CheckBox src = (CheckBox) evt.getSource();				
							btnClicked(table,row,src.isSelected());
							
						}

						
					});
				
					listCheck.add(row, checkbutton);
					return checkbutton;
				}
			});


			return nestedCellRenderer;
		}

		// --------------------------------------------------------------------------------
		// Configuración de la barra de comandos de render
		// --------------------------------------------------------------------------------

		private NestedCellRenderer initCheckBoxHeadCellRenderer() {


			NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
			nestedCellRenderer.setBackground(Color.ORANGE);
			nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
					Alignment.DEFAULT));

			nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
				@Override
				public Component getCellRenderer(final ETable table,
						final Object value, final int col, final int row) {

					CheckBox checkbutton = new CheckBox();
					checkbutton.setStyle(GUIStyles.DEFAULT_STYLE);
					checkbutton.setToolTipText("seleccionr Armas de Pagina");
					
					checkbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							CheckBox src = (CheckBox) evt.getSource();				
							btnClickedHead(src.isSelected());
						}

						
					});
					return checkbutton;
				}
			});


			return nestedCellRenderer;
		}

		// --------------------------------------------------------------------------------
		private void btnClicked(ETable table, int row,boolean seleccionado) {
			
			TableDtaModel model = table.getTableDtaModel();
			ArmaTerreno armaTerreno= (ArmaTerreno) model.getElementAt(row);
			
			
			if(seleccionado)
			{	
				carrito.add(armaTerreno);
			}
			else
			{	
				carrito.remove(armaTerreno);
			}	
		}
		
		private void btnClickedHead(boolean seleccionado) {
			
			int primero=tableDtaModel.getPageSize()*tableDtaModel.getCurrPage();
			int limite=primero+tableDtaModel.getPageSize();
			ArmaTerreno armaTerreno;
			
		
			for(int i=primero ; (i <= limite); i++)
			{		
				if(i==listCheck.size())
					break;
				
				if(seleccionado)
					System.out.println("true:");
				else
				{	System.out.println("false:");
				}	System.out.println("i para lista= "+i);
					listCheck.get(i).setSelected(seleccionado);
				
					if(i < tableDtaModel.getRowCount())
					{	System.out.println("i para tabla= "+i);
						armaTerreno= (ArmaTerreno)tableDtaModel.getElementAt(i);
						if(seleccionado)
						{	
							
							carrito.add(armaTerreno);
						}
						else
						{	
							carrito.remove(armaTerreno);
						}
					}
			}
		}
		
		public Set<ArmaTerreno> getCarrito()
		{
			return carrito;
		}
}
