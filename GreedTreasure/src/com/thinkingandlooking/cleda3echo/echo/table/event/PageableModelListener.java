/*
 * Created on 22/09/2008
 */
package com.thinkingandlooking.cleda3echo.echo.table.event;

import java.util.EventListener;

/**
 * @author Demián Gutierrez
 */
public interface PageableModelListener extends EventListener {

  public void pageChanged(PageableModelEvent evt);
}
