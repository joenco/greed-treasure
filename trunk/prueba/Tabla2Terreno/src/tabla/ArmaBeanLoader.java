package tabla;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ArmaBeanLoader {
	public static List<ArmaBean> loadData() {
	

    List<ArmaBean> ret = new ArrayList<ArmaBean>();
////public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new ArmaBean("Dragon", 200, 150, 50,2,10,200, "tabla/Castillo/Dragon.gif" ));
        ret.add(new ArmaBean("Flechas", 40, 50, 20, 30, 40, 100, "tabla/Castillo/Flechas.JPG"));
        ret.add(new ArmaBean("Gallina", 100, 300, 60, 70, 87, 300, "tabla/Castillo/Gallina.gif"));
        ret.add(new ArmaBean("Lobo", 300, 260, 45, 50, 76, 200, "tabla/Castillo/Lobo.gif"));
    //----------------------------------------------------------------------------------------    
        ret.add(new ArmaBean("LanzaRocas", 200, 150, 50,2,10,200, "tabla/Castillo/LanzaRocas.jpg" ));
        ret.add(new ArmaBean("Luz", 40, 50, 20, 30, 40, 100, "tabla/Castillo/Luz.gif"));
        ret.add(new ArmaBean("Superlobo", 100, 300, 60, 70, 87, 300, "tabla/Castillo/Superlobo.gif"));
        ret.add(new ArmaBean("Vallesta", 300, 260, 45, 50, 76, 200, "tabla/Castillo/Vallesta.jpg"));
	
        return ret;
	}
	
}