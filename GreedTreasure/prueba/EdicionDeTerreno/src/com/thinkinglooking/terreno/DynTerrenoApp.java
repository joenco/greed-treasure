package com.thinkinglooking.terreno;


import echopoint.ImageMap;

import echopoint.model.RectangleSection;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.Window;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;



public class DynTerrenoApp extends ApplicationInstance {

	
	
	  private TextField txtId;
	  private Label lblSelected;
	  private ImageMap terrenoSeccionado;
	  private Column col;
	  private char armaSeleccionada='0';
	  private boolean bandera=false;
	  private boolean ultimoClickTerreno=false;
	  private String ultimaCoodenadaClick;
	  private String    id ="1"; // Esto se supone que lo conozco desde el login
	  Terreno terreno=new Terreno(id);// este atributo no lo sea aun pero puede estar en toda la aplicacion para un usuario

	  // --------------------------------------------------------------------------------

	  public Window init() {
		  	Window window = new Window();
		  	

		    ContentPane contentPane = new ContentPane();
		    contentPane.setInsets(new Insets(2, 2, 2, 2));
		    window.setContent(contentPane);
		   

		    col = new Column();
		    col.setCellSpacing(new Extent(5));
		    contentPane.add(col);
		  //  System.out.printf("el caracter %c", armaSeleccionada);
		    
		    terrenoSeccionado= seccionarTerreno(obtenerTerrenoUsuario("(-1,-1)"));
		   
		    col.add(terrenoSeccionado);
		    bandera=true;
		    Row row = new Row();
		    row.setCellSpacing(new Extent(5));
		    col.add(row);
		    
		    Row row2 = new Row();
		    row2.setCellSpacing(new Extent(5));
		    col.add(row2);

		    txtId = new TextField();
		    row.add(txtId);

		    Button btnGo = new Button("Go...");
		    btnGo.setToolTipText("Este es el tooltip");
		    btnGo.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent arg0) {
		       btnGoClicked();
		      }
		    });
		    
		    row.add(btnGo);
		    
		    Button moverArma= new Button("Mover Arma a (x,y)");
		    moverArma.setToolTipText("Este boton cambia el arma");
		    moverArma.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent arg0) {
		      lblSelected.setText("selecciona el arma A mover luego la nueva coordenada");
		       armaSeleccionada='0';
		      }
		    });
		    
		    row2.add(moverArma);

		    lblSelected = new Label("nothing selected");
		    col.add(lblSelected);
		   // ultimaCoodenadaClick=new String("(-1,-1)");

		    return window;
	    }


	  // --------------------------------------------------------------------------------


	  public HttpImageReference obtenerTerrenoUsuario(String coordenadas ){
		  
		  String x=coordenadas.substring(1, coordenadas.indexOf(",",0)	);
		  String y=coordenadas.substring(coordenadas.indexOf(",",1)+1, coordenadas.length()-1);
		  
		  if(bandera==false || armaSeleccionada != '0')
			  return( new  HttpImageReference("terrenodyn?user_id="+id+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+x+
					  							"&coordenada_y="+y+"&nueva_x=-1&nueva_y= -1") );
		  
		else if(ultimoClickTerreno)
		  {    System.out.printf("POCA COSA \n");
			  String viejaX=ultimaCoodenadaClick.substring(1,ultimaCoodenadaClick.indexOf(",",0));
			  String viejaY=ultimaCoodenadaClick.substring(ultimaCoodenadaClick.indexOf(",",1)+1, ultimaCoodenadaClick.length()-1);
			  return( new  HttpImageReference("terrenodyn?user_id="+id+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+viejaX+
					  							"&coordenada_y="+viejaY+"&nueva_x="+x+"&nueva_y="+y) );
		  } 
		  return(null);
	  }
		    
	  
	  public ImageMap  seccionarTerreno( HttpImageReference imagenTerreno)
	  {    
		
		   
		   int dimensionImagen=Terreno.getSizeTiles()*terreno.getDimensionmatrizTerreno();
		   int dimMatriz=terreno.getDimensionmatrizTerreno();
		   
		   ImageMap imageMap = new ImageMap(imagenTerreno);
           imageMap.setWidth (new Extent(dimensionImagen));
		   imageMap.setHeight(new Extent(dimensionImagen));

		    //imageMap.setImage(imagenTerreno.getUri());
		    imageMap.removeAllSections();

		   imageMap.addActionListener(new ActionListener() {
		  
			 public void actionPerformed(ActionEvent evt) {
		      lblSelected.setText(evt.getActionCommand());
		      if(armaSeleccionada!='0'|| ultimoClickTerreno)
			      { 	
			    	  	terrenoSeccionado=seccionarTerreno(obtenerTerrenoUsuario(evt.getActionCommand()));
			    	    col.remove(0);
			    	    col.add(terrenoSeccionado, 0);
			    	    ultimoClickTerreno=false;
			    	    
			      }
		      else
		      {
		    	  lblSelected.setText("cupalo");
		    	  ultimaCoodenadaClick=new String( evt.getActionCommand());	
		    	  ultimoClickTerreno=true;
		      }
		      
		      }
		    });

		   
		    for (int i=0 ; i < dimMatriz;i++) {
		    	for (int j=0; j < dimMatriz;j++ ) {
		    		
		    	 String coordenada= new String("("+String.valueOf(i)+","+String.valueOf(j)+")");
		    	 imageMap.addSection(new RectangleSection(40*j,40*(i+1),40*(j+1) ,40*i , coordenada));
		    	 
		    	}
		    }
		    
		   return (imageMap);
		}
	  
	  private void btnGoClicked() {
		  
		  	char car= txtId.getText().isEmpty() ?'0':txtId.getText().charAt(0);
		  	if( ( car >= 'a' && car <= 'z')||(car >= 'A' && car <= 'Z')||(car >= '1' && car <= '9'))
		    		armaSeleccionada=car;
		  	else
		  		armaSeleccionada='0';
		  	
		  	ultimoClickTerreno=false;
 	  }
	  
}
