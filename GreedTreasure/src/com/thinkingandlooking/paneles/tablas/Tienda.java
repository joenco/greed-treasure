package com.thinkingandlooking.paneles.tablas;


import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.ModeloArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.tablas.TablaArmasTerreno;
import com.thinkingandlooking.tablas.TablaBaseModeloArmaTerreno;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Panel;
import nextapp.echo.app.WindowPane;
import nextapp.echo.extras.app.TabPane;

public class Tienda extends ContentPane {
	
//	TabPane tab;
	WindowPane ventana;
	Usuario usuario;
	
	public Tienda(Usuario usuario) {
		ventana=new WindowPane();
		this.usuario=usuario;
		initGui();
	}

	public void initGui(){
		
		//tab=new TabPane();
		//ventana.add(tab);
		
		//TablaArmasTerreno tabla=new TablaArmasTerreno("Comprar");
		TablaBaseModeloArmaTerreno tabla= new TablaBaseModeloArmaTerreno();
		if(MetodosArmaTerreno.mostrarArmasInventario().size()==0)
			System.err.println("LISTA VACIA");
		
		tabla.crearTabla(MetodosArmaTerreno.mostrarArmasInventario());
		ventana.add(tabla);
		//((MainApp)ApplicationInstance.getActive()).getDefaultWindow().getContent().add(ventana);
		add(ventana);

	

	}
}

