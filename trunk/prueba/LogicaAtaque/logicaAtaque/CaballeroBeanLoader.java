
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class CaballeroBeanLoader {
	public static List<CaballeroBean> loadData() {
	

    List<CaballeroBean> ret = new ArrayList<CaballeroBean>();
////public CaballeroBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new CaballeroBean("Joenco", 10, 5, 20, 5, 20, 29625, 100, 100, 1500, 100));
        ret.add(new CaballeroBean("Gladiador", 8, 4, 15, 4, 12, 13765, 100, 100, 550, 120));
        ret.add(new CaballeroBean("Carlos", 1, 1, 4, 1, 4, 0, 100, 100, 3, 2));
        ret.add(new CaballeroBean("Pilar", 3, 1, 8, 1, 8, 750, 100, 100, 2, 5));
        ret.add(new CaballeroBean("Teresa", 5, 2, 10, 2, 10, 2200, 100, 100, 50, 11));

        return ret;
	}
	
}
