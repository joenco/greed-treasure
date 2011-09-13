package tabla;

import java.util.List;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
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

public class ArmaTerreno extends ContentPane {

	private TestTableModel tableDtaModel;
	Label label = new Label("Nothing Selected");
	private TextField txtFrst;
	private TextField txtLast;
	// private ImageReference ir = new
	// ResourceImageReference("com/tutorial/table/Gallina.gif");
	private Button btnCreate;
	private Button btnUpdate;

	private int editingRow;

	// --------------------------------------------------------------------------------

	public ArmaTerreno() {
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		setInsets(new Insets(8, 8, 8, 8));

		Grid col = new Grid(1);
		add(col);

		// col.add(initTopRow());

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
		// tableColumn = new TableColumn() {
		// @Override
		// public Object getValue(ETable table, Object element) {
		// PersonBean personaBean = (PersonBean) element;
		// return personaBean.getFrstName();
		// }
		// };
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ArmaBean armasBean = (ArmaBean) element;

				// return new
				// ResourceImageReference(personaBean.getImageName());
				System.err.println(armasBean.getImageName());
				return ImageReferenceCache.getInstance().getImageReference(
						armasBean.getImageName());
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("IMAGEN");

		lcr = new LabelCellRenderer();
		lcr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		lcr.setBackground(Color.BLUE);
		lcr.setForeground(Color.WHITE);
		tableColumn.setHeadCellRenderer(lcr);

		ImageCellRenderer icr = new ImageCellRenderer();
		icr.setAlignment(new Alignment( //
				Alignment.CENTER, Alignment.DEFAULT));

		tableColumn.setDataCellRenderer(icr);
		tableColModel.getTableColumnList().add(tableColumn);
		// **********************************************************************************
		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getLastName();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("NOMBRE");

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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getAtaque();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("ATAQUE");
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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getDefensa();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("DEFENSA");

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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getAlcance();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("ALCANCE");

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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getNum_Armas();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("NUM ARMAS");

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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getMuniciones();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("MUNICIONES");

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
				ArmaBean armasBean = (ArmaBean) element;
				return armasBean.getOro();
			}
		};
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("ORO");

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

				Button ret = new Button("USAR");
				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setToolTipText("USAR");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnEdtClicked(table, row);
					}
				});
				return ret;
			}
		});

		// ---------------------------------------------comienza---------------------------------------------

		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(final ETable table,
					final Object value, final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				Button ret = new Button("VENDER");
				ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setToolTipText("VENDER");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnDelClicked(table, row);
					}
				});
				return ret;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnEdtClicked(ETable table, int row) {
		TableDtaModel model = table.getTableDtaModel();

		ArmaBean ArmaBean = (ArmaBean) model.getElementAt(row);

		ArmaBean.setNum_Armas(ArmaBean.getNum_Armas() - 1);
		model.getTableDtaModelEvtProxy().fireActionEvent(
				new TableDtaModelEvent(model));

		if (ArmaBean.getNum_Armas() == 0)
			tableDtaModel.del(tableDtaModel.getElementAt(row));
	}

	// --------------------------------------------------------------------------------

	private void btnDelClicked(ETable table, int row) {

		TableDtaModel model = table.getTableDtaModel();
		ArmaBean armaBean = (ArmaBean) model.getElementAt(row);
		inputWindow inputWindow = new inputWindow(armaBean);
		add(inputWindow);

	}

	// --------------------------------------------------------------------------------

	private void btnCreateClicked() {
		ArmaBean armaBean = new ArmaBean();

		armaBean.setFrstName(txtFrst.getText());
		armaBean.setLastName(txtLast.getText());

		tableDtaModel.add(armaBean);
	}

	// --------------------------------------------------------------------------------

	private void btnUpdateClicked() {
		ArmaBean armaBean = (ArmaBean) tableDtaModel.getElementAt(editingRow);
		armaBean.setFrstName(txtFrst.getText());
		armaBean.setLastName(txtLast.getText());

		tableDtaModel.setEditable(true);

		btnCreate.setEnabled(true);
		btnUpdate.setEnabled(false);

		tableDtaModel.currPageChanged();
	}

	public void crear_tabla() {
		 List<ArmaBean> armasBeanList = ArmaBeanLoader.loadData();
		 for (ArmaBean armasBean : armasBeanList) {

		 tableDtaModel.add(armasBean);
	}
	
  }
}