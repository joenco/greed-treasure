package com.thinkingandlooking.paneles.tablas;


import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.tablas.TablaArmasTerreno;
import com.thinkingandlooking.tablas.TablaBaseModeloArmaTerreno;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Panel;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.WindowPaneEvent;
import nextapp.echo.app.event.WindowPaneListener;
import nextapp.echo.extras.app.TabPane;
import nextapp.echo.extras.app.layout.TabPaneLayoutData;

public class Tienda extends ContentPane {
	
	TabPane tab;
	WindowPane ventana;
	Usuario usuario;
	
	public Tienda(Usuario usuario) {
		ventana=new WindowPane();
		ventana.setTitle("Armas");
	/*	ventana.addWindowPaneListener(new WindowPaneListener() {
			
			@Override
			public void windowPaneClosing(WindowPaneEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		})
		*/
		
		this.usuario=usuario;
		initGui();
	}

	public void initGui(){
		
		tab=new TabPane();
		ventana.add(tab);
		
		TabPaneLayoutData layout=new TabPaneLayoutData();
		layout.setTitle("Armas De Terreno");
		
		Column col=new Column();
		col.setLayoutData(layout);
		
		TablaArmasTerreno tabla=new TablaArmasTerreno("Comprar", usuario);
		if(MetodosArmaTerreno.mostrarArmasInventario().size()==0)
			System.err.println("LISTA VACIA");
		
		tabla.crearTabla(MetodosArmaTerreno.mostrarArmasInventario());
		col.add(tabla);
		tab.add(col);
		add(ventana);

	

	}
}

