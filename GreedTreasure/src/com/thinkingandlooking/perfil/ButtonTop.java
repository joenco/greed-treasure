package com.thinkingandlooking.perfil;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.thinkingandlooking.database.*;
import com.thinkingandlooking.main.MainApp;
import com.thinkingandlooking.paneles.modificarcuenta.ModifiedAccount;
import com.thinkingandlooking.paneles.mostrarusuario.*;


public class ButtonTop extends Row {

	private Usuario usuario;
	private Perfil perfil;
	
	public ButtonTop(Usuario usuario, Perfil perfil) {
		
		this.usuario=usuario;
		this.perfil=perfil;
		
		setCellSpacing(new Extent(5));

		Button btnStart = new Button("Inicio");
		btnStart.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnStart.setBackground(new Color(117, 145, 118));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//btnStartClicked();
			}
		});

		add(btnStart);

		Button btnShowAccount = new Button("Ver Perfil");
		btnShowAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnShowAccount.setBackground(new Color(117, 145, 118));
		btnShowAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//btnShowAccountClicked();
			}
		});

		add(btnShowAccount);

		Button btnModifiedAccount = new Button("Modificar Perfil");
		btnModifiedAccount.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnModifiedAccount.setBackground(new Color(117, 145, 118));
		btnModifiedAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnModifiedAccountClicked();
			}
		});

		add(btnModifiedAccount);

		Button btnHistorialDiario = new Button("Ataques de hoy");
		btnHistorialDiario.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnHistorialDiario.setBackground(new Color(117, 145, 118));
		btnHistorialDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHistorialDiarioClicked();
			}
		});

		add(btnHistorialDiario);

		Button btnHistorialGlobal = new Button("Historial de ataques");
		btnHistorialGlobal.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnHistorialGlobal.setBackground(new Color(117, 145, 118));
		btnHistorialGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnHistorialGlobalClicked();
			}
		});

		add(btnHistorialGlobal);

		Button btnLogOut = new Button("Salir");
		btnLogOut.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnLogOut.setBackground(new Color(117, 145, 118));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLogOutClicked();
			}
		});

		add(btnLogOut);

		
	}
	
	private void btnStartClicked() {
		Start start = new Start(usuario);
		ShowRecord showrecord = new ShowRecord(usuario);
		
		perfil.ambos(showrecord,start);
	}

	private void btnLogOutClicked() {
		
		((MainApp) ApplicationInstance.getActive() ).startWelcome();
	}
	

	private void btnModifiedAccountClicked() {
		ModifiedAccount modifiedAccount = new ModifiedAccount(usuario);
		ShowRecord showrecord = new ShowRecord(usuario);
		modifiedAccount.getActionListenerProxyError().addActionListener(perfil.getListenerError());
		modifiedAccount.getActionListenerProxyOk().addActionListener(perfil.getListenerOk());
		perfil.updatePanel(modifiedAccount);
	}
	
	private void btnShowAccountClicked() {
		
		ShowRecord showRecord = new ShowRecord(usuario);
		ShowAccount showAccount = new ShowAccount(usuario);
		perfil.ambos(showAccount,showRecord);
		
	}
	
	private void btnHistorialDiarioClicked() {
		ShowRecord showrecord = new ShowRecord(usuario);
		perfil.updatePanel(showrecord);
		
	}

	private void btnHistorialGlobalClicked() {
		ShowRecord showrecord = new ShowRecord(usuario);
		perfil.updatePanel(showrecord);
		
	}
}
