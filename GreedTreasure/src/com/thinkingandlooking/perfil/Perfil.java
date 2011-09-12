package com.thinkingandlooking.perfil;


import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.database.*;
import com.thinkingandlooking.paneles.mostrarusuario.ShowAccount;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;



public class Perfil extends ContentPane {

	private User user;
	private HtmlLayout htmlLayout;
	

	public Perfil(User user) {
		this.user = user;
		initGUI();
	}

	private void initGUI() {
		try {
			htmlLayout = new HtmlLayout( 
					getClass().getResourceAsStream("Perfil.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		
		
		HtmlLayoutData hld;

		hld = new HtmlLayoutData("buttons_top");
		ButtonTop buttonTop= new ButtonTop(user, this);
		buttonTop.setLayoutData(hld);
		htmlLayout.add(buttonTop);
		
		hld = new HtmlLayoutData("buttons_left");
		ButtonLeft buttonLeft = new ButtonLeft(user, this);
		buttonLeft.setLayoutData(hld);
		htmlLayout.add(buttonLeft);
		
		
		ShowRecord showrecord = new ShowRecord(user);
		Start start = new Start(user);
		
		ambos(showrecord,start);

		add(htmlLayout);
		
	
	}

	
	
	ActionListener listenerError = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			listenerErrorPerformed(evt);
		}
	};

	private void listenerErrorPerformed(ActionEvent evt) {
		WindowPane win = (WindowPane) evt.getSource();
		add(win);
	}
	
	ActionListener listenerOk = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			listenerOkPerformed(evt);
		}
	};

	private void listenerOkPerformed(ActionEvent evt) {
		ShowAccount showAccount = new ShowAccount(user);
		updatePanel(showAccount);
		WindowPane win = (WindowPane) evt.getSource();
		add(win);
	}
	
	
	public ActionListener getListenerError()
	{
		return listenerError;
	}
	
	public ActionListener getListenerOk()
	{
		return listenerOk;
	}
	
	public void ambos(Panel panel1,Panel panel2) {
		
		Panel ambos=new Panel();
		Column col=new Column();
		col.add(panel1);
		col.add(panel2);
		ambos.add(col);
		updatePanel(ambos);
	}

	
	public void updatePanel(Panel panel) {
		panel.setId("panel");

		HtmlLayoutData hld = new HtmlLayoutData("panel");
		panel.setLayoutData(hld);
        
		
		htmlLayout.remove(htmlLayout.getComponent("panel"));
		
		htmlLayout.add(panel);
		
	}

}
