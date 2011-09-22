package com.thinkingandlooking.paneles.edicionterreno;
        
import java.util.List;
import com.thinkingandlooking.database.MetodosArmaTerreno;
import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.tablas.TablaEdicionArmaTerreno;
import nextapp.echo.app.Panel;
import echopoint.ImageMap;
import echopoint.model.RectangleSection;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.TransitionPane;



public class DynTerrenoApp extends Panel {

	  private Usuario usuario;	
	  private TextField txtId;
	  private Label lblSelected;
	  private ImageMap terrenoSeccionado;
	  private Column col;
	  private char armaSeleccionada='0';
	  private boolean bandera=false;
	  private boolean ultimoClickTerreno=false;
	  private String ultimaCoodenadaClick;
	  private TransitionPane efectos=new TransitionPane();
	  private TransitionPane transicionTablas;
	  private Terreno terreno;
	  private Perfil perfil;
	  private TablaEdicionArmaTerreno tabla;
	  // --------------------------------------------------------------------------------
	  public DynTerrenoApp(Usuario usuario,Perfil perfil)
	  {
		  terreno = new Terreno(usuario.getLogin());
		  this.usuario = usuario;
		  this.perfil=perfil;
		  initGUI();
	  }
	  public void initGUI() {
		  	
		  	

		    col = new Column();
		    col.setCellSpacing(new Extent(5));
		    add(col);
	
		   
		    
		    terrenoSeccionado= seccionarTerreno(obtenerTerrenoUsuario("(-1,-1)"));	
		    efectos.add(terrenoSeccionado);
		    efectos.setDuration(1000);
		    efectos.setType(TransitionPane.TYPE_BLIND_BLACK_IN);
		    
		    Row row3=new Row();
		    Panel contenedor=new Panel();
		    contenedor.setHeight(new Extent(400));
		    contenedor.setWidth (new Extent(400));
		   	contenedor.add(efectos);
		    row3.add(contenedor);
		 
		    
		    List<Object> listaArmas = MetodosArmaTerreno.tablaPrincipal(usuario);
		  
		   
		    if(listaArmas.size()>0)
		    {	
		    	Panel panelTransition=new Panel();
		    	transicionTablas=new TransitionPane();
		    	TablaEdicionArmaTerreno tabla= mostrar(listaArmas);
		    	
		    	Column columnTabla=new Column();
		    	columnTabla.add( tabla);
		    	columnTabla.add(tabla.getPaginacion());
		    	
		    	transicionTablas.add(columnTabla);
		    	panelTransition.add(transicionTablas);
		    	panelTransition.setWidth(new Extent(560));
		    	panelTransition.setHeight(new Extent(300));
		    	
		    	row3.add(panelTransition);
		    }
		    else
		    	crearAviso();
		    
		    col.add(row3);
		   
		    bandera=true;
		    
		    Row row = new Row();
		    row.setCellSpacing(new Extent(5));
		    
		    row = new Row();
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
		   

	    }


