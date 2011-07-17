package BD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import BD.Metodos;

public class LoadBD {
	
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
		
		//crearTile('a', true, 0, 0, 0, "./../Imagenes/Terreno/pastoseco.gif");
//		crearTile('b', true, 0, 0, 0, "./Imagenes/Terreno/jardin.gif");
//		crearTile('c', true, 0, 0, 0, "./Imagenes/Terreno/barro.gif");
//		crearTile('d', true, 0, 0, 0, "./Imagenes/Terreno/desierto.gif");
//		crearTile('e', true, 0, 0, 0, "./Imagenes/Terreno/nieve.gif");
//		crearTile('f', true, 0, 0, 0, "./Imagenes/Terreno/monte.gif");
//		crearTile('g', true, 0, 0, 0, "./Imagenes/Terreno/piedras.gif");
//		crearTile('h', true, 0, 0, 0, "./Imagenes/Terreno/rocas.gif");
//		crearTile('i', true, 0, 0, 0, "./Imagenes/Terreno/tierra.gif");
//		crearTile('j', true, 0, 0, 0, "./Imagenes/Terreno/aguabaja.gif");
//		
//		crearTile('k', true, 0, 0, 0, "./Imagenes/Terreno/aguapiedras.gif");
//		crearTile('l', true, 0, 0, 0, "./Imagenes/Terreno/aguaprofunda.gif");
//		crearTile('m', true, 0, 0, 0, "./Imagenes/Terreno/aguarocas.gif");
//		crearTile('n', false, 10, 0, 0, "./Imagenes/Terreno/aura.gif");//no tiene sentido q suba vida con un entero, esto debe depender del nivel
//		crearTile('o', true, 0, 0, 0, "./Imagenes/Terreno/crater.gif");
//		crearTile('p', true, 0, 0, 0, "./Imagenes/Terreno/lodo.gif");
//		crearTile('q', true, 0, 0, 0, "./Imagenes/Terreno/magma.gif");
//		crearTile('r', true, 0, 0, 0, "./Imagenes/Terreno/molino.gif");
//		crearTile('s', true, 0, 0, 0, "./Imagenes/Terreno/montañaneblina.gif");
//		crearTile('t', true, 0, 0, 0, "./Imagenes/Terreno/montañanieve.gif");
//		
//		crearTile('u', true, 0, 0, 0, "./Imagenes/Terreno/montañanieve2.gif");
//		crearTile('v', true, 0, 0, 0, "./Imagenes/Terreno/montañadesierto.gif");
//		crearTile('w', true, 0, 0, 0, "./Imagenes/Terreno/nieveinclinada.gif");
//		crearTile('x', false, 5, 0, 0, "./Imagenes/Terreno/oasis.gif");
//		crearTile('y', true, 0, 0, 0, "./Imagenes/Terreno/precipicio.gif");
//		crearTile('z', true, 0, 0, 0, "./Imagenes/Terreno/precipiciolava.gif");
//		crearTile('A', false, 0, 0, 0, "./Imagenes/Terreno/obstaculo1.gif");
//		crearTile('B', false, -1, 0, 0, "./Imagenes/Terreno/obstaculo2.gif");
//		crearTile('C', false, -1, 0, 0, "./Imagenes/Terreno/obstaculo3.gif");// quitar vida, sumar y quitar ataque debe ser formulado
//		crearTile('D', false, -3, 0, 0, "./Imagenes/Terreno/obstaculo4.gif");
//		
//		crearTile('E', true, 0, 0, 0, "./Imagenes/Terreno/puenteh.gif");
//		crearTile('F', true, 0, 0, 0, "./Imagenes/Terreno/puentev.gif");
//		crearTile('G', true, 0, 0, 0, "./Imagenes/Terreno/rocasgrandes.gif");
//		crearTile('z', true, 0, 0, 0, "./Imagenes/Terreno/siembra.gif");
//		crearTile('z', true, 0, 0, 0, "./Imagenes/Terreno/terrenodisparejo.gif");
//		crearTile('1', false, 0, 0, 0, "./Imagenes/Terreno/castillo1.gif");
//		crearTile('2', false, 0, 0, 0, "./Imagenes/Terreno/castillo2.gif");
//		crearTile('3', false, 0, 0, 0, "./Imagenes/Terreno/castillo3.gif");
//		crearTile('4', false, 0, 0, 0, "./Imagenes/Terreno/castillo4.gif");
//		crearTile('5', false, 0, 0, 0, "./Imagenes/Terreno/castillo5.gif");
//
//		
		
