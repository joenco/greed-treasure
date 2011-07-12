package tablaEnemigo;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.event.EventListenerList;

import com.minotauro.echo.table.base.PageableModel;
import com.minotauro.echo.table.base.TableDtaModel;
import com.minotauro.echo.table.event.PageableModelEvent;
import com.minotauro.echo.table.event.PageableModelEvtProxy;
import com.minotauro.echo.table.event.TableDtaModelEvent;

// DMI: Commented code is from database table model (hibernate / query creator)
// DMI: this is adapted to be in memory only table model
public class TestTableModel extends TableDtaModel implements PageableModel {

  protected PageableModelEvtProxy pageableModelEvtProxy = //
  new PageableModelEvtProxy(new EventListenerList());

  //  protected Map<String, Object> queryParameterMap;

  protected List<Object> dataList = //
  new ArrayList<Object>();

  //  protected EnumDataMode dataMode = EnumDataMode.INMEMORY;

  protected int pageSize = 10;
  protected int currPage = 0;

  //  protected String hibernate;

  //  protected String currQuery;
  //  protected String rowsQuery;

  protected int totalRows;

  // --------------------------------------------------------------------------------

  public TestTableModel() {
    // Empty
  }

  public List<Object> getDataList() {
    return dataList;
  }

  public void setDataList(List<Object> dataList) {
    this.dataList = dataList;
  }


  // --------------------------------------------------------------------------------

  public void add(Object t) {
    add(t, dataList.size());
  }

  public void add(Object t, int index) {
    dataList.add(index, t);
    tableDtaModelEvtProxy.fireActionEvent( //
        new TableDtaModelEvent(this));
    pageableModelEvtProxy.fireActionEvent( //
        new PageableModelEvent(this));
  }

  // --------------------------------------------------------------------------------

  public Object del(int index) {
    Object t = dataList.remove(index);
    tableDtaModelEvtProxy.fireActionEvent( //
        new TableDtaModelEvent(this));
    pageableModelEvtProxy.fireActionEvent( //
        new PageableModelEvent(this));
    return t;
  }

  public Object del(Object element) {
    return del(dataList.indexOf(element));
  }

  // --------------------------------------------------------------------------------

  public void clear() {
    dataList.clear();
    tableDtaModelEvtProxy.fireActionEvent( //
        new TableDtaModelEvent(this));
  }

  // --------------------------------------------------------------------------------

  protected void updateCurrPage() {
    if (getCurrPage() + 1 >= getTotalPages()) {
      setCurrPage(getTotalPages() - 1);
    }

    setCurrPage( //
    getCurrPage() >= 0 ? getCurrPage() : 0);
  }

  // --------------------------------------------------------------------------------

  public void currPageChanged() {
    //    switch (dataMode) {
    //      case INMEMORY :
    currPageChangedInMemory();
    //        break;
    //      case DATABASE :
    //        currPageChangedDatabase();
    //        break;
    //    }
  }

  // --------------------------------------------------------------------------------

  protected void currPageChangedInMemory() {
    updateCurrPage();
    tableDtaModelEvtProxy.fireActionEvent( //
        new TableDtaModelEvent(this));
    pageableModelEvtProxy.fireActionEvent( //
        new PageableModelEvent(this));
  }

  // --------------------------------------------------------------------------------


  // --------------------------------------------------------------------------------
  // PageableModel
  // --------------------------------------------------------------------------------

  public PageableModelEvtProxy getPageableModelEvtProxy() {
    return pageableModelEvtProxy;
  }

  // --------------------------------------------------------------------------------

  public int getRealFromPagedRow(int row) {
    return getCurrPage() * getPageSize() + row;
  }

  public int getPagedFromRealRow(int row) {
    throw new UnsupportedOperationException();
  }

  // --------------------------------------------------------------------------------

  public int/* */getPageSize() {
    return pageSize;
  }

  public void/**/setPageSize( //
      int pageSize) {
    this.pageSize = pageSize;
  }

  // --------------------------------------------------------------------------------

  public int/* */getCurrPage() {
    return currPage;
  }

  public void/**/setCurrPage( //
      int currPage) {
    this.currPage = currPage;

    //    currPageChanged();
    //
    //    tableDtaModelEvtProxy.fireActionEvent( //
    //        new TableDtaModelEvent(this));
  }

  // --------------------------------------------------------------------------------

  public int getTotalPages() {
    if (getTotalRows() == 0) {
      return 1;
    }

    return (int) Math.ceil( //
        ((double) getTotalRows() / getPageSize()));
  }

  // --------------------------------------------------------------------------------

  public int getTotalRows() {
    //    if (dataMode == EnumDataMode.INMEMORY) {
    return dataList.size();
    //    }
    //
    //    return totalRows;
  }

  // --------------------------------------------------------------------------------
  // TableDtaModel
  // --------------------------------------------------------------------------------

  public int getRowCount() {
    //    if (dataMode == EnumDataMode.DATABASE) {
    //    return dataList.size();
    //    }
    //
    return Math.min(dataList.size() - getRealFromPagedRow(0), pageSize);
  }

  // --------------------------------------------------------------------------------

  public Object getElementAt(int row) {
    //    if (dataMode == EnumDataMode.INMEMORY) {
    row = getRealFromPagedRow(row);
    //    }

    return dataList.get(row);
  }

  // --------------------------------------------------------------------------------

  private boolean editable;

  public boolean getEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }
}
