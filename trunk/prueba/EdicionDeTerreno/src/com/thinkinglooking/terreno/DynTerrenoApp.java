package com.thinkinglooking.terreno;

import java.awt.Color;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import sun.swing.SwingUtilities2.Section;
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
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;



public class DynTerrenoApp extends ApplicationInstance {

	
	
	  private TextField txtId;
	  private Label lblSelected;
	  private ImageMap terrenoSeccionado;
	  private Column col;

	  // --------------------------------------------------------------------------------

	  public Window init() {
		  	Window window = new Window();

		    ContentPane contentPane = new ContentPane();
		    contentPane.setInsets(new Insets(2, 2, 2, 2));
		    window.setContent(contentPane);

		    col = new Column();
		    col.setCellSpacing(new Extent(5));
		    contentPane.add(col);

		    terrenoSeccionado= seccionarTerreno(obtenerTerrenoUsuario());
		   
		    col.add(terrenoSeccionado);

		    Row row = new Row();
		    row.setCellSpacing(new Extent(5));
		    col.add(row);

		    txtId = new TextField();
		    row.add(txtId);

		    Button btnGo = new Button("Go...");
		    btnGo.setToolTipText("Este es el tooltip");
		    btnGo.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent arg0) {
		       // btnGoClicked();
		      }
		    });
		    
		    row.add(btnGo);

		    lblSelected = new Label("nothing selected");
		    col.add(lblSelected);

		    return window;
	    }


	  // --------------------------------------------------------------------------------


	  public HttpImageReference obtenerTerrenoUsuario(){
		  
	      return( new  HttpImageReference("terrenodyn?user_id") );
	     }
		    
	  
	  public ImageMap  seccionarTerreno( HttpImageReference imagenTerreno)
	  {    
		
		    
         
		   ImageMap imageMap = new ImageMap(imagenTerreno);
           imageMap.setWidth (new Extent(640));
		   imageMap.setHeight(new Extent(640));

		    //imageMap.setImage(imagenTerreno.getUri());
		    imageMap.removeAllSections();

		   imageMap.addActionListener(new ActionListener() {
		  
			 public void actionPerformed(ActionEvent evt) {
		      lblSelected.setText(evt.getActionCommand());
		      }
		    });

		   
		    for (int i=0 ; i < 16;i++) {
		    	for (int j=0; j < 16;j++ ) {
		    		
		    	 String coordenada= new String("("+String.valueOf(i)+","+String.valueOf(j)+")");
		    	 imageMap.addSection(new RectangleSection(40*j,40*(i+1),40*(j+1) ,40*i , coordenada));
		    	 
		    	}
		    }
		    
		   return (imageMap);
		}

}
