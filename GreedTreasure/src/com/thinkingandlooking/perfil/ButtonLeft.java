package com.thinkingandlooking.perfil;

import com.thinkingandlooking.database.Usuario;
import com.thinkingandlooking.paneles.edicioncaballero.EditarCaballeroApp;
import com.thinkingandlooking.paneles.edicionterreno.DynTerrenoApp;
import com.thinkingandlooking.paneles.elegirterreno.Terrenos;
import com.thinkingandlooking.paneles.tablaenemigos.TablaEnemigo;
import com.thinkingandlooking.paneles.tablas.Tienda;
import com.thinkingandlooking.utils.GUIStyles;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.ToolTipContainer;

public class ButtonLeft  extends Column{

	   Usuario usuario;
	   Perfil perfil;

	   public ButtonLeft(Usuario usuario, Perfil perfil)  {
		
		   
		this.usuario=usuario;
		this.perfil=perfil;
		Button btnAtacarCastillo = new Button("Atacar Castillo");
		btnAtacarCastillo.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnAtacarCastillo.setBackground(new Color(117, 145, 118));
		
		ToolTipContainer ttc = new ToolTipContainer();
		
		Column col = new Column();
		col.add(new Label("AA"));
		col.add(new Label("BB"));
		col.setBackground(Color.RED);
		
		ttc.add(btnAtacarCastillo);
		ttc.add(col);
		add(ttc);
		
		btnAtacarCastillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtacarCastilloClicked();
			}
		});

		//add(btnAtacarCastillo);
		
		Button btnEditionCastillo = new Button("Editar Castillo");
		btnEditionCastillo.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnEditionCastillo.setBackground(new Color(117, 145, 118));
		btnEditionCastillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditionCastilloClicked();
			}
		});

		add(btnEditionCastillo);

		Button btnEditionCaballero = new Button("Editar Caballero");
		btnEditionCaballero.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnEditionCaballero.setBackground(new Color(117, 145, 118));
		btnEditionCaballero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEditionCaballeroClicked();
			}
		});

		add(btnEditionCaballero);

		Button btnComprarArmas = new Button("Comprar armas");
		btnComprarArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnComprarArmas.setBackground(new Color(117, 145, 118));
		btnComprarArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnComprarArmasClicked();
			}
		});

		add(btnComprarArmas);

		Button btnVenderArmas = new Button("Vender armas");
		btnVenderArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnVenderArmas.setBackground(new Color(117, 145, 118));
		btnVenderArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVenderArmasClicked();
			}
		});

		add(btnVenderArmas);
		
		Button btnInventarioArmas = new Button("Inventario de armas");
		btnInventarioArmas.setBorder(new Border(new Extent(2), Color.BLACK, 1));
		btnInventarioArmas.setBackground(new Color(117, 145, 118));
		btnInventarioArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInventarioArmasClicked();
			}
		});

	    add(btnInventarioArmas);

		
	}


		private void btnAtacarCastilloClicked() {
						
				TablaEnemigo tablaEnemigo = new TablaEnemigo(usuario,perfil);
				perfil.updatePanel(tablaEnemigo);
		}

		private void btnEditionCastilloClicked() {
			
				DynTerrenoApp terreno= new DynTerrenoApp(usuario);
				perfil.updatePanel(terreno);
		}

		private void btnEditionCaballeroClicked() {
			EditarCaballeroApp caballero=new EditarCaballeroApp(usuario);
			perfil.updatePanel(caballero);
			
		}

		private void btnComprarArmasClicked() {
			Tienda tienda= new Tienda(usuario);
			perfil.updatePanel(tienda);
			
		}
		
		private void btnVenderArmasClicked() {
			ShowRecord showrecord = new ShowRecord(usuario);
			perfil.updatePanel(showrecord);
			
		}

		private void btnInventarioArmasClicked() {
			ShowRecord showrecord = new ShowRecord(usuario);
			perfil.updatePanel(showrecord);
			
		}

		

}