	  private void crearAviso() {
		  final WindowPane aviso=new WindowPane();
	    	aviso.setTitle("No Posee Armas");//,new Extent(400),new Extent(400));
	    	
	    	Column col=new Column();
	    	
	    	Label mensaje=new Label("Debe Adquirir Armas para Editar Su Terreno");
	    	col.add(mensaje);
	    	
	    	Row fila =new Row();
	    	col.add(fila); 	
	    	
	    	Button ok=new Button("ok");
	    	ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					aviso.userClose();
				}

			});
	    	
	    	fila.add(ok);
	    	
	    	Button comprar=new Button("Comprar Armas");
	    	fila.add(comprar);
	    	
	    	aviso.add(col);
	    	aviso.setMovable(false);
	    	aviso.setResizable(false);
	    	aviso.setClosable(false);
	    	aviso.setModal(true);
	    	((MainApp)ApplicationInstance.getActive()).getDefaultWindow().getContent().add(aviso);
	    	
		
	}
	private TablaEdicionArmaTerreno mostrar(List<Object> listaArmas) {
		
		tabla=new TablaEdicionArmaTerreno(usuario,perfil,transicionTablas);
		tabla.crearTabla(listaArmas);
		
		return tabla;
	}
	// --------------------------------------------------------------------------------


	  public HttpImageReference obtenerTerrenoUsuario(String coordenadas ){
		  
		  String x=coordenadas.substring(1, coordenadas.indexOf(",",0)	);
		  String y=coordenadas.substring(coordenadas.indexOf(",",1)+1, coordenadas.length()-1);
		  if(tabla!=null)
		  if(tabla.getTablaUsar()!=null)
		  System.out.println("lo que es"+tabla.getTablaUsar().getArmaActual().getModelRef().getNombre());
		  if(bandera==false || armaSeleccionada != '0')
			  return( new  HttpImageReference("terrenodyn?user_login="+usuario.getLogin()+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+x+
					  							"&coordenada_y="+y+"&nueva_x=-1&nueva_y= -1") );
		  
		else if(ultimoClickTerreno)
		  {    System.out.printf("POCA COSA \n");
			  String viejaX=ultimaCoodenadaClick.substring(1,ultimaCoodenadaClick.indexOf(",",0));
			  String viejaY=ultimaCoodenadaClick.substring(ultimaCoodenadaClick.indexOf(",",1)+1, ultimaCoodenadaClick.length()-1);
			  return( new  HttpImageReference("terrenodyn?user_login="+usuario.getLogin()+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+viejaX+
					  							"&coordenada_y="+viejaY+"&nueva_x="+x+"&nueva_y="+y) );
		  } 
		  return(null);
		  
		  /*
		   *  if(bandera==false || armaSeleccionada != '0')
			  return( new  HttpImageReference("terrenodyn?user_login="+usuario.getLogin()+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+x+
					  							"&coordenada_y="+y+"&nueva_x=-1&nueva_y= -1") );
		  
		else if(ultimoClickTerreno)
		  {    System.out.printf("POCA COSA \n");
			  String viejaX=ultimaCoodenadaClick.substring(1,ultimaCoodenadaClick.indexOf(",",0));
			  String viejaY=ultimaCoodenadaClick.substring(ultimaCoodenadaClick.indexOf(",",1)+1, ultimaCoodenadaClick.length()-1);
			  return( new  HttpImageReference("terrenodyn?user_login="+usuario.getLogin()+"&caracter_arma="+armaSeleccionada+"&coordenada_x="+viejaX+
					  							"&coordenada_y="+viejaY+"&nueva_x="+x+"&nueva_y="+y) );
		  } 
		  return(null);
		   */
	  }
		    
	  
	  public ImageMap  seccionarTerreno( HttpImageReference imagenTerreno)
	  {    
		
		   
		   int dimensionImagen=Terreno.getSizeTiles()*terreno.getDimensionmatrizTerreno();
		   int dimMatriz=terreno.getDimensionmatrizTerreno();
		   int tamTiles=terreno.getSizeTiles();
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
			    	  	efectos.removeAll();
			    	  	efectos.add(terrenoSeccionado);
			    	   // col.remove(0);
			    	   // col.add(a, 0);
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
		    	 imageMap.addSection(new RectangleSection(tamTiles*j,tamTiles*(i+1),tamTiles*(j+1) ,tamTiles*i , coordenada));
		    	 
		    	}
		    }
		    
		   return (imageMap);
		}
	  
	  private void btnGoClicked() {
		  
		  	char car= txtId.getText().isEmpty() ?'0':txtId.getText().charAt(0);
		  	if( ( car >= 'a' && car <= 'z')||(car >= 'A' && car <= 'Z')||(car >= '1' && car <= '9'))
		  	{	
		  		armaSeleccionada=car;
		  	    ultimoClickTerreno=false;
		  	}
		  	else
		  		armaSeleccionada='0';
		  	
		  	
 	  }
	  
	
	  
}
