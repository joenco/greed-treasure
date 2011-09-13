package com.thinkingandlooking.main;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Window;
import com.thinkingandlooking.welcome.*;
import com.thinkingandlooking.paneles.elegirterreno.Terrenos;
import com.thinkingandlooking.perfil.*;
import com.thinkingandlooking.recuperarpass.Passwd;
import com.thinkingandlooking.recuperarpass.RecuperarPass;
import com.thinkingandlooking.registrousuario.CreateAccount;
import com.thinkingandlooking.database.*;
import com.thinkingandlooking.elegircaballero.EleccionCaballeros;



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
public void startPerfil(Usuario usuario) {
	
	window.setContent(new Perfil(usuario));
	
}

public void startCreateAccount() {
	
	window.setContent(new CreateAccount());
}

public void startRecuperarPass()
{
	window.setContent(new RecuperarPass());
}

public void mostrarInfoPass(Usuario usuario)
{
	window.setContent(new Passwd(usuario));
}

public void startElegirCaballero(Usuario usuario)
{
	window.setContent(new EleccionCaballeros(usuario));
}

public void startElegirTerreno(Usuario usuario)
{
	window.setContent(new Terrenos(usuario));
}


}
