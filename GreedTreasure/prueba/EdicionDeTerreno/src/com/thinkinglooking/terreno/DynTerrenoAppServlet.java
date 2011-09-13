package com.thinkinglooking.terreno;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.webcontainer.WebContainerServlet;

/**
 * @author Jonathan Monsalve
 * <br> Created on jun 6, 2011
 */
public class DynTerrenoAppServlet extends WebContainerServlet {

  @Override
  public ApplicationInstance newApplicationInstance() {
    return new DynTerrenoApp();
  }
}
