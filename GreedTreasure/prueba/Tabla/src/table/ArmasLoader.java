package table;

import java.util.ArrayList;
import java.util.List;


public class ArmasLoader {

	  public static List<ArmasBean> loadData() {
		  List<ArmasBean> ret = new ArrayList<ArmasBean>();
		        ret.add(new ArmasBean("difusal", 3, 2, 1, 8, 10, 300));
		        ret.add(new ArmasBean("maeltron",4, 1, 2, 5, 12, 350 ));
		        ret.add(new ArmasBean("sange", 2, 3, 1, 7, 15, 400));
		        ret.add(new ArmasBean("yasha", 5, 2, 1, 5, 8, 250));
		        return ret;  
	  }
}