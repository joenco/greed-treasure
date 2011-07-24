
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ArmaBeanLoader {
	public static List<ArmaBean> loadData() {
	

    List<ArmaBean> ret = new ArrayList<ArmaBean>();
////public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new ArmaBean("Dragon", 20, 15, 20, 4, 10, 100, 5));
        ret.add(new ArmaBean("Flechas", 10, 4, 15, 3, 40, 100, 3));
        ret.add(new ArmaBean("Gallina", 15, 7, 6, 4, 87, 100, 2));
        ret.add(new ArmaBean("Lobo", 12, 20, 5, 10, 76, 100, 7));
        ret.add(new ArmaBean("Luz", 4, 8, 20, 25, 40, 100, 2));
	
        return ret;
	}
	
}
