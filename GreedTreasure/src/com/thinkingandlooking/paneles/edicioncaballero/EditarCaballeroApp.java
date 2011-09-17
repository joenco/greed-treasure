
package com.thinkingandlooking.paneles.edicioncaballero;


import com.thinkingandlooking.database.Usuario;

import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.ImageReference;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.extras.app.ToolTipContainer;

public class EditarCaballeroApp extends Panel {

	private Label lblSelected;
	private Column col;
	private Usuario usuario;
	ImageReference ir;
	
	public EditarCaballeroApp(Usuario usuario){
		this.usuario=usuario;
		initGUI();
	}
	// --------------------------------------------------------------------------------
	private void initGUI() {
		
		col = new Column();
		col.setCellSpacing(new Extent(5));
		add(col);
		
		ir = new HttpImageReference("caballerodyn?login="+usuario.getLogin());
		Label label = new Label(ir);

		ToolTipContainer ttc = new ToolTipContainer();
		
		Column colum = new Column();
		colum.add(new Label("AA"));
		colum.add(new Label("BB"));
		colum.setBackground(Color.RED);
		
	
		ttc.add(colum);
		ttc.add(label);
		
		Row row = new Row();
		row.setCellSpacing(new Extent(10, Extent.PX));
		row.add(ttc);
		row.add(CrearColumna());
		col.add(row);
		
		lblSelected = new Label("Seleccionar Arma y su extremida");
		col.add(lblSelected);
	}
	
private Column CrearColumna(){
		String nombre;
		int nivel;
		int ataque;
		int defensa;
		int oro;
		Label label = new Label();
		Column col = new Column();
		
		nombre = usuario.getCaballero().getModeloCaballeroRef().getNombreModelo();
		label.setText(nombre);
		col.add(label);
		
		nivel = usuario.getCaballero().getNivel();
		label = new Label("Nivel: "+ Integer.toString(nivel));
		col.add(label);
		
		ataque=usuario.getCaballero().getAtaque();
		label = new Label("Ataque: "+ Integer.toString(ataque));
		col.add(label);
		
		defensa = usuario.getCaballero().getDefensa();
		label = new Label("Defensa: "+ Integer.toString(defensa));
		col.add(label);
		
		oro = usuario.getCaballero().getOro();
		label = new Label("Oro: "+ Integer.toString(oro));
		col.add(label);
		
		 TablaExtremidades tabla = new TablaExtremidades(usuario);
		col.add(tabla);
		
		return col;
	}
}