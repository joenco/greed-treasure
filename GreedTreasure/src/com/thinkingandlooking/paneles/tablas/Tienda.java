package com.thinkingandlooking.paneles.tablas;


import com.thinkingandlooking.database.MetodosArmaCaballero;
import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.tablas.TablaArmasCaballero;
import com.thinkingandlooking.tablas.TablaArmasTerreno;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.WindowPane;
import nextapp.echo.extras.app.TabPane;
import nextapp.echo.extras.app.layout.TabPaneLayoutData;

public class Tienda extends ContentPane {
	
	TabPane tab;
	WindowPane ventana;
	Usuario usuario;
	
	public Tienda(Usuario usuario) {
		ventana=new WindowPane();
		ventana.setTitle("TIENDA DE ARMAS");		
		this.usuario=usuario;
		initGui();
	}

	public void initGui(){
		
		tab=new TabPane();
		ventana.add(tab);
		ventana.setHeight(new Extent(350));
		ventana.setWidth(new Extent(600));
		ventana.setMovable(false);
		ventana.setClosable(false);
		ventana.setTitleInsets(new Insets(225, 12));
		ventana.setPositionX(new Extent(50));
		ventana.setPositionY(new Extent(50));
		
		TabPaneLayoutData layout=new TabPaneLayoutData();
		layout.setTitle("Armas De Terreno");
		
		Column col=new Column();
		col.setLayoutData(layout);
		
		TablaArmasTerreno tabla=new TablaArmasTerreno("Comprar", usuario);
		
		
		tabla.crearTabla(MetodosArmaTerreno.mostrarArmasInventario());
		col.add(tabla);
		col.add(tabla.getPaginacion());
		tab.add(col);
		
		
		
		layout = new TabPaneLayoutData();
	    layout.setTitle("Armas de Caballero");
	    col = new Column();
	    col.setLayoutData(layout);
	    
	    TablaArmasCaballero tablaCaballero = new TablaArmasCaballero(usuario);
	    tablaCaballero.crearTabla(MetodosArmaCaballero.modeloArma());
	    col.add(tablaCaballero);
	    col.add(tablaCaballero.getPaginacion());
	    
	    tab.add(col);

	    
	    
	    add(ventana);

	}
}

