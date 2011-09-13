package table;

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
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.ButtonCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;

import echopoint.model.CircleSection;

public class Desktop extends ContentPane {

  private TestTableModel tableDtaModel;

  private TextField txtFrst;
  private TextField txtLast;

  //private Button btnCreate;
  //private Button btnUpdate;

  private int editingRow;

  // --------------------------------------------------------------------------------

  public Desktop() {
    initGUI();
  }

  // --------------------------------------------------------------------------------

  private void initGUI() {
    setInsets(new Insets(10, 10, 10, 10));

    Grid col = new Grid(5);
    add(col);

  //  col.add(initTopRow());

    // ----------------------------------------
    //MODELOS DE TABLA
    // ----------------------------------------

    TableColModel tableColModel = initTableColModel();
    TableSelModel tableSelModel = new TableSelModel();

    tableDtaModel = new TestTableModel();
    tableDtaModel.setEditable(true);
    tableDtaModel.setPageSize(5);
    
    // ----------------------------------------
    // LA TABLA
    // ----------------------------------------
    
    
    ETable table = new ETable();
    table.setTableDtaModel(tableDtaModel);
    table.setTableColModel(tableColModel);
    table.setTableSelModel(tableSelModel);

    table.setEasyview(true);

    table.setBorder(new Border(1, Color.RED, Border.STYLE_NONE));
    table.setInsets(new Insets(50, 20, 50, 20));
    col.add(table);

    // ----------------------------------------
    // EL CONTROL DE LA NAVEGACION
    // ----------------------------------------

    ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
    col.add(tableNavigation);
    crear_tabla();
  }

  // --------------------------------------------------------------------------------

  /*private Row initTopRow() {
    Row row = new Row();
    row.setCellSpacing(new Extent(5));

    row.add(new Label("NOMBRE DEL ARMA:"));
    txtFrst = new TextField();
    row.add(txtFrst);

    row.add(new Label("TIPO DE ARMA:"));
    txtLast = new TextField();
    row.add(txtLast);
    
    row.add(new Label("ORO:"));
    txtLast = new TextField();
    row.add(txtLast);
    
    btnCreate = new Button("Crear");
    btnCreate.setStyle(GUIStyles.DEFAULT_STYLE);
    btnCreate.addActionListener(new ActionListener() {
      
    	public void actionPerformed(ActionEvent evt) {
        btnCreateClicked();
      }
    });
    row.add(btnCreate);

    btnUpdate = new Button("Update");
    btnUpdate.setStyle(GUIStyles.DEFAULT_STYLE);
    btnUpdate.setEnabled(false);
    btnUpdate.addActionListener(new ActionListener() {
      
    	public void actionPerformed(ActionEvent evt) {
        btnUpdateClicked();
      }
    });
    row.add(btnUpdate);

    return row;
  }  */

  // --------------------------------------------------------------------------------

  private TableColModel initTableColModel() {
    TableColModel tableColModel = new TableColModel();

    TableColumn tableColumn;
    LabelCellRenderer lcr;

    tableColumn = new TableColumn();
//{
//      @Override
//      public Object getValue(ETable table, Object element) {
//        ArmasBean ArmasBean = (ArmasBean) element;
//        return ArmasBean.getFrstName();
//      }
//    };
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("IMAGEN");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
    Alignment.CENTER, Alignment.DEFAULT));
    		
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    //lcr = new LabelCellRenderer();
    //lcr.setAlignment(new Alignment( //
      //  Alignment.CENTER, Alignment.DEFAULT));
    //lcr.setBackground(Color.CYAN);
    //lcr.setForeground(Color.DARKGRAY);

    tableColumn.setDataCellRenderer(lcr);
    tableColModel.getTableColumnList().add(tableColumn);

    tableColumn = new TableColumn(); 
    {
      @Override Object getValue(ETable table, Object element) {
        ArmasBean ArmasBean = (ArmasBean) element;
        return ArmasBean.getNombre();
      }
    };
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("NOMBRE");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
    Alignment.CENTER, Alignment.DEFAULT));
    
    //lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    tableColumn.setDataCellRenderer(new LabelCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);
//-------
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("ALCANCE");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
    Alignment.CENTER, Alignment.DEFAULT));
    
   // lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);
    //---------------------------------------------------- **
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("ATAQUE");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
    Alignment.CENTER, Alignment.DEFAULT));
    
    //lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);
    
//------    
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("DEFENSA");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
        Alignment.CENTER, Alignment.DEFAULT));
    
    //lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    

    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);

