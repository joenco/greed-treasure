package com.thinkingandlooking.paneles.tablas;


import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.tablas.TablaBaseModeloArmaTerreno;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Panel;
import nextapp.echo.app.WindowPane;
import nextapp.echo.extras.app.TabPane;

public class Tienda extends ContentPane {
	
//	TabPane tab;
	WindowPane ventana;
	
	public Tienda(Usuario usuario) {
		ventana=new WindowPane();
		initGui();
	}

	public void initGui(){
		
		//tab=new TabPane();
		//ventana.add(tab);
		
		TablaBaseModeloArmaTerreno tabla=new TablaBaseModeloArmaTerreno();
		Usuario user=new Usuario();
		user.setLogin("tico");
		tabla.crearTabla(MetodosArmaTerreno.tablaPrincipal(user));
		ventana.add(tabla);
		((MainApp)ApplicationInstance.getActive()).getDefaultWindow().getContent().add(ventana);
		

	

	}
}

/*	
	
//    List<Object> listaArmas = MetodosArmaTerreno.tablaPrincipal(usuario);
//  col.add(mostrar(listaArmas));
	
	nextapp.echo.app.Column col=new nextapp.echo.app.Column();
	col.add(tabla);
	//tab.add(tabla);
	
	tab.add(col);
	
	add(tab);	

	}*/