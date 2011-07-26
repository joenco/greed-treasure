
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class CaballeroBeanLoader {
	public static List<CaballeroBean> loadData() {
	

    List<CaballeroBean> ret = new ArrayList<CaballeroBean>();
////public CaballeroBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new CaballeroBean("Joenco", 2, 4, 2, 4, 4, 2, 100, 145, 5));
        ret.add(new CaballeroBean("Gladiador", 1, 2, 1, 2, 1, 1, 100, 0, 1));
        ret.add(new CaballeroBean("Carlos", 3, 6, 3, 6, 6, 1, 100, 12, 2));
        ret.add(new CaballeroBean("Pilar", 8, 16, 8, 16, 10, 1, 100, 1, 4));
        ret.add(new CaballeroBean("Teresa", 1, 4, 1, 4, 1, 1, 100, 145, 1));

        return ret;
	}
	
}
