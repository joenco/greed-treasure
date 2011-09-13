package usuario;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;

/**
 * @author Anna Lezama
 *  * @modificado por: Jorge Ortega
 */

public class MainApp extends ApplicationInstance {

  public Window init() {
    Window window = new Window();
    window.setTitle("Bienvenido al Juego de GREED TREASURE!");

    ContentPane contentPane = new ContentPane();
    contentPane.add(new Welcome());

    window.setContent(contentPane);

    return window;
  }
}
