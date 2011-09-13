package tabla;


	import nextapp.echo.app.ApplicationInstance;
	import nextapp.echo.webcontainer.WebContainerServlet;

	public class ArmaServlet extends WebContainerServlet {

	  @Override
	  public ApplicationInstance newApplicationInstance() {
	    return new ArmaApp();
	  }
	}

	
