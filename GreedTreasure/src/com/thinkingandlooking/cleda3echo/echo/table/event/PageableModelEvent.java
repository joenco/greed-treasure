/*
 * Created on 22/09/2008
 */
package com.thinkingandlooking.cleda3echo.echo.table.event;

import java.util.EventObject;

import com.thinkingandlooking.cleda3echo.echo.table.base.PageableModel;

/**
 * @author Demián Gutierrez
 */
public class PageableModelEvent extends EventObject {

  public PageableModelEvent(PageableModel source) {
    super(source);
  }
}
