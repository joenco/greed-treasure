package com.thinkingandlooking.main;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;
import com.thinkingandlooking.welcome.*;
import com.thinkingandlooking.perfil.*;
import com.thinkingandlooking.registrousuario.CreateAccount;
import com.thinkingandlooking.database.*;



public class MainApp extends ApplicationInstance {
	
  private Window window;
  
  
  public Window init() {
	  
	window = new Window();
    window.setTitle("Bienvenido al Juego de GREED TREASURE!");
    startWelcome();

    return window;
  }

public void startWelcome() {
	
	window.setContent(new Welcome());
	
}
public void startPerfil(User user) {
	
	window.setContent(new Perfil(user));
	
}

public void startCreateAccount() {
	
	window.setContent(new CreateAccount());
}

public void startRecuperarPass()
{
	window.setContent(new CreateAccount());
	
}


}
