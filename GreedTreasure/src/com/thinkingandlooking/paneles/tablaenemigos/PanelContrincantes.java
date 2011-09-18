package com.thinkingandlooking.paneles.tablaenemigos;


import java.sql.Time;
import java.util.List;
import javax.print.attribute.standard.Severity;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;
import com.thinkingandlooking.tablas.TablaContrincantes;
import com.thinkingandlooking.utils.GUIStyles;
import com.thinkingandlooking.utils.TimedServerPush;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.TaskQueueHandle;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


public class PanelContrincantes extends Panel {

	private Usuario usuario;
	private HtmlLayout htmlLayout;
	private Perfil perfil;
	private Label lbl;
	private TaskQueueHandle taskQueue;
	private TimedServerPush timedServerPush;
	private int time=3;
	// --------------------------------------------------------------------------------

	public PanelContrincantes(Usuario usuario, Perfil perfil)  {
		this.usuario = usuario;
		this.perfil=perfil;
		taskQueue = ApplicationInstance.getActive().createTaskQueue();
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
		
		List<Object> list=ConsultasCaballero.getContrincantes(usuario);

		hld = new HtmlLayoutData("panel");
		Column col = new Column();
		
		if(list.size()==0)
		 {	
			 final WindowPane windowPane=new WindowPane();
			 windowPane.setTitle("Sin Contrincantes!!");
			 windowPane.setClosable(false);
			 windowPane.setMovable(false);
			 windowPane.setModal(true);
			 windowPane.setOpenAnimationTime(1);
			 windowPane.setCloseAnimationTime(1);
			 windowPane.setResizable(false);
			  lbl=new Label();
			 lbl.setText("Usted no tiene contricantes de su mismo nivel o superior");
			 
			 col.add(lbl);
			 
			
			 lbl.setForeground(Color.BLUE);
			 lbl.setText("Sera redireccionado a su Perfil en 3 seg");
			 col.add(lbl);
			 
			 Button btnOK = new Button("No esperar mas");
			 btnOK.setAlignment(new Alignment(Alignment.LEFT, Alignment.LEFT));
			 btnOK.setInsets(new Insets(10));
			 btnOK.setStyle(GUIStyles.DEFAULT_STYLE);
			 btnOK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					windowPane.userClose();
					timedServerPush.end();
					((MainApp) ApplicationInstance.getActive()).startPerfil(usuario);
					
				}
			});
			 col.add(btnOK);
			 windowPane.add(col);
			perfil.add(windowPane);
			
			 timedServerPush = new TimedServerPush(1000,ApplicationInstance.getActive(), taskQueue, new Runnable() {
			      @Override
			      public void run() {
			    	  time--;
			    	  lbl.setText("Sera redireccionado a su Perfil en "+Integer.toString(time)+" seg");
			    	 
			    	  if(time==-1)
			    	  {
			    		  timedServerPush.end();
			    		  ((MainApp) ApplicationInstance.getActive()).startPerfil(usuario);
			    	  }
			      }
			    });

			 	timedServerPush.beg();
			 
		 }
		
		else
		{
			TablaContrincantes tabla =new TablaContrincantes(perfil, usuario);
			tabla.crearTabla(list);
			col.add(tabla);
			col.add(tabla.getPaginacion());
			col.setLayoutData(hld);
			htmlLayout.add(col);
			add(htmlLayout);
		}
	
	}
	
}