		//Creacion de todas las plantillas terreno
//		crearPlantilla("Nombre1", 1);
//		crearPlantilla("Nombre2", 2);
//		crearPlantilla("Nombre3", 3);
//		crearPlantilla("Nombre4", 4);
//		crearPlantilla("Nombre5", 1);
		
		// Creacion de los modelos de armas terreno y caballero
		
		// Creacion de los modelos de caballero
		
		// Creacion de las destrezas
	/*	Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Usuario a = new Usuario ();
		a.setNombre("arturo rondon");
		a.setPassword(123456);
		a.setEmail("artur");
		a.setOro(120);
		a.setLogin("arturo");
		a.setPais("Vene");
		a.setNivel(5);
		ModeloArma bomba = new ModeloArma();
		bomba.setNombre("Bomba");
		bomba.setDefensa(50);
		bomba.setAlcanse(3);
		bomba.setMuniciones_base(2);
		bomba.setOro(10);
		ArmaTerreno armaT = new ArmaTerreno();
		armaT.setModelRef(bomba);
		armaT.setMuniciones_actuales(bomba.getMuniciones_base());
		armaT.setRefUser(a);
		a.getArmaTerreno().add(armaT);
		bomba.getArmaTerreno().add(armaT);
		session.save(a);
		session.save(bomba);
		session.save(armaT);
		
		ArmaTerreno armaT1 = new ArmaTerreno();
		armaT1.setModelRef(bomba);
		armaT1.setRefUser(a);
		armaT1.setMuniciones_actuales(bomba.getMuniciones_base());
		a.getArmaTerreno().add(armaT1);
		bomba.getArmaTerreno().add(armaT1);
		session.save(a);
		session.save(bomba);
		session.save(armaT1);
		
		ArmaTerreno armaT2 = new ArmaTerreno();
		ModeloArma espada = new ModeloArma();
		espada.setNombre("Espada");
		espada.setDefensa(50);
		espada.setAlcanse(3);
		espada.setMuniciones_base(2);
		espada.setOro(10);
		armaT2.setModelRef(espada);
		armaT2.setRefUser(a);
		armaT2.setMuniciones_actuales(espada.getMuniciones_base());
		a.getArmaTerreno().add(armaT2);
		espada.getArmaTerreno().add(armaT2);
		session.save(a);
		session.save(espada);
		session.save(armaT2);
		

		ArmaTerreno armaT3 = new ArmaTerreno();
		Usuario s = new Usuario ();
		s.setNombre("sujaira moughawiche");
		s.setPassword(123456);
		s.setEmail("susi141");
		s.setOro(120);
		s.setLogin("susi");
		s.setPais("Vene");
		s.setNivel(5);
		ModeloArma pistola = new ModeloArma();
		pistola.setNombre("Pistola");
		pistola.setDefensa(50);
		pistola.setAlcanse(3);
		pistola.setMuniciones_base(2);
		pistola.setOro(10);
		armaT3.setModelRef(pistola);
		armaT3.setRefUser(s);
		armaT3.setMuniciones_actuales(pistola.getMuniciones_base());
		s.getArmaTerreno().add(armaT3);
		pistola.getArmaTerreno().add(armaT3);
		session.save(s);
		session.save(pistola);
		session.save(armaT3);
		
		ArmaTerreno armaT4 = new ArmaTerreno();
		armaT4.setModelRef(bomba);
		armaT4.setRefUser(s);
		armaT4.setMuniciones_actuales(pistola.getMuniciones_base());
		s.getArmaTerreno().add(armaT4);
		bomba.getArmaTerreno().add(armaT4);
		session.save(s);
		session.save(pistola);
		session.save(armaT4);
		
		session.getTransaction().commit();
		session.close();*/
		Usuario a = new Usuario ();
		a.setNombre("arturo rondon");
		a.setPassword(123456);
		a.setEmail("artur");
		a.setOro(120);
		a.setLogin("arturo");
		a.setPais("Vene");
		a.setNivel(5);
		Metodos.tablaPrincipal(a);
		List <Object> object = new ArrayList<Object>();
		object = Metodos.tablaPorArma(a, "Espada");
	}
	
}
