package com.thinkingandlooking.paneles.edicioncaballero;


import java.util.List;


import nextapp.echo.app.Alignment;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.ResourceImageReference;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.ImageCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.database.ArmaCaballero;
import com.thinkingandlooking.database.ConstantesExtremidades;
import com.thinkingandlooking.database.ModeloArmaCaballero;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.tablas.Tabla;

public class TablaExtremidades extends Tabla {
	Usuario usuario;
	private int [] ctte= {  ConstantesExtremidades.CABEZA , ConstantesExtremidades.TORSO ,ConstantesExtremidades.BRAZO_IZQ , ConstantesExtremidades.BRAZO_DER }; 
	private String [] extremidades={"Cabeza","Torso","Brazo Izquierdo","Brazo Derecho"};
	public TablaExtremidades() {
		super();
	}

	public void crearTabla(List<Object> a) {
	
	boolean encontrado;
	
	for(int i=0;i<ctte.length;i++)
	{
		encontrado=false;
		for (Object obj : a) {
			
			ArmaCaballero ma = (ArmaCaballero) obj;
			
			if(ma.getExtremidad()== ctte[i])
			{	
			    tableDtaModel.add(ma);
			    encontrado=true;
			
			}
		}
		
		if( encontrado==false)
		{
			ArmaCaballero temp= new ArmaCaballero();
			ModeloArmaCaballero aux=new ModeloArmaCaballero();
			aux.setNombre("ninguna");
			temp.setRefModel(aux);
			temp.setExtremidad(i);
			tableDtaModel.add(temp);
		}
			
		
	}
	
	}

	public TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************
		tableColumn = new TableColumn() {

			public Object getValue(ETable table, Object element) {
				ArmaCaballero armas = (ArmaCaballero) element;
				return extremidades[armas.getExtremidad()];
			}
		};
		tableColumn.setWidth(new Extent(1));
		tableColumn.setHeadValue("Extremidad");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
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
				ArmaCaballero armaEnExtremidad = (ArmaCaballero) element;
				
				if(!armaEnExtremidad.getRefModel().getNombre().equals("ninguna"))
					return new HttpImageReference("imagenes_tabla?arma="
						+ armaEnExtremidad.getRefModel().getNombre()
						+ "&tipoDeConsulta=CONSULTA_MODELO_ARMA_TERRENO");
				

			    return new ResourceImageReference( //
	    		"com/thinkingandlooking/Imagenes/ArmaCaballero/sinarma.jpg");

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
}
