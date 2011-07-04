package TablaCaballero;


	import java.awt.Color;
	import java.util.ArrayList;
	import java.util.List;


	public class ArmaBeanLoader2 {
		public static List<ArmaBean2> loadData() {
		

	    List<ArmaBean2> ret = new ArrayList<ArmaBean2>();
	////public ArmaBean(String name, int a, int b, int c, int d, int e, int f,
//				String imageName) {

	    
	        ret.add(new ArmaBean2("armor", 200, 150, 50,2,10,200, "tablaCaballero/Caballero/armor.jpg" ));
	        ret.add(new ArmaBean2("Flechas", 40, 50, 20, 30, 40, 100, "tabla/Castillo/Flechas.JPG"));
	        ret.add(new ArmaBean2("Gallina", 100, 300, 60, 70, 87, 300, "tabla/Castillo/Gallina.gif"));
	        ret.add(new ArmaBean2("Lobo", 300, 260, 45, 50, 76, 200, "tabla/Castillo/Lobo.gif"));
	    //----------------------------------------------------------------------------------------    
	        ret.add(new ArmaBean2("LanzaRocas", 200, 150, 50,2,10,200, "tabla/Castillo/LanzaRocas.jpg" ));
	        ret.add(new ArmaBean2("Luz", 40, 50, 20, 30, 40, 100, "tabla/Castillo/Luz.gif"));
	        ret.add(new ArmaBean2("Superlobo", 100, 300, 60, 70, 87, 300, "tabla/Castillo/Superlobo.gif"));
	        ret.add(new ArmaBean2("Vallesta", 300, 260, 45, 50, 76, 200, "tabla/Castillo/Vallesta.jpg"));
		
	        return ret;
		}
		
	}
	
	

