package com.thinkingandlooking.cleda3echo.echo.table.renderer;

import nextapp.echo.app.AwtImageReference;
import nextapp.echo.app.Component;
import nextapp.echo.app.Label;

import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;

public class BufferImageCellRender extends BaseCellRenderer {

	  public BufferImageCellRender() {
	    // Empty
	  }

	  // --------------------------------------------------------------------------------

	  @Override
	  public Component getCellRenderer(ETable table, Object value, int col, int row) {
	    Label ret = new Label(( AwtImageReference)value);

	    if (foreground != null) {
	      ret.setForeground(foreground);
	    }

	    if (value == null) {
	      ret.setText("-");
	    } else {
	    	
	    //	ret.setIcon(new AwtImageReference((Image) value));
	    	
	      
	    }
	   
	    return ret;
	  }
	}
