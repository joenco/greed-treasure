package BD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class Main {
	
	public static void plantilla(int tipo){
		char[][] prueba = loadDataPrueba(tipo);
		construirTerreno(prueba);
	}
	// Construir un terreno
	// ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	public static void construirTerreno(char[][] t) {

		Cuadrilla cuadrilla = new Cuadrilla();

		int n;

		n = t.length;

		    Configuration configuration = new AnnotationConfiguration();
		    configuration.configure("/BD/hibernate.cfg.xml");
		    SessionFactory sessionFactory = configuration.buildSessionFactory();

		    Session session = sessionFactory.openSession();
		    session.beginTransaction();


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				Coordenada coor = new Coordenada();

				System.out.println(j);
				System.out.println(i);
				coor.setY(j);
				coor.setX(i);
				coor.setId(i);
				System.out.println(coor.getId());
				cuadrilla = (Cuadrilla) session.load(Cuadrilla.class, t[i][j]);
				coor.setidCuadrillaRef(cuadrilla);
				cuadrilla.getCoordenadaList().add(coor);
				session.save(cuadrilla);
				session.save(coor);

				cuadrilla = null;
				coor = null;

			}

		}

		session.getTransaction().commit();
	    session.close();
	}
	
	
	// Matriz de Cuadrilla ejemplo
	public static char [][] loadDataPrueba(int userIdInt){
		char [][] ret = new char[16][16];

		switch (userIdInt) {
	      case 1 :
	    	  char [][] r1 = {{'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','e','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
 	  						  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
    	  				      {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'},
	    	  				  {'a','d','e','b','d','d','e','c','b','a','a','a','b','c','a','a'}};

	    	  ret = r1;
	        // Etc...
	        break;
      case 2 :
	    	  char [][] r2 = {{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
		  				   	  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
  				   		      {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'}};
	    	  ret = r2;
	        // Etc...
 	   	    	  break;
	      case 3 :
	    	  char [][] r3 = {{'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
	  				   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
  				   		      {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
	  				   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
	  				   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
	  				   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
  				   		      {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	  				   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
  				   		      {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				  	          {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'}};

	    	  ret = r3;
	        // Etc...
	        break;
	      case 4 :
	    	  char [][] r4 = {{'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
			   		          {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'},
					   		  {'b','b','b','b','b','b','b','b','b','b','b','b','a','a','a','a'},
					   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
					   		  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
				   		      {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'},
					   		  {'c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'}};

	    	  ret = r4;
	        // Etc...
	        break;
	      
								 
						
						
    	  
	        
      default :
	        // Empty, black map
        break;
    }
		return ret;

				}
	

	public static void main(String[] args) {
		Usuario user = new Usuario();
		PlantillaTerreno pt= new PlantillaTerreno();
		pt.setName("Desierto");
		char[][] prueba = loadDataPrueba(1);
		user.setLogin("fannia");
		user.setPassword(123);
		
		construirTerreno(prueba);

	}
}
