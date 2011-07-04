package TablaCaballero;

import nextapp.echo.app.Button;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;
import nextapp.echo.app.list.ListModel;

public class inputWindow2 extends WindowPane {

private static final ListModel List = null;
  private EventListenerList eventListenerList = new EventListenerList();

  private ActionListenerProxy2 actionListenerProxy = //
  new ActionListenerProxy2(eventListenerList);

  private TextField txtName;
private Object componentsDefault;
private Component sf;


  // --------------------------------------------------------------------------------

  public inputWindow2(ArmaBean2 personBean) {
    setTitle("Vender Armas");
    setInsets(new Insets(10, 10, 10, 10));
    initGUI(personBean);
}

  // --------------------------------------------------------------------------------

  private void initGUI(ArmaBean2 personBean) {

    // ----------------------------------------
    // Layout stuff
    // ----------------------------------------

    Grid grid = new Grid(2);
    add(grid);

    

	//PersonBean personBean = (PersonBean) model.getElementAt(row);

		    
//   TableDtaModel model = table.getTableDtaModel();
  //  table.getStyleName();

//	PersonBean personBean = (PersonBean)  model.getElementAt(row);
//model.getTableDtaModelEvtProxy().fireActionEvent
	//	new TableDtaModelEvent(model));

    
    
    
    Label label1 = new Label("Nombre:"+ personBean.getLastName());
    grid.add(label1);
    
   
    
	Label label = new Label("Monto de Venta:"+ Integer.toString(personBean.getOro()));
    grid.add(label);

    Label label2 = new Label("Precio:"+ Integer.toString(personBean.getOro()));
    grid.add(label2);
    
    
//    this.componentsDefault.SelectField sf = new SelectField({
//    	styleName:"Default",
//    	width:"100%",
//    	items: listItems
//    });
    
//    ListModel a
    
    Row rowField = new Row();
    grid.add(rowField);
    
	grid.add(sf);

//    sf.setIndex(|, propertyIndex, newValue)

    
    //txtName = new TextField();
    //rowField.add(txtName);
//EL BOTON BORRAR
//    Button btnClear = new Button("Clear");
//    btnClear.setStyle(GUIStyles.DEFAULT_STYLE);
//    btnClear.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent evt) {
//        btnClearClicked(evt);
//      }
//    });
//    rowField.add(btnClear);

    Row rowCommand = new Row();
    rowCommand.setCellSpacing(new Extent(5, Extent.PX));
    rowCommand.setInsets(new Insets(0, 5, 0, 0));
    grid.add(rowCommand);
    
    
    
	
    
    
    Button btnOK = new Button("OK");
    btnOK.setStyle(GUIStyles2.DEFAULT_STYLE);
    btnOK.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnOKClicked(evt);
      }
    });
    rowCommand.add(btnOK);

    Button btnCancel = new Button("Cancelar");
    btnCancel.setStyle(GUIStyles2.DEFAULT_STYLE);
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnCancelClicked(evt);
      }
    });
    rowCommand.add(btnCancel);
  }

  protected void btnOKClicked(ActionEvent evt) {
    actionListenerProxy.fireActionEvent(new ActionEvent(this, null));
    userClose();
  }

  protected void btnCancelClicked(ActionEvent evt) {
    userClose();
  }

  private void btnClearClicked(ActionEvent e) {
    txtName.setText("");
  }

  // --------------------------------------------------------------------------------
//
  public ActionListenerProxy2 getActionListenerProxy() {
    return actionListenerProxy;
  }

  // --------------------------------------------------------------------------------

  public String getName() {
    return txtName.getText();
  }
}

