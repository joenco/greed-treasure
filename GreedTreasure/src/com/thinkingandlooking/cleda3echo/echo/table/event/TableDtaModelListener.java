/*
 * Created on 22/09/2008
 */
package com.thinkingandlooking.cleda3echo.echo.table.event;

import java.util.EventListener;

/**
 * @author Demián Gutierrez
 */
public interface TableDtaModelListener extends EventListener {

  public void tableDtaChanged(TableDtaModelEvent evt);
}