//------    
    
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("N° DE ARMAS");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
        Alignment.CENTER, Alignment.DEFAULT));
    
    //lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);

//-----   
    
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("CANTIDAD DE MUNICIONES");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
    Alignment.CENTER, Alignment.DEFAULT));
    
    //lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);

//-------    
     
    tableColumn = new TableColumn();
    tableColumn.setWidth(new Extent(150));
    tableColumn.setHeadValue("PRECIO");

    lcr = new LabelCellRenderer();
    lcr.setAlignment(new Alignment( //
        Alignment.CENTER, Alignment.DEFAULT));
    
 // lcr = new LabelCellRenderer();
    lcr.setBackground(Color.BLUE);
    lcr.setForeground(Color.WHITE);
    tableColumn.setHeadCellRenderer(lcr);

    
    tableColumn.setDataCellRenderer(initNestedCellRenderer());
    tableColModel.getTableColumnList().add(tableColumn);

    
//-----------------------------------------------------------------

    return tableColModel;
  }

  // --------------------------------------------------------------------------------
  // Comando de instalacion de barra
  //--------------------------------------------------------------------------------

  private NestedCellRenderer initNestedCellRenderer() {
    NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
    nestedCellRenderer.setAlignment(new Alignment( //
        Alignment.CENTER, Alignment.DEFAULT));

    nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
      @Override
      public Component getCellRenderer( //
          final ETable table, final Object value, final int col, final int row) {

        boolean editable = ((TestTableModel) table.getTableDtaModel()).getEditable();

        Button ret = new Button("USAR");
        ret.setStyle(GUIStyles.DEFAULT_STYLE);
        ret.setEnabled(editable);
        ret.setToolTipText("USAR");

        ret.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            btnDelClicked(row);
          }
        });
        return ret;
      }
    });


    ButtonCellRenderer bcr = new ButtonCellRenderer();
    bcr.setStyle(GUIStyles.DEFAULT_STYLE);
    bcr.setText("VENDER");
    bcr.setActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

        // ----------------------------------------
        // La fila viene en el comando de accion
        // ----------------------------------------

        btnDelClicked(Integer.parseInt(evt.getActionCommand()));
      }
    });
    nestedCellRenderer.getCellRendererList().add(bcr);

    return nestedCellRenderer;
  }

  // --------------------------------------------------------------------------------

//  private void btnEdtClicked(int row) {
//    ArmasBean ArmasBean = (ArmasBean) tableDtaModel.getElementAt(row);
//
//    txtFrst.setText(ArmasBean.getFrstName());
//    txtLast.setText(ArmasBean.getLastName());
//
//    tableDtaModel.setEditable(false);
//    tableDtaModel.currPageChanged();
//
//    //btnCreate.setEnabled(false);
//    //btnUpdate.setEnabled(true);
//
//    editingRow = row;
//  }

  // --------------------------------------------------------------------------------

  private void btnDelClicked(int row) {
    tableDtaModel.del(tableDtaModel.getElementAt(row));
  }

  public void crear_tabla(){
	    List<ArmasBean> ArmasBeanList = ArmasLoader.loadData();
	    for ( ArmasBean armasBean : ArmasBeanList) {
	    	  ArmasBean armaBean = new ArmasBean();
	    	    armaBean.setNombre(armasBean.getNombre());
	    	    armaBean.setAtaque(armasBean.getAtaque());
	    	    armaBean.setDefensa(armasBean.getDefensa());
	    	    armaBean.setAlcance(armasBean.getAlcance());
	    	    armaBean.setNum_armas(armasBean.getNum_arma());
	    	    armaBean.setOro(armasBean.getOro());

	    	    tableDtaModel.add(armaBean);
	    }
  }
  
  // --------------------------------------------------------------------------------

/*  private void btnCreateClicked() {
	  ArmasBean ArmasBean = new ArmasBean();

    ArmasBean.setFrstName(txtFrst.getText());
    ArmasBean.setLastName(txtLast.getText());

    tableDtaModel.add(ArmasBean);
  }*/

  // --------------------------------------------------------------------------------
//
//  private void btnUpdateClicked() {
//    ArmasBean ArmasBean = (ArmasBean) tableDtaModel.getElementAt(editingRow);
//    ArmasBean.setFrstName(txtFrst.getText());
//    ArmasBean.setLastName(txtLast.getText());
//
//    tableDtaModel.setEditable(true);
//
//    //btnCreate.setEnabled(true);
//    //btnUpdate.setEnabled(false);
//
//    tableDtaModel.currPageChanged();
//  }
}
