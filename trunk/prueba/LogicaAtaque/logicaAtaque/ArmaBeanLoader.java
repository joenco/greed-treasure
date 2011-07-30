
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ArmaBeanLoader {
	public static List<ArmaBean> loadData() {
	

    List<ArmaBean> ret = new ArrayList<ArmaBean>();
////public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new ArmaBean("Dragon", 10, 18, 10, 12, 1001, 15, 100));
        ret.add(new ArmaBean("Flechas", 2, 8, 4, 8, 1000, 1, 100));
        ret.add(new ArmaBean("Gallina", 1, 5, 4, 3, 1000, 5, 100));
        ret.add(new ArmaBean("Lobo", 8, 14, 15, 8, 1001, 12, 100));
        ret.add(new ArmaBean("Luz", 5, 8, 8, 10, 1000, 5, 100));
	
        return ret;
	}
	
}
