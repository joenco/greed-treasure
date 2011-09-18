package com.thinkingandlooking.paneles.tablaenemigos;


import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;
import com.thinkingandlooking.tablas.TablaContrincantes;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Column;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;


public class PanelContrincantes extends Panel {

	private Usuario usuario;
	private HtmlLayout htmlLayout;
	private Perfil perfil;
	
	// --------------------------------------------------------------------------------

	public PanelContrincantes(Usuario usuario, Perfil perfil) {
		this.usuario = usuario;
		this.perfil=perfil;
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		
		
		setInsets(new Insets(8, 8, 8, 8));
		
		try {
			htmlLayout = new HtmlLayout( 
					getClass().getResourceAsStream("atacarTerreno.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		HtmlLayoutData hld;
		
		hld = new HtmlLayoutData("title");
		Label lblTitle = new Label("LISTA DE ENEMIGOS PARA ATACAR");
		lblTitle.setLayoutData(hld);
		htmlLayout.add(lblTitle);
	

		hld = new HtmlLayoutData("panel");
		Column col = new Column();
		
		TablaContrincantes tabla =new TablaContrincantes(perfil, usuario);
		tabla.crearTabla(ConsultasCaballero.getContrincantes(usuario));
		col.add(tabla);
		col.add(tabla.getPaginacion());
			
		col.setLayoutData(hld);
		htmlLayout.add(col);
		add(htmlLayout);
	}
	
}