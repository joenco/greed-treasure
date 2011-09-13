package com.thinkingandlooking.paneles.edicioncaballero;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Grid;
import nextapp.echo.app.HttpImageReference;
import nextapp.echo.app.ImageReference;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.Window;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import echopoint.ImageMap;
import echopoint.model.RectangleSection;

public class EditarCaballeroApp extends Panel {

	private Label lblSelected;
	private ImageMap imageMap;
	private Column col;
	private String armaId;
	private boolean bandera = false;
	HttpImageReference ir;
	
	public EditarCaballeroApp(){
		initGUI();
	}
	

	// --------------------------------------------------------------------------------

	private void initGUI() {
		
		col = new Column();
		col.setCellSpacing(new Extent(5));
		add(col);
	
		
		ir = new HttpImageReference("caballerodyn?idArma=&idPos=");
		
		lblSelected = new Label("POSICION O ARMA");
		imageMap = new ImageMap(ir);
		
		imageMap.setWidth(new Extent(400));
		imageMap.setHeight(new Extent(400));
		col.add(imageMap);
		loadSeccion();
        imageMap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				lblSelected.setText(evt.getActionCommand());
				System.out.println(armaId.concat(" este es"));
				if (bandera == true)
					Pintar();	
				
			}
		});
		
		
		
		
		
		
		col.add(lblSelected);
		
		
		Grid grid = new Grid(3);
		col.add(grid);
		ImageReference ir1 = new ResourceImageReference(
				"com/thinkingandlooking/paneles/edicioncaballero/difusal.png");
		Label label1 = new Label(ir1);
		Label label11 = new Label("Difusal");
		grid.add(label1);
		grid.add(label11);
		Button btnUse1 = new Button("Use");
		btnUse1.setStyle(GUIStyles.DEFAULT_STYLE);
		btnUse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUse1Clicked();
			}
		});
		grid.add(btnUse1);
		
		ImageReference ir2 = new ResourceImageReference(
				"com/thinkingandlooking/paneles/edicioncaballero/sange.png");
		Label label2 = new Label(ir2);
		Label label22 = new Label("Sange");
		grid.add(label2);
		grid.add(label22);
		
		Button btnUse2 = new Button("Use");
		btnUse2.setStyle(GUIStyles.DEFAULT_STYLE);
		btnUse2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnUse2Clicked();
			}
		});
		grid.add(btnUse2);
				ImageReference ir3 = new ResourceImageReference(
				"com/thinkingandlooking/paneles/edicioncaballero/yasha.png");
		Label label3 = new Label(ir3);
		Label label33 = new Label("Yasha");
		grid.add(label3);
		grid.add(label33);

		Button btnUse3 = new Button("Use");
		btnUse3.setStyle(GUIStyles.DEFAULT_STYLE);
		btnUse3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnUse3Clicked();
			}
		});
		grid.add(btnUse3);
		
		ImageReference ir4 = new ResourceImageReference(
				"com/thinkingandlooking/paneles/edicioncaballero/maeltron.png");
		Label label4 = new Label(ir4);
 		Label label44 = new Label("Malestron");
		grid.add(label4);
		grid.add(label44);

		Button btnUse4 = new Button("Use");
		btnUse4.setStyle(GUIStyles.DEFAULT_STYLE);
		btnUse4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnUse4Clicked();
			}
		});
		grid.add(btnUse4);
		
	}

	
	private void btnUse1Clicked() {
		armaId= "difusal";
		bandera = true;
	}
	
	private void btnUse2Clicked() {
		armaId = "sange";
		bandera = true;
	}
	

	private void btnUse3Clicked() {
		armaId = "yasha";
		bandera = true;
	}
	
	private void btnUse4Clicked() {
		armaId = "maeltron";
		bandera = true;
	}
	
	
	
protected void Pintar() {
		
		ir = new HttpImageReference("caballerodyn?idArma=" + armaId+"&idPos="+ lblSelected.getText());
	    imageMap.removeAllSections();
		col.remove(imageMap);
		imageMap.setImage(ir);
		loadSeccion();
		col.add(imageMap,0);
	}
	

	private void loadSeccion() {
		imageMap.addSection(new RectangleSection(175, 75, 225, 25, "CABEZA"));
		imageMap.addSection(new RectangleSection(75, 225, 125, 175,
				"ManoIzquierda"));
		imageMap.addSection(new RectangleSection(325, 225, 375, 175,
				"ManoDerecha"));
		imageMap.addSection(new RectangleSection(175, 225, 225, 175, "Torso"));
	}
}