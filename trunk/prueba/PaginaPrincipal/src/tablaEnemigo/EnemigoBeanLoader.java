package tablaEnemigo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class EnemigoBeanLoader {
	public static List<EnemigoBean> loadData() {
	

    List<EnemigoBean> ret = new ArrayList<EnemigoBean>();
////public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
//			String imageName) {

    
        ret.add(new EnemigoBean("Popeye", 10, 50, 10));
        ret.add(new EnemigoBean("Joenco", 10, 50, 12));
        ret.add(new EnemigoBean("Gladiador", 9, 40, 9));
        ret.add(new EnemigoBean("Pluto", 9, 40, 11));
    //----------------------------------------------------------------------------------------    
        ret.add(new EnemigoBean("Magno", 9, 35, 11));
        ret.add(new EnemigoBean("Cantiflas", 9, 35, 15));
        ret.add(new EnemigoBean("Simio", 8, 35, 15));
        ret.add(new EnemigoBean("Cocoliso", 8, 30, 15));
        ret.add(new EnemigoBean("Termineitor", 7, 25, 15));
        ret.add(new EnemigoBean("Tarzán", 5, 25, 15));
        ret.add(new EnemigoBean("RedEvil", 4, 25, 15));
        ret.add(new EnemigoBean("Chuki", 3, 15, 10));
        ret.add(new EnemigoBean("Otto", 2, 15, 12));
        ret.add(new EnemigoBean("Pitufo", 1, 5, 4));
	
        return ret;
	}
	
}