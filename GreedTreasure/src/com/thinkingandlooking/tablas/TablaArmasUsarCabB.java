package com.thinkingandlooking.tablas;

import java.util.List;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.cleda3echo.echo.table.base.CellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.database.ArmaCaballero;
import com.thinkingandlooking.database.ModeloArmaCaballero;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.utils.GUIStyles;

public class TablaArmasUsarCabB extends Tabla {
	Usuario usuario;
	public TablaArmasUsarCabB(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	@Override
	public void crearTabla(List<Object> a) {
		for (Object obj : a) {
			ArmaCaballero aCab = (ArmaCaballero) obj;
			tableDtaModel.add(aCab);
		}
		
	}
	@Override
	public TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaCaballero modeloArmascaballero = (ModeloArmaCaballero) element;
				return modeloArmascaballero.getNombre();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("Municiones");

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
		
		/****************************************************/
		
		tableColumn = new TableColumn();
		tableColumn.setHeadValue("ACCION");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		lcr.setBackground(Color.ORANGE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		tableColumn.setDataCellRenderer(initRadioCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		/****************************************************/
		tableColumn = new TableColumn();
		tableColumn.setHeadValue("ACCION");

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
	
	
	
	private NestedCellRenderer initRadioCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				RadioButton izqButton = new RadioButton("Izq");
				izqButton.setStyle(GUIStyles.DEFAULT_STYLE);

				izqButton.setSelected(true);
				return izqButton;
			}
		});
		
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				RadioButton derButton = new RadioButton("Der");
				derButton.setStyle(GUIStyles.DEFAULT_STYLE);

				derButton.setSelected(false);
				return derButton;
			}
		});
		
		return nestedCellRenderer;
	}
	private CellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.DEFAULT));

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				Button button = new Button("Equipar");
				button.setStyle(GUIStyles.DEFAULT_STYLE);

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
	private void btnClicked(ETable table, int row) {
		// TODO Auto-generated method stub
		
	}
}
