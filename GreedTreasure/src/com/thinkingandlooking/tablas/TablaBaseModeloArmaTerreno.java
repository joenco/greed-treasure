package com.thinkingandlooking.tablas;

import java.awt.Image;
import java.util.List;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.AwtImageReference;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BufferImageCellRender;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.utils.BufferedImageCache;
import com.thinkingandlooking.utils.EnumConsultas;



public class TablaBaseModeloArmaTerreno extends Tabla {

	public TablaBaseModeloArmaTerreno() {
		super();
	}

	@Override
	public void crearTabla(List<Object> a) {
		
		for (Object obj : a) {
			ModeloArmaTerreno ma = (ModeloArmaTerreno) obj;
			tableDtaModel.add(ma);
		}
		
	}

	@Override
	public TableColModel initTableColModel() {
		
	
		TableColModel tableColModel = new TableColModel();
		   
		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************
		
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;

				return (new AwtImageReference((Image)BufferedImageCache.getInstance().getBufferedImage(modeloArmasTerreno.getNombre(), EnumConsultas.CONSULTA_MODELO_ARMA_TERRENO)));

			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("IMAGEN");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		BufferImageCellRender icr = new BufferImageCellRender();
		icr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		
		tableColumn.setDataCellRenderer(icr);
		tableColModel.getTableColumnList().add(tableColumn);
		
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getNombre();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("NOMBRE");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getAtaque();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ATAQUE");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getDefensa();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("DEFENSA");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getAlcance();
			}
		};
		
		
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ALCANCE");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getNivel();
			}
		};
		
		
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("NIVEL");

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
				ModeloArmaTerreno modeloArmasTerreno = (ModeloArmaTerreno) element;
				return modeloArmasTerreno.getOro();
			}
		};
		tableColumn.setWidth(new Extent(10));
		tableColumn.setHeadValue("ORO");

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
