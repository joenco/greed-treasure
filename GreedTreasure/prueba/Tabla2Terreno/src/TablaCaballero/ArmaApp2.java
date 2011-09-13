package TablaCaballero;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Font;
import nextapp.echo.app.Window;



	public class ArmaApp2 extends ApplicationInstance {

	  public Window init() {
	    Window window = new Window();
	    window.setTitle("Tabla de Armas Caballero");

	    ArmaCaballero desktop = new ArmaCaballero();
	    	//window.setContent(desktop);
	   

	    return window;
	  } 
	
}



