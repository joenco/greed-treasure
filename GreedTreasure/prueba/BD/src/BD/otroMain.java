package BD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class otroMain {
	
	// Construir un terreno
	// ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	public static PlantillaTerreno constTerreno(int tipo) {
		char[][] t = loadDataPrueba(tipo);
		PlantillaTerreno planT = new PlantillaTerreno();
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
				System.out.println(t[i][j]);
				cuadrilla = (Cuadrilla)session.load(Cuadrilla.class, t[i][j]);
				coor.setidCuadrillaRef(cuadrilla);
				planT.getfonTList().add(coor);
				//coor.setidRef(planT);
				cuadrilla.getCoordenadaList().add(coor);
				session.save(cuadrilla);
				session.save(coor);

				cuadrilla = null;
				coor = null;

			}

		}

		session.getTransaction().commit();
	    session.close();
	    
	    return planT;
		
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
	        // Etc...construirTerreno(prueba);
	        break;
	      
								 
						
						
    	  
	        
      default :
	        // Empty, black map
        break;
    }
		return ret;

				}

	public static byte[] obtenerimg(char charId) {
		byte[] img = new byte[7000];
		Cuadrilla cuadrilla = new Cuadrilla();

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		cuadrilla = (Cuadrilla) session.load(Cuadrilla.class, charId);
		img = cuadrilla.getImg();
		session.getTransaction().commit();
		session.close();
		return img;
	}
	
//	@SuppressWarnings("unchecked")
	public static char [][] loadData(String login){

		char [][] terreno = new char[16][16];
		PlantillaTerreno t;
		String aux;
		
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		t = (PlantillaTerreno) session.createQuery("FROM PlantillaTerreno AS p WHERE c.login=:"+login).uniqueResult();
	    
		List<Coordenada> c;
		aux = Integer.toString(t.getId());
		c = (List<Coordenada>) session.createQuery("FROM Coordenada AS c WHERE c.idRef ="+aux);
		Cuadrilla cuad;
		
		for( Coordenada auxCoor : c){
			cuad = auxCoor.getidCuadrillaRef();
			terreno[auxCoor.getX()][auxCoor.getY()]= cuad.getCharId();
		}
		
		
		session.getTransaction().commit();
		session.close();
		
		return terreno;
		
	} 
	

	public static void main(String[] args) {
		
		int tipo=1;
		Usuario user = new Usuario();
		
		
		
		PlantillaTerreno pt= constTerreno(tipo);
		pt.setName("Desierto");
		user.setIdRef(pt);
		user.setLogin("fannia");
		user.setPassword(123);
		pt.getUsuarioList().add(user);
		Configuration configuration = new AnnotationConfiguration();
	    configuration.configure("/BD/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();

	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
		session.save(user);
		session.save(pt);
		
		session.getTransaction().commit();
		session.close();
		
		
		

	}
}
