package BD;

import org.hibernate.Session;




public class Main {
	
	// Construir un terreno
	// ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	public static void construirTerreno(String[][] t) {
		int n;
		
		n = t.length;
		System.out.println("tamaño de la matriz" + n);
		FondoTerreno ft = new FondoTerreno();
		Terreno terreno ;
		String a;
				
		
		for (int i = 0; i < n; i++) {
			
			
			for (int j = 0; j < n; j++) {
				Session session = SessionHibernate.getInstance().openSession();
			    session.beginTransaction();
				
				a= t[i][j];		
				ft.setX(i);
				ft.setY(j);
				terreno = null;
				
			    terreno = (Terreno) session.createQuery("FROM Terreno AS c WHERE c.id = "+a);
			    
				ft.setidTerrenoRef(terreno);
				session.save(ft);
				
				session.delete(terreno);
				session.getTransaction().commit();
				session.close();	
				
				
				
			}
			
		}
		
		
	}

	
	// Matriz de terreno ejemplo
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

		String [][] prueba = matrizTerreno();
		//construirTerreno(prueba);
		Terreno terreno;
		terreno = new Terreno();
		Session session = SessionHibernate.getInstance().openSession();
	    session.beginTransaction();
		terreno.setImagen("tal");
		terreno.setEsOcupable(true);
		session.save(terreno);
		
		session.getTransaction().commit();
		session.close();
	}
}
