package gui;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;

/**
 * @author Anna Lezama
 */

public class MainApp extends ApplicationInstance {

  public Window init() {
    Window window = new Window();
    window.setTitle("Greed Treasure by Thinking&Looking");

    ContentPane contentPane = new ContentPane();
    contentPane.add(new Welcome());

    window.setContent(contentPane);

    return window;
  }
}
