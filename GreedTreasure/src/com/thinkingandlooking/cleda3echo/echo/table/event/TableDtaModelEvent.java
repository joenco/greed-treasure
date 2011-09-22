/*
 * Created on 22/09/2008
 */
package com.thinkingandlooking.cleda3echo.echo.table.event;

import java.util.EventObject;

import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;

/**
 * @author Demián Gutierrez
 */
public class TableDtaModelEvent extends EventObject {

  public TableDtaModelEvent(TableDtaModel source) {
    super(source);
  }
}
