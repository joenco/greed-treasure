package BD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class LoadBDconpatharreglados {
	
	/******************************************************************
	 * 
	 * Matrices definidas para cada plantilla
	 * 
	 */
	public static char [][] loadDataPrueba(int userIdInt){
		char [][] ret = new char[16][16];

		switch (userIdInt) {
	      case 1 ://prototipo matriz donde el castillo es "1"
	    	  char [][] r1 = {{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	    			  
	    	  				  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','x','a','a','a','a','a','A','A','A','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','a','a','a','a','a','E','E','E','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','a','a','n','a','a','A','A','A','a','a','a','a'},
	    	  				  
 	  						  {'a','a','a','a','a','a','a','a','a','a','a','x','a','a','a','a'},
 	  						  
	    	  				  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','a','a','a','1','a','a','a','a','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','a','x','a','a','a','a','a','a','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','a','a','a','a','a','a','n','a','a','a','a','a'},
	    	  				  
	    	  				  {'a','a','a','a','A','F','A','a','a','a','a','a','A','a','a','a'},
	    	  				  
	    	  				  {'a','j','a','a','A','F','A','a','a','a','a','a','E','a','a','a'},
	    	  				  
	    	  				  {'a','a','j','a','A','F','A','a','a','A','A','a','A','a','a','a'},
	    	  				  
	    	  				  {'a','j','a','j','a','a','a','a','a','E','E','a','a','a','a','a'},
	    	  				  
    	  				      {'a','a','j','a','j','a','a','a','a','a','a','a','a','a','a','a'},
    	  				      
	    	  				  {'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'}};

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
	/******************************************************************************
	 * 
	 * Crea los Tiles
	 * 
	 */
	
	public static void crearTile(char charId, boolean esOcupable, int bonusVida, int defensaAgregada, int ataqueAgregado, String ruta) throws Exception {
		

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
	    Tile tl = new Tile();
	    tl.setCharId(charId);
		tl.setEsOcupable(esOcupable);
		tl.setBonusVida(bonusVida);
		tl.setDefensaAgregada(defensaAgregada);
		tl.setAtaqueAgregado(ataqueAgregado);
		
		File file = new File(ruta);
		FileInputStream fis = new FileInputStream(file);
	    BufferedInputStream bis = new BufferedInputStream(fis);
	    byte[] buf = new byte[(int) file.length()];
	    bis.read(buf);
	    tl.setImg(buf);
		
		

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(tl);

		session.getTransaction().commit();
		session.close();

	}
		
	
	
	
	/**
	 * @throws Exception *************************************************************************/
	

	public static void main(String[] args) throws Exception {
		
		// Crear todos los tiles
		
		crearTile('a', true, 0, 0, 0, "src/Imagenes/Terreno/pastoseco.gif");
 		crearTile('b', true, 0, 0, 0, "src/Imagenes/Terreno/jardin.gif");
 		crearTile('c', true, 0, 0, 0, "src/Imagenes/Terreno/barro.gif");
 		crearTile('d', true, 0, 0, 0, "src/Imagenes/Terreno/desierto.gif");
 		crearTile('e', true, 0, 0, 0, "src/Imagenes/Terreno/nieve.gif");
 		crearTile('f', true, 0, 0, 0, "src/Imagenes/Terreno/monte.gif");
 		crearTile('g', true, 0, 0, 0, "src/Imagenes/Terreno/piedras.gif");
 		crearTile('h', true, 0, 0, 0, "src/Imagenes/Terreno/rocas.gif");
 		crearTile('i', true, 0, 0, 0, "src/Imagenes/Terreno/tierra.gif");
 		crearTile('j', true, 0, 0, 0, "src/Imagenes/Terreno/aguabaja.gif");
 		
 		crearTile('k', true, 0, 0, 0, "src/Imagenes/Terreno/aguapiedras.gif");
 		crearTile('l', true, 0, 0, 0, "src/Imagenes/Terreno/aguaprofunda.gif");
 		crearTile('m', true, 0, 0, 0, "src/Imagenes/Terreno/aguarocas.gif");
 		crearTile('n', false, 10, 0, 0, "src/Imagenes/Terreno/aura.gif");//no tiene sentido q suba vida con un entero, esto debe depender del nivel
 		crearTile('o', true, 0, 0, 0, "src/Imagenes/Terreno/crater.gif");
 		crearTile('p', true, 0, 0, 0, "src/Imagenes/Terreno/lodo.gif");
 		crearTile('q', true, 0, 0, 0, "src/Imagenes/Terreno/magma.gif");
 		crearTile('r', true, 0, 0, 0, "src/Imagenes/Terreno/molino.gif");
 		crearTile('s', true, 0, 0, 0, "src/Imagenes/Terreno/montañaneblina.gif");
 		crearTile('t', true, 0, 0, 0, "src/Imagenes/Terreno/montañanieve.gif");
 		
// 		crearTile('u', true, 0, 0, 0, "src/Imagenes/Terreno/montañanieve2.gif");
// 		crearTile('v', true, 0, 0, 0, "src/Imagenes/Terreno/montañasdesierto.gif");
// 		crearTile('w', true, 0, 0, 0, "src/Imagenes/Terreno/nieveinclinada.gif");
// 		crearTile('x', false, 5, 0, 0, "src/Imagenes/Terreno/oasis.gif");
// 		crearTile('y', true, 0, 0, 0, "src/Imagenes/Terreno/precipicio.gif");
// 		crearTile('z', true, 0, 0, 0, "src/Imagenes/Terreno/precipiciolava.gif");
// 		crearTile('A', false, 0, 0, 0, "src/Imagenes/Terreno/obstaculo1.gif");
// 		crearTile('B', false, 1, 0, 0, "src/Imagenes/Terreno/obstaculo2.gif");
// 		crearTile('C', false, 1, 0, 0, "src/Imagenes/Terreno/obstaculo3.gif");// quitar vida, sumar y quitar ataque debe ser formulado
// 		crearTile('D', false, 1, 0, 0, "src/Imagenes/Terreno/obstaculo4.gif");
// 		
// 		crearTile('E', true, 0, 0, 0, "src/Imagenes/Terreno/puenteh.gif");
// 		crearTile('F', true, 0, 0, 0, "src/Imagenes/Terreno/puentev.gif");
// 		crearTile('G', true, 0, 0, 0, "src/Imagenes/Terreno/rocasgrandes.gif");
// 		crearTile('H', true, 0, 0, 0, "src/Imagenes/Terreno/siembra.gif");
// 		crearTile('I', true, 0, 0, 0, "src/Imagenes/Terreno/terrenodisparejo.gif");
// 		crearTile('1', false, 0, 0, 0, "src/Imagenes/Terreno/castillo1.gif");
// 		crearTile('2', false, 0, 0, 0, "src/Imagenes/Terreno/castillo2.gif");
// 		crearTile('3', false, 0, 0, 0, "src/Imagenes/Terreno/castillo3.gif");
// 		crearTile('4', false, 0, 0, 0, "src/Imagenes/Terreno/castillo4.gif");
// 		crearTile('5', false, 0, 0, 0, "src/Imagenes/Terreno/castillo5.gif");
 
 		
		
		//Creacion de todas las plantillas terreno
//		crearPlantilla("Nombre1", 1);
//		crearPlantilla("Nombre2", 2);
//		crearPlantilla("Nombre3", 3);
//		crearPlantilla("Nombre4", 4);
//		crearPlantilla("Nombre5", 1);
		
		// Creacion de los modelos de armas terreno y caballero
		
		// Creacion de los modelos de caballero
		
		// Creacion de las destrezas
		
		
		
		
		
		
	}
	
}
