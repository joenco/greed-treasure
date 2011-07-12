package tablaEnemigo;

import java.util.List;
import usuario.ActionListenerProxy;
import usuario.GUIStyles;
import org.hibernate.Session;
import db.SessionHibernate;
import db.User;
import org.hibernate.criterion.Restrictions;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableDtaModel;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.event.TableDtaModelEvent;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.ImageCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;

public class TablaEnemigo extends Panel {

	private TestTableModel tableDtaModel;
	private User user;
	Label label = new Label("Nothing Selected");
	private TextField txtFrst;
	private TextField txtLast;
	private Button btnCreate;
	private Button btnUpdate;

	private int editingRow;

	// --------------------------------------------------------------------------------

	public TablaEnemigo(User user) {
		this.user = user;
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		user = (User) session.load(User.class, user.getId());
		session.getTransaction().commit();
		session.close();
		setInsets(new Insets(8, 8, 8, 8));

		Grid col = new Grid(1);
		add(col);

		// ----------------------------------------
		// Los modelos de la tabla
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(6);

		// ----------------------------------------
		// La Tabla
		// ----------------------------------------

		ETable table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);

		table.setEasyview(true);

		table.setBorder(new Border(1, Color.GREEN, Border.STYLE_NONE));
		table.setInsets(new Insets(30, 20, 50, 20));
		col.add(table);

		// ----------------------------------------
		// El control de la navegación
		// ----------------------------------------

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		col.add(tableNavigation);
		crear_tabla();

		col.add(label);
	}

	// --------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;
		LabelCellRenderer lcr;
		// **********************************************************************************

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				EnemigoBean enemigoBean = (EnemigoBean) element;
				return enemigoBean.getNick();
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
				EnemigoBean armasBean = (EnemigoBean) element;
				return armasBean.getNivel();
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
				EnemigoBean armasBean = (EnemigoBean) element;
				return armasBean.getVictoria();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Victorias");
//Las columnas 
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
				EnemigoBean armasBean = (EnemigoBean) element;
				return armasBean.getDerrota();
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
						btnAtkClicked();
					}
				});
				return ret;
			}
		});
		// ---------------------------------------------comienza---------------------------------------------
		return nestedCellRenderer;
	}
	

	// --------------------------------------------------------------------------------

	private void btnAtkClicked() { }

	// --------------------------------------------------------------------------------

	private void btnUpdateClicked() {
		EnemigoBean enemigoBean = (EnemigoBean) tableDtaModel.getElementAt(editingRow);
		enemigoBean.setNick(txtFrst.getText());

		tableDtaModel.setEditable(true);

		btnCreate.setEnabled(true);
		btnUpdate.setEnabled(false);

		tableDtaModel.currPageChanged();
	}

	public void crear_tabla() {
		 List<EnemigoBean> armasBeanList = EnemigoBeanLoader.loadData();
		 for (EnemigoBean armasBean : armasBeanList) {
			 if ((armasBean.getNivel()-user.getNivel()) > -3) {
				 tableDtaModel.add(armasBean);
			 }
	}
	
  }
}