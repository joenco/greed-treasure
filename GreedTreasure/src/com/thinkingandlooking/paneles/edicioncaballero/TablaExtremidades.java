package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.ImageCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.paneles.tablaenemigos.TestTableModel;

public class TablaExtremidades extends ETable {
	Usuario usuario;
	private TestTableModel tableDtaModel;
	ArmaEnExtremidad armaEnExtremidad;

	public TablaExtremidades(Usuario usuario) {
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		setTableDtaModel(tableDtaModel);
		setTableColModel(tableColModel);
		setTableSelModel(tableSelModel);

		setEasyview(true);

		setBorder(new Border(1, Color.GREEN, Border.STYLE_NONE));
		setInsets(new Insets(30, 20, 50, 20));

		crear_tabla();
	}

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************
		tableColumn = new TableColumn() {

			public Object getValue(ETable table, Object element) {
				ArmaEnExtremidad armas = (ArmaEnExtremidad) element;
				return armas.getExtremidad();
			}
		};
		tableColumn.setWidth(new Extent(1));
		tableColumn.setHeadValue("Extremidad");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ArmaEnExtremidad armasBean = (ArmaEnExtremidad) element;

				return armasBean.getBi();

			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("IMAGEN");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		ImageCellRenderer icr = new ImageCellRenderer();
		icr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		tableColumn.setDataCellRenderer(icr);
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	public void crear_tabla() {
		BufferedImage Bu;
		byte[] Ba = usuario.getCaballero().getModeloCaballeroRef().getImgTerreno();
		InputStream in = new ByteArrayInputStream(Ba);
//Bu = ImageIO.read(in).getSubimage(0, 0, 30, 30);
		
		
		List<ArmaEnExtremidad> armasList = new ArrayList<ArmaEnExtremidad>();
	//	ArmaEnExtremidad a = new ArmaEnExtremidad("Cabeza", Bu);
		//armasList.add(a);
/*
		a = new ArmaEnExtremidad("Torso");
		armasList.add(a);

		a = new ArmaEnExtremidad("ManoIzq");
		armasList.add(a);

		a = new ArmaEnExtremidad("ManoDer");
		armasList.add(a);
*/
		for (ArmaEnExtremidad armas : armasList) {

			tableDtaModel.add(armas);
		}

	}
}
