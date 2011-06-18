package BD;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;




public class Main {
	
	// Construir un terreno
	// ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	public static void construirTerreno(String[][] t) {
		
		Cuadrilla cuadrilla;
		cuadrilla = new Cuadrilla();
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();
		
//		Map<Integer , Cuadrilla> ctporletra = new HashMap(); 
//		ctporletra.put(Cuadrilla.getId(),Cuadrilla );
//		
		
		
		int n;
		
//		n = t.length;
//		System.out.println("tamaño de la matriz" + n);
//		FondoCuadrilla ft = new FondoCuadrilla();
//		Cuadrilla Cuadrilla ;
//		String a;
//				
//		
//		for (int i = 0; i < n; i++) {
//			
//			
//			for (int j = 0; j < n; j++) {
//				Session session = SessionString[][] prueba = matrizCuadrilla();
		Hibernate.getInstance().openSession();
//			    session.beginTransaction();
//				
//				a= t[i][j];		
//				ft.setX(i);
//				ft.setY(j);
//				Cuadrilla = null;
//				
//			    Cuadrilla = (Cuadrilla) session.createQuery("FROM Cuadrilla AS c WHERE c.imagen = "+a);
//			    
//				ft.setidCuadrillaRef(Cuadrilla);
//				session.save(ft);
//				
//				session.delete(Cuadrilla);
//				session.getTransaction().commit();
//				session.close();	
//				
//				
//				
//			}
//			
//		}
		
		
	}

	
	// Matriz de Cuadrilla ejemplo
	public static String[][] matrizTerreno() {
		String[][] ret = new String[16][16];
			  String [][] r = {{"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"},
							  {"a","d","e","b","d","d","e","c","b","a","a","a","b","c","a","a"}};
		
			  ret=r;
	    return ret;
	}
	
	

	
	
	public static void main(String[] args) {
		
		//String[][] prueba = matrizCuadrilla();
		//construirCuadrilla(prueba);
		
	}
}
