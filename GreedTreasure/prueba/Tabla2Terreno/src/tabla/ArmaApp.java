package tabla;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;



	public class ArmaApp extends ApplicationInstance {

	  public Window init() {
	    Window window = new Window();
	    window.setTitle("Tabla de Armas");

	    ArmaTerreno desktop = new ArmaTerreno();
	    	window.setContent(desktop);
	   

	    return window;
	  }
	
}
