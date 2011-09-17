package com.thinkingandlooking.perfil;


import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.Window;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.TabPane;

import com.thinkingandlooking.database.*;
import com.thinkingandlooking.paneles.mostrarusuario.ShowAccount;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;



public class Perfil extends ContentPane {

	private Usuario usuario;
	private HtmlLayout htmlLayout;
	

	public Perfil(Usuario usuario) {
		this.usuario = usuario;
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
		ButtonTop buttonTop= new ButtonTop(usuario, this);
		buttonTop.setLayoutData(hld);
		htmlLayout.add(buttonTop);
			
		hld = new HtmlLayoutData("buttons_left");
		ButtonLeft buttonLeft = new ButtonLeft(usuario, this);
		buttonLeft.setCellSpacing(getHorizontalScroll());
		buttonLeft.setLayoutData(hld);
		htmlLayout.add(buttonLeft);
		
		
		
		ShowRecord showrecord = new ShowRecord(usuario);
		Start start = new Start(usuario);
		
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
		ShowAccount showAccount = new ShowAccount(usuario);
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
	
	public void updatePanel( ContentPane contentpane) {
	
		Panel panel=new Panel();
		panel.add(contentpane);
		panel.setHeight(new Extent(450));
		updatePanel(panel);
		
	}


}
