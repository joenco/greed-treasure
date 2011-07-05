package BD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class LoadBD {
	
	/******************************************************************
	 * 
	 * Matrices definidas para cada plantilla
	 * 
	 */
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

	
	/******************************************************************************
	 * Construir un terreno
	 * Ya tienen que existir las plantillas terreno
	 * ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	 * 
	 */
	public static void constTerreno(PlantillaTerreno planT) {
		char[][] t = loadDataPrueba(planT.getTipo());
		Tile tile = new Tile();

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
				System.out.println(t[i][j]);
				tile = (Tile) session.load(Tile.class, t[i][j]);
				coor.setIdTileRef(tile);
				planT.getFonTList().add(coor);
				coor.setIdRef(planT);
				tile.getCoordenadaList().add(coor);
				session.save(tile);
				session.save(coor);

				tile = null;
				coor = null;

			}

		}

		session.getTransaction().commit();
		session.close();

	}
	
	/******************************************************************************
	 * 
	 * Crea las 5 plantillas terreno
	 * 
	 */
	
	public static void crearPlantilla(String name, int tipo) {

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		PlantillaTerreno pt = new PlantillaTerreno();
		pt.setTipo(tipo);
		pt.setName(name);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(pt);

		session.getTransaction().commit();
		session.close();

		constTerreno(pt);

	}
	
	/***************************************************************************/
	

	public static void main(String[] args) {
		
		// Crear todos los tiles
		
		
		//Creacion de todas las plantillas terreno
		crearPlantilla("Nombre1", 1);
		crearPlantilla("Nombre2", 2);
		crearPlantilla("Nombre3", 3);
		crearPlantilla("Nombre4", 4);
		crearPlantilla("Nombre5", 1);
		
		
		// Creacion de los modelos de armas terreno y caballero
		
		// Creacion de los modelos de caballero
		
		// Creacion de las destrezas
		
		
		
	}
	
}
