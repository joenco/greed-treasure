package com.thinkingandlooking.tablas;

import java.util.Set;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.LayoutData;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
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
import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.paneles.edicionterreno.DynTerrenoApp;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaEdicionArmaTerreno extends TablaBaseModeloArmaTerreno {
	
	private Usuario usuario;
	private TransitionPane transicionTablas;

	public TablaEdicionArmaTerreno(Usuario usuario,TransitionPane transicionTablas) {
		super();
		this.usuario=usuario;
		this.transicionTablas=transicionTablas;
		
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
			
			/*TableDtaModel model = table.getTableDtaModel();

			ModeloArmaTerreno ModeloArmaTerreno = (ModeloArmaTerreno) model.getElementAt(row);

			ModeloArmaTerreno.setnumeroArmas(ModeloArmaTerreno.getArmaTerrenoList().size() - 1);
			model.getTableDtaModelEvtProxy().fireActionEvent(
					new TableDtaModelEvent(model));
			label.setText("selecciono: "+ModeloArmaTerreno.getNombreArma());

			if (ModeloArmaTerreno.getnumeroArmas() == 0)
				tableDtaModel.del(tableDtaModel.getElementAt(row));*/
		}

	// --------------------------------------------------------------------------------

	private void btnVenderClicked(ETable table, int row) {

		TableDtaModel model = table.getTableDtaModel();
		ModeloArmaTerreno armaTerreno = (ModeloArmaTerreno) model.getElementAt(row);
		transicionTablas.removeAll();
		transicionTablas.add(construirPanel(armaTerreno));

	}

	// --------------------------------------------------------------------------------
	
	public TablaVentaArmaTerreno construirTablaVentaTerreno(ModeloArmaTerreno armaTerreno)
	{
		TablaVentaArmaTerreno tablaVenta=new TablaVentaArmaTerreno(usuario);
		tablaVenta.setPaginacion(6);
		tablaVenta.crearTabla(MetodosArmaTerreno.tablaPorArma(usuario,armaTerreno.getNombre()) );
		
		return (tablaVenta);
	}
	
	public Panel construirPanel(ModeloArmaTerreno armaTerreno)
	{
		Panel panel = new Panel();
		panel.setWidth(new Extent(560));
    	panel.setHeight(new Extent(1500));
		Column col  = new Column();
		final TablaVentaArmaTerreno tabla= construirTablaVentaTerreno(armaTerreno);
		col.add(tabla);
		col.add(tabla.getPaginacion());
		Row row =new Row();
		Button buttonVender=new Button("VENDER");
		buttonVender.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		buttonVender.setWidth(new Extent(100));
		buttonVender.setTextAlignment(new Alignment(50, 2));
		buttonVender.setAlignment(new Alignment(Alignment.CENTER, Alignment.DEFAULT));
		buttonVender.setToolTipText("seleccione Armas para vender");
		
		buttonVender.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
					venderArmas(tabla.getCarrito());
				
			}

			
		});
		
		row.add(buttonVender);
		
		Button buttonVolver=new Button("VOLVER");
		buttonVolver.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		buttonVolver.setWidth(new Extent(100));
		buttonVolver.setTextAlignment(new Alignment(50, 2));
		buttonVender.setAlignment(new Alignment(Alignment.CENTER, Alignment.DEFAULT));
		buttonVolver.setToolTipText("seleccione para volver a tabla modelo Arma");
		
		buttonVolver.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				transicionTablas.removeAll();
				TablaEdicionArmaTerreno tabla =new TablaEdicionArmaTerreno(usuario, transicionTablas);
				tabla.crearTabla(MetodosArmaTerreno.tablaPrincipal(usuario));
				transicionTablas.add(tabla);
	
			}

			
		});
		row.add(buttonVolver);
		col.add(row);
		panel.add(col);
		
		return panel;
		
	}
	
	private void venderArmas(Set<ArmaTerreno> carrito) {
		for(ArmaTerreno Arma:carrito)
		{
			MetodosArmaTerreno.venderAlaTienda(usuario.getCaballero(), Arma);
		}
		
	}
	
}
