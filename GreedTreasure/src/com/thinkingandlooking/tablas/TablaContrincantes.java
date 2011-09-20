package com.thinkingandlooking.tablas;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.thinkingandlooking.cleda3echo.echo.table.base.ETable;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColModel;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableColumn;
import com.thinkingandlooking.cleda3echo.echo.table.base.TableDtaModel;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.BaseCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.LabelCellRenderer;
import com.thinkingandlooking.cleda3echo.echo.table.renderer.NestedCellRenderer;
import com.thinkingandlooking.utils.GUIStyles;
import com.thinkingandlooking.paneles.ataque.AtacarTerreno;
import com.thinkingandlooking.perfil.Perfil;
import com.thinkingandlooking.database.*;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


public class TablaContrincantes extends Tabla {


	private Usuario usuario;
	Perfil perfil;
	

	// --------------------------------------------------------------------------------

	public TablaContrincantes( Perfil perfil, Usuario usuario) {
		super();
		this.usuario = usuario;
		this.perfil=perfil;
	
	}

	
	// --------------------------------------------------------------------------------

	public TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				return caballero.getUsuario().getLogin();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Enemigo");

		lcr = new LabelCellRenderer();
    	lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
			Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				return caballero.getNivel();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Nivel");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
    	lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				int victorias=0;
				Session session = SessionHibernate.getInstance().openSession();
				session.beginTransaction();
				String str = "FROM Ataque WHERE atacanteRef=:att_id OR atacadoRef=:att_id";
				Query query = session.createQuery(str);
				query.setInteger("att_id", caballero.getId());
				
				
				for (Object obj : query.list()) {
					Ataque ataque = (Ataque) obj;
					if((ataque.getAtacanteRef().getId()== caballero.getId()) && ataque.isGanador())
						victorias++;
					else if ((ataque.getAtacadoRef().getId()== caballero.getId()) && !ataque.isGanador())
						victorias++;
				}
				session.getTransaction().commit();
			    session.close();
				return victorias ;
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Victorias");

		lcr = new LabelCellRenderer();
	
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
			Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				
				Caballero caballero= (Caballero) element;
				int derrota=0;
				Session session = SessionHibernate.getInstance().openSession();
				session.beginTransaction();
				String str = "FROM Ataque WHERE atacanteRef=:att_id OR atacadoRef=:att_id";
				Query query = session.createQuery(str);
				query.setInteger("att_id", caballero.getId());
				
				
				for (Object obj : query.list()) {
					Ataque ataque = (Ataque) obj;
					if((ataque.getAtacanteRef().getId()== caballero.getId()) && !ataque.isGanador())
						derrota++;
					
					else if ((ataque.getAtacadoRef().getId()== caballero.getId()) && ataque.isGanador())
						derrota++;
				}
				session.getTransaction().commit();
			    session.close();
		
				return derrota;
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Derrotas");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setHeadCellRenderer(lcr);

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));
		tableColumn.setDataCellRenderer(lcr);
		tableColModel.getTableColumnList().add(tableColumn);
		// *******************************************************************
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Actions");

		lcr = new LabelCellRenderer();
		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	// --------------------------------------------------------------------------------
	// Configuración de la barra de comandos de render
	// --------------------------------------------------------------------------------

	private NestedCellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.setAlignment(new Alignment(Alignment.CENTER,
				Alignment.DEFAULT));

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				Button ret = new Button("ATACAR");
				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setToolTipText("Atacar jugador");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAtkClicked(table, row);
					}
				});
				return ret;
			}
		});
		// ---------------------------------------------comienza---------------------------------------------
		return nestedCellRenderer;
	}
	

	// --------------------------------------------------------------------------------

	private void btnAtkClicked(ETable table, int row) {
		TableDtaModel model = table.getTableDtaModel();
		Caballero usuarioContrincante = (Caballero) model.getElementAt(row);
		AtacarTerreno atacarEnemigo = new AtacarTerreno(usuario.getId(),usuarioContrincante.getId() );
		perfil.updatePanel(atacarEnemigo);
	
	}
	// --------------------------------------------------------------------------------


	public void crearTabla(List<Object> list) {
		
			for (Object obj : list) {
				Caballero caballero= (Caballero) obj;
				tableDtaModel.add(caballero);
			}
			
	}
}


