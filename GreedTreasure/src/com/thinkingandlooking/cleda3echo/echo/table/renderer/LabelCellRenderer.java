/*
 * Created on 22/09/2008
 */
package com.thinkingandlooking.cleda3echo.echo.table.renderer;

import nextapp.echo.app.Component;
import nextapp.echo.app.Label;

import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;

/**
 * @author Demián Gutierrez
 */
public class LabelCellRenderer extends BaseCellRenderer {

  public LabelCellRenderer() {
    // Empty
  }

  // --------------------------------------------------------------------------------

  @Override
  public Component getCellRenderer(ETable table, Object value, int col, int row) {
    Label ret = new Label();

    if (foreground != null) {
      ret.setForeground(foreground);
    }

    if (value == null) {
      ret.setText("-");
    } else {
      ret.setText(value.toString());
    }

    return ret;
  }
}
