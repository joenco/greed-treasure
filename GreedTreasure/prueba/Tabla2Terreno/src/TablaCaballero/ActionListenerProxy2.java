package TablaCaballero;


	import java.util.EventListener;

	import nextapp.echo.app.event.ActionEvent;
	import nextapp.echo.app.event.ActionListener;
	import nextapp.echo.app.event.EventListenerList;


	public class ActionListenerProxy2 {

	  protected EventListenerList eventListenerList;

	  // --------------------------------------------------------------------------------

	  public ActionListenerProxy2(EventListenerList eventListenerList) {
	    this.eventListenerList = eventListenerList;
	  }

	  // --------------------------------------------------------------------------------

	  public void addActionListener(ActionListener listener) {
	    eventListenerList.addListener(ActionListener.class, listener);
	  }

	  public void delActionListener(ActionListener listener) {
	    eventListenerList.removeListener(ActionListener.class, listener);
	  }

	  public EventListener[] getActionListener() {
	    return eventListenerList.getListeners(ActionListener.class);
	  }

	  public void fireActionEvent(ActionEvent evt) {
	    EventListener[] eventListeners = getActionListener();

	    for (int i = 0; i < eventListeners.length; i++) {
	      ActionListener listener = (ActionListener) eventListeners[i];
	      listener.actionPerformed(evt);
	    }
	  }
	}


