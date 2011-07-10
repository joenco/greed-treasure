package BD;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import BD.NuevoUsuario;

public class otroMain {
	
	// Construir un terreno
	// Ya tienen que existir las plantillas terreno
	// ya existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	public static void constTerreno(PlantillaTerreno planT) {
		char[][] t = loadDataPrueba(planT.getTipo());
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
				coor.setidRef(planT);
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

//	@SuppressWarnings("unchecked")
	public static char [][] loadData(String login){

		char [][] terreno = new char[16][16];
		
		Usuario u = new Usuario();
		PlantillaTerreno pt = new PlantillaTerreno();
		
		
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		    Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
		    q.setParameter("att_login", login);

		    u = (Usuario) q.uniqueResult();
		    pt = (PlantillaTerreno)session.load(PlantillaTerreno.class, u.getidRef().getTipo());
			
		List<Coordenada> c;
		c= pt.getfonTList();
		Cuadrilla cuad;
		
		for( Coordenada auxCoor : c){
			cuad = auxCoor.getidCuadrillaRef();
			terreno[auxCoor.getX()][auxCoor.getY()]= cuad.getCharId();
		}
		
		
		session.getTransaction().commit();
		session.close();
		
		return terreno;
		
	} 
	
	public static void crearPlantilla(String name, int tipo){

		Configuration configuration = new AnnotationConfiguration();
	    configuration.configure("/BD/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();

		PlantillaTerreno pt= new PlantillaTerreno();
		pt.setTipo(tipo);
		pt.setName(name);
		
		
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
		
	    
	    
	    session.save(pt);

	    session.getTransaction().commit();
		session.close();

		constTerreno(pt);

	} 
	
	public static void main(String[] args) {
		
		crearPlantilla("Desierto",1);
		crearPlantilla("otro",2);
		
		NuevoUsuario.nuevoUsuario("Fannia", 123, 1);
		}
}