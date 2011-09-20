package com.thinkingandlooking.database;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.hibernate.Session;


public class LoadBD {

	/******************************************************************
	 * 
	 * Matrices definidas para cada plantilla
	 * 
	 */
	public static char[][] loadDataTerreno(int idPlantilla) {
		char[][] ret = new char[16][16];

		switch (idPlantilla) {
		case 1:// prototipo matriz donde el castillo es "1"
			char[][] r1 = {
					{ 'a', 'a', 'a', 'a', 'a', 'B', 'a', 'a', 'a', 'a', 'B','a', 'a', 'a', 'a', 'a' },

					{ 'a', 'b', 'b', 'a', 'i', 'i', 'a', 'a', 'a', 'j', 'i','i', 'a', 'a', 'b', 'a' },

					{ 'a', 'b', 'b', 'x', 'a', 'A', 'A', 'f', 'f', 'j', 'A','A', 'A', 'a', 'a', 'a' },

					{ 'a', 'a', 'f', 'f', 'a', 'E', 'E', 'a', 'C', 'j', 'E','E', 'E', 'a', 'b', 'a' },

					{ 'B', 'a', 'B', 'a', 'a', 'A', 'A', 'a', 'n', 'j', 'A','A', 'A', 'b', 'a', 'a' },

					{ 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'b', 'a','x', 'H', 'B', 'a', 'B' },

					{ 'a', 'b', 'A', 'F', 'A', 'H', 'a', 'a', 'b', 'a', 'a','a', 'a', 'a', 'a', 'a' },

					{ 'a', 'b', 'A', 'F', 'A', 'a', 'a', '1', 'i', 'a', 'a','D', 'D', 'a', 'a', 'a' },

					{ 'a', 'b', 'A', 'F', 'A', 'b', 'a', 'a', 'i', 'h', 'h','D', 'D', 'f', 'a', 'a' },

					{ 'a', 'a', 'a', 'a', 'a', 'x', 'a', 'a', 'f', 'a', 'n','a', 'a', 'f', 'a', 'a' },

					{ 'B', 'a', 'B', 'a', 'A', 'F', 'A', 'a', 'b', 'b', 'a','a', 'A', 'a', 'a', 'B' },

					{ 'a', 'j', 'j', 'a', 'A', 'F', 'A', 'a', 'b', 'b', 'a','a', 'E', 'a', 'j', 'a' },

					{ 'a', 'a', 'j', 'j', 'A', 'F', 'A', 'a', 'a', 'A', 'A','a', 'A', 'j', 'H', 'a' },

					{ 'a', 'j', 'H', 'j', 'a', 'b', 'b', 'a', 'a', 'E', 'E','a', 'j', 'i', 'j', 'a' },

					{ 'a', 'i', 'i', 'b', 'a', 'f', 'f', 'a', 'a', 'A', 'A','b', 'a', 'i', 'a', 'a' },

					{ 'a', 'a', 'a', 'B', 'a', 'a', 'a', 'a', 'a', 'a', 'a','B', 'a', 'a', 'a', 'a' } };

			ret = r1;
			// Etc...
			break;
		case 2:
			char[][] r2 = {
					{ 'g', 'g', 'g', 'g', 'y', 'g', 'g', 'g', 'g', 'g', 'g','y', 'g', 'g', 'g', 'g' },

					{ 'g', 'p', 'g', 'h', 'h', 'h', 'g', 'g', 'g', 'G', 'G','h', 'h', 'h', 'h', 'g' },

					{ 'g', 'p', 'y', 'y', 'y', 'g', 'g', 'g', 'g', 'G', 'G','g', 'h', 'h', 'h', 'g' },

					{ 'g', 'g', 'E', 'E', 'E', 'h', 'h', 'g', 'G', 'g', 'q','G', 'g', 'h', 'h', 'g' },

					{ 'g', 'g', 'y', 'y', 'y', 'g', 'h', 'G', 'y', 'g', 'q','g', 'G', 'g', 'h', 'g' },

					{ 'g', 'h', 'g', 'g', 'g', 'g', 'G', 'g', 'p', 'p', 'p','g', 'g', 'z', 'g', 'g' },

					{ 'r', 'h', 'g', 'r', 'g', 'G', 'g', 'p', 'g', 'g', 'o','y', 'F', 'z', 'g', 'g' },

					{ 'g', 'h', 'g', 'g', 'G', 'q', 'g', 'g', 'p', 'g', 'o','y', 'F', 'z', 'g', 'g' },

					{ 'g', 'g', 'g', 'G', 'q', 'g', 'g', 'g', '2', 'g', 'o','y', 'F', 'z', 'g', 'g' },

					{ 'g', 'g', 'G', 'q', 'g', 'g', 'g', 'g', 'p', 'g', 'o','y', 'F', 'z', 'g', 'g' },

					{ 'g', 'g', 'g', 'o', 'o', 'o', 'o', 'p', 'g', 'g', 'g','r', 'g', 'z', 'G', 'g' },

					{ 'g', 'g', 'h', 'y', 'y', 'y', 'y', 'g', 'g', 'g', 'g','g', 'g', 'G', 'g', 'g' },

					{ 'r', 'p', 'h', 'E', 'E', 'E', 'E', 'g', 'y', 'g', 'y','g', 'G', 'g', 'p', 'g' },

					{ 'g', 'p', 'h', 'y', 'y', 'y', 'y', 'g', 'g', 'y', 'g','G', 'g', 'g', 'p', 'g' },

					{ 'g', 'g', 'h', 'p', 'p', 'g', 'g', 'g', 'g', 'g', 'G','g', 'g', 'g', 'p', 'g' },

					{ 'g', 'g', 'g', 'g', 'r', 'g', 'g', 'g', 'g', 'g', 'g','r', 'g', 'g', 'g', 'g' } };
			ret = r2;
			// Etc...
			break;
		case 3:
			char[][] r3 = {
					{ 'd', 'd', 'd', 'd', 'y', 'd', 'd', 'd', 'd', 'd', 'd','y', 'd', 'd', 'd', 'd' },

					{ 'd', 's', 's', 's', 'd', 'd', 'd', 'd', 'd', 'd', 'd','s', 's', 'd', 'd', 'd' },

					{ 'd', 's', 's', 's', 'd', 'd', 'd', 'd', 'r', 'r', 'r','s', 's', 'D', 'd', 'd' },

					{ 'd', 'd', 'D', 'd', 'd', 'C', 'd', 'v', 'd', 'd', 'd','d', 'D', 'd', 'd', 'y' },

					{ 'y', 'd', 'd', 'D', 'd', 'd', 'v', 'd', 'v', 'd', 'v','d', 'd', 'C', 'd', 'd' },

					{ 'd', 'd', 'd', 'd', 'D', 'v', 'd', 'v', 'd', 'v', 'd','d', 'C', 'd', 'd', 'd' },

					{ 'd', 'd', 'r', 'd', 'd', 'd', 'v', 'd', 'v', 'd', 'd','C', 'd', 'C', 'd', 'd' },

					{ 'd', 'd', 'd', 'r', 'd', 'v', 'd', 'v', 'd', '3', 'd','x', 'C', 'd', 'd', 'd' },

					{ 'd', 'd', 'r', 'd', 'd', 'D', 'v', 'd', 'v', 'd', 'd','C', 'd', 'C', 'd', 'd' },

					{ 'd', 'd', 'd', 'd', 'D', 'v', 'd', 'v', 'd', 'v', 'd','d', 'C', 'd', 'd', 'd' },

					{ 'd', 'd', 'd', 'D', 'd', 'd', 'v', 'd', 'v', 'd', 'v','C', 'd', 'd', 'd', 'y' },

					{ 'y', 'd', 'D', 'd', 'd', 'C', 'd', 'v', 'd', 'd', 'd','d', 'd', 'D', 'd', 'd' },

					{ 'd', 'd', 'd', 'd', 'C', 'd', 'd', 'r', 'd', 'd', 'r','d', 'D', 'd', 'd', 'd' },

					{ 'd', 's', 's', 's', 'd', 'd', 'd', 'd', 'r', 'r', 'd','d', 's', 's', 's', 'd' },

					{ 'd', 's', 's', 's', 'd', 'd', 'd', 'd', 'd', 'd', 'd','d', 's', 's', 's', 'd' },

					{ 'd', 'd', 'd', 'd', 'y', 'd', 'd', 'd', 'd', 'd', 'd','d', 'y', 'd', 'd', 'd' } };

			ret = r3;
			// Etc...
			break;
		case 4:
			char[][] r4 = {
					{ 'e', 't', 'e', 'u', 'e', 'u', 'e', 't', 'u', 't', 'e','u', 'e', 'u', 'e', 't' },

					{ 'u', 'e', 't', 'e', 'u', 'e', 'u', 'w', 'u', 'w', 'u','e', 'u', 'e', 't', 'e' },

					{ 'e', 'u', 'e', 't', 'e', 'u', 'A', 't', 'q', 't', 'A','u', 'e', 't', 'e', 'u' },

					{ 'u', 'e', 'u', 'e', 't', 'A', 'u', 'w', 'q', 'w', 'u','A', 't', 'e', 'u', 'e' },

					{ 'e', 'u', 'e', 'u', 'A', 't', 'r', 't', 'u', 't', 'r','t', 'A', 'u', 'e', 'u' },

					{ 'u', 'e', 'u', 'A', 'u', 'r', 't', 'w', 'u', 'w', 't','r', 'u', 'A', 'u', 'e' },

					{ 'w', 'u', 'w', 'u', 'w', 'u', 'w', 't', 'u', 't', 'w','u', 'w', 'u', 'w', 'u' },

					{ 'u', 'u', 'u', 'q', 'q', 'u', 'u', 'u', '4', 'u', 'u','u', 'q', 'q', 'u', 'u' },

					{ 'w', 't', 'w', 't', 'w', 't', 'w', 't', 'u', 't', 'w','t', 'w', 't', 'w', 'w' },

					{ 't', 'e', 't', 'A', 't', 'r', 't', 'w', 'u', 'w', 't','r', 't', 'A', 't', 'e' },

					{ 'e', 't', 'e', 't', 'A', 't', 'r', 't', 'u', 't', 'r','t', 'A', 't', 'e', 't' },

					{ 't', 'e', 't', 'e', 't', 'A', 't', 'w', 'q', 'w', 't','A', 't', 'e', 't', 'e' },

					{ 'e', 't', 'e', 't', 'e', 't', 'A', 't', 'q', 't', 'A','t', 'e', 't', 'e', 't' },

					{ 't', 'e', 't', 'e', 't', 'e', 't', 'w', 'u', 'w', 't','e', 't', 'e', 't', 'e' },

					{ 'e', 't', 'e', 't', 'e', 't', 'e', 't', 'u', 't', 'e','t', 'e', 't', 'e', 't' },

					{ 't', 'e', 't', 'e', 't', 'e', 't', 'w', 'u', 'w', 't','e', 't', 'e', 't', 'e' } };

			ret = r4;
			// Etc...
			break;
		case 5:
			char[][] r5 = {
					{ 'l', 'l', 'l', 'l', 'l', 'l', 'l', 'k', 'k', 'l', 'l','l', 'l', 'l', 'l', 'l' },

					{ 'l', 'l', 'l', 'l', 'k', 'k', 'k', 'k', 'k', 'k', 'k','k', 'l', 'l', 'l', 'l' },

					{ 'l', 'l', 'l', 'k', 'C', 'k', 'k', 'j', 'j', 'k', 'k','C', 'k', 'l', 'l', 'l' },

					{ 'l', 'l', 'k', 'C', 'j', 'm', 'A', 'A', 'j', 'm', 'j','m', 'C', 'k', 'l', 'l' },

					{ 'l', 'k', 'C', 'j', 'B', 'B', 'j', 'm', 'j', 'B', 'B','j', 'm', 'C', 'k', 'l' },

					{ 'l', 'k', 'k', 'j', 'B', 'B', 'm', 'j', 'm', 'B', 'B','m', 'j', 'k', 'k', 'l' },

					{ 'l', 'k', 'k', 'j', 'j', 'm', 'j', 'm', 'j', 'B', 'B','j', 'm', 'k', 'k', 'l' },

					{ 'k', 'k', 'j', 'A', 'j', 'm', 'j', 'm', 'j', 'm', 'j','m', 'A', 'j', 'k', 'k' },

					{ 'k', 'k', 'j', 'A', 'm', 'j', 'm', '5', 'm', 'j', 'm','j', 'A', 'j', 'k', 'k' },

					{ 'l', 'k', 'k', 'A', 'j', 'm', 'j', 'm', 'j', 'm', 'j','m', 'A', 'k', 'k', 'l' },

					{ 'l', 'k', 'k', 'j', 'j', 'B', 'B', 'j', 'm', 'j', 'B','B', 'j', 'k', 'k', 'l' },

					{ 'l', 'k', 'C', 'j', 'j', 'B', 'B', 'm', 'j', 'm', 'B','B', 'j', 'C', 'k', 'l' },

					{ 'l', 'l', 'k', 'C', 'j', 'j', 'j', 'A', 'A', 'j', 'j','j', 'C', 'k', 'l', 'l' },

					{ 'l', 'l', 'l', 'k', 'C', 'k', 'k', 'j', 'j', 'k', 'k','C', 'k', 'l', 'l', 'l' },

					{ 'l', 'l', 'l', 'l', 'k', 'k', 'k', 'k', 'k', 'k', 'k','k', 'l', 'l', 'l', 'l' },

					{ 'l', 'l', 'l', 'l', 'l', 'l', 'l', 'k', 'k', 'l', 'l','l', 'l', 'l', 'l', 'l' } };

			ret = r5;

		default:
			// Empty, black map
			break;
		}
		return ret;

	}

	/******************************************************************************
	 * Construir un terreno Ya tienen que existir las plantillas terreno ya
	 * existente las cuadrillas con imagen "a" "b" "c" "d" y "e"
	 * 
	 */
	public static void constTerreno(PlantillaTerreno planT) {
		char[][] t = loadDataTerreno(planT.getTipo());
		Tile tile = new Tile();

		int n;

		n = t.length;

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				Coordenada coor = new Coordenada();

				coor.setY(j);
				coor.setX(i);
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
	 * Crea las plantillas terreno
	 * 
	 */

	public static void crearPlantilla(String name, int tipo) {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		PlantillaTerreno pt = new PlantillaTerreno();
		pt.setTipo(tipo);
		pt.setName(name);

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

	public static void crearTile(char charId, boolean esOcupable,
			int bonusVida, int ataqueAgregado, int defensaAgregada, String ruta)
			throws Exception {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

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

		
		
		session.save(tl);

		session.getTransaction().commit();
		session.close();

	}

	/******************************************************************************
	 * 
	 * Crea los Modelos Arma Caballero
	 * 
	 */
	
	public static void insertarModeloArmaCaballero(String nombre,int tipoExt, int ataque, int defensa,
			int alcance, int municiones, int oro, int nivel, String ruta)
					throws Exception{
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
				
		ModeloArmaCaballero model = new ModeloArmaCaballero();
		
		model.setTipoExtremidad(tipoExt);
		model.setNombre(nombre);
		model.setAtaque(ataque);
		model.setDefensa(defensa);
		model.setAlcance(alcance);
		model.setMuniciones_base(municiones);
		model.setOro(oro);
		model.setNivel(nivel);

		File file = new File(ruta);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buf = new byte[(int) file.length()];
		bis.read(buf);
		model.setImagen(buf);
		

		session.save(model);

		session.getTransaction().commit();
		session.close();
		
	}
	
	/******************************************************************************
	 * 
	 * Crea los Modelos Arma Terreno
	 * 
	 */
	
	public static void insertarModeloArmaTerreno(String nombre, int ataque, int defensa,
			int alcance, int municiones, int oro, int nivel, String ruta) 
					throws Exception{
					
					Session session = SessionHibernate.getInstance().openSession();
					session.beginTransaction();			
					
					
		ModeloArmaTerreno model = new ModeloArmaTerreno();
		
		model.setNombre(nombre);
		model.setAtaque(ataque);
		model.setDefensa(defensa);
		model.setAlcance(alcance);
		model.setMuniciones_base(municiones);
		model.setNivel(nivel);
		model.setOro(oro);

		File file = new File(ruta);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buf = new byte[(int) file.length()];
		bis.read(buf);
		model.setImagen(buf);

		session.save(model);

		session.getTransaction().commit();
		session.close();
		
	}
		
	
	
	
	/******************************************************************************
	 * 
	 * Crea los Modelos Caballero
	 * 
	 */
	public static void modeloCaballero(int ataquebase, int defensabase, String nombreModelo,String rutaImgEdicion, String rutaImgTerreno) 
	throws Exception{
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		ModeloCaballero cab = new ModeloCaballero();
		cab.setAtaqueBase(ataquebase);
		cab.setDefensaBase(defensabase);
		cab.setNombreModelo(nombreModelo);
		
		File file = new File(rutaImgEdicion);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] buf = new byte[(int) file.length()];
		bis.read(buf);
		cab.setImgEdicion(buf);
	
		File file2 = new File(rutaImgTerreno);
		FileInputStream fis2 = new FileInputStream(file2);
		BufferedInputStream bis2 = new BufferedInputStream(fis2);
		byte[] buf2 = new byte[(int) file.length()];
		bis.read(buf2);
		cab.setImgTerreno(buf2);
		
		session.save(cab);

		session.getTransaction().commit();
		session.close();
		
	}
	

	

	/**
	 * @throws Exception
	 *             *
	 ************************************************************************/

	public static void main(String[] args) throws Exception {

		// Crear todos los tiles
//
		crearTile('a', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/pastoseco.gif");
		crearTile('b', true, 0, 1, 1, "src/com/thinkingandlooking/Imagenes/Terreno/jardin.gif");
		crearTile('f', true, 0, -2, -1, "src/com/thinkingandlooking/Imagenes/Terreno/monte.gif");
		crearTile('i', true, 0, 1, -1, "src/com/thinkingandlooking/Imagenes/Terreno/tierra.gif");
		crearTile('H', true, 0, -1, 1, "src/com/thinkingandlooking/Imagenes/Terreno/siembra.gif");

		crearTile('g', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/piedras.gif");
		crearTile('h', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/rocas.gif");
		crearTile('p', true, 0, 0, -2, "src/com/thinkingandlooking/Imagenes/Terreno/lodo.gif");
		crearTile('o', true, 0, 2, 0, "src/com/thinkingandlooking/Imagenes/Terreno/crater.gif");
		crearTile('G', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/rocasgrandes.gif");

		crearTile('d', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/desierto.gif");
		crearTile('v', true, 0, 0, 0,"src/com/thinkingandlooking/Imagenes/Terreno/montañasdesierto.gif");
		crearTile('I', true, 0, 0, 0,"src/com/thinkingandlooking/Imagenes/Terreno/terrenodisparejo.gif");
		crearTile('s', true, 0, 1, -3,"src/com/thinkingandlooking/Imagenes/Terreno/montañaneblina.gif");
		crearTile('c', true, 0, -1, -1, "src/com/thinkingandlooking/Imagenes/Terreno/barro.gif");

		crearTile('e', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/nieve.gif");
		crearTile('t', true, 0, 2, -2, "src/com/thinkingandlooking/Imagenes/Terreno/montañanieve.gif");
		crearTile('u', true, 0, -2, 2, "src/com/thinkingandlooking/Imagenes/Terreno/montañanieve2.gif");
		crearTile('w', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/nieveinclinada.gif");

		crearTile('j', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/aguabaja.gif");
		crearTile('k', true, 0, 1, 1, "src/com/thinkingandlooking/Imagenes/Terreno/aguapiedras.gif");
		crearTile('l', true, 0, 0, -2, "src/com/thinkingandlooking/Imagenes/Terreno/aguaprofunda.gif");
		crearTile('m', true, 0, 2, 0, "src/com/thinkingandlooking/Imagenes/Terreno/aguarocas.gif");

		crearTile('y', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/precipicio.gif");
		crearTile('z', false, 0, 0, 0,	"src/com/thinkingandlooking/Imagenes/Terreno/precipiciolava.gif");
		crearTile('A', false, -1, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/obstaculo1.gif");
		crearTile('B', false, -1, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/obstaculo2.gif");
		crearTile('C', false, -1, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/obstaculo3.gif");
		crearTile('D', false, -3, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/obstaculo4.gif");

		crearTile('E', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/puenteh.gif");
		crearTile('F', true, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/puentev.gif");

		crearTile('n', false, -5, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/aura.gif");
		crearTile('q', false, -7, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/magma.gif");
		crearTile('r', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/molino.gif");
		crearTile('x', false, 5, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/oasis.gif");

		crearTile('1', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/castillo1.gif");
		crearTile('2', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/castillo2.gif");
		crearTile('3', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/castillo3.gif");
		crearTile('4', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/castillo4.gif");
		crearTile('5', false, 0, 0, 0, "src/com/thinkingandlooking/Imagenes/Terreno/castillo5.gif");

		// Creacion de todas las plantillas terreno
		crearPlantilla("Playa caribe", 1);
		crearPlantilla("Alpes rocoso", 2);
		crearPlantilla("Antartida arenosa", 3);
		crearPlantilla("Desierto pantanoso", 4);
		crearPlantilla("Artico", 5);

		// Creacion de los modelos de caballero
		modeloCaballero(1, 1, "Kun","src/com/thinkingandlooking/Imagenes/Caballero/Kun.jpg",  "src/com/thinkingandlooking/Imagenes/Caballero/Kun.jpg");
		modeloCaballero(1, 2, "Shen","src/com/thinkingandlooking/Imagenes/Caballero/Shen.jpg",  "src/com/thinkingandlooking/Imagenes/Caballero/Shen.jpg");
		modeloCaballero(2, 1, "Shena","src/com/thinkingandlooking/Imagenes/Caballero/Shena.jpg",  "src/com/thinkingandlooking/Imagenes/Caballero/Shena.jpg");
		modeloCaballero(3, 0, "Sheldon","src/com/thinkingandlooking/Imagenes/Caballero/Sheldon.jpg",  "src/com/thinkingandlooking/Imagenes/Caballero/Sheldon.jpg");
		
		// Creacion de modelos armas caballero


		insertarModeloArmaCaballero("Espada del Olvido",1, 2, 2, 1, 1000	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadelolvido.gif");
		insertarModeloArmaCaballero("Hacha Infinita",1, 3, 1, 2, 1000	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachainfinita.gif");
		insertarModeloArmaCaballero("Lanza de la Oscuridad",2, 3, 0, 3, 1000	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/lanzadelaoscuridad.gif");
		insertarModeloArmaCaballero("Martillo de la Luz",3, 4, 2, 2, 1000	, 30, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/martillodelaluz.gif");
		insertarModeloArmaCaballero("Mazo del Dolor",4, 3, 3, 3, 1000	, 35, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodeldolor.gif");

		insertarModeloArmaCaballero("Armadura de Espinas",2, 1, 1, 1, 100	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradeespinas.gif");	
		insertarModeloArmaCaballero("Armadura de Granito",2, 1, 3, 1, 150	, 30, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradegranito.gif");
		insertarModeloArmaCaballero("Armadura de Hueso",2, 2, 4, 1, 200	, 40, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradehueso.gif");
		insertarModeloArmaCaballero("Armadura del Hombre",2, 2, 6, 1, 300	, 45, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradelhombre.gif");
		insertarModeloArmaCaballero("Armadura del Muchacho",2, 3, 10, 1, 450	, 55, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradelmuchacho.gif");
		insertarModeloArmaCaballero("Armadura de Piel de Dragon",2, 4, 14, 1, 600	, 75, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradepieldedragon.gif");
		insertarModeloArmaCaballero("Armadura de Telaraña", 2,5, 20, 1, 800	, 95, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduradetelaraña.gif");
		insertarModeloArmaCaballero("Armadura Monsalve",2, 6, 25, 1, 1000	, 110, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/armaduramonsalve.gif");
		
		insertarModeloArmaCaballero("Casco de America",1, 1, 2, 1, 100	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodeamerica.gif");
		insertarModeloArmaCaballero("Casco de Gaviria",1, 2, 4, 1, 200	, 30, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodegaviria.gif");
		insertarModeloArmaCaballero("Casco del Aguila",1, 3, 6, 1, 300	, 35, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelaguila.gif");
		insertarModeloArmaCaballero("Casco de la Trinidad",1, 4, 8, 1, 400	, 40, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelatrinidad.gif");
		insertarModeloArmaCaballero("Casco del Chaman",1, 5, 10, 1, 500	, 50, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelchaman.gif");
		insertarModeloArmaCaballero("Casco del Guerrero",1, 6, 12, 1, 600	, 55, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelguerrero.gif");
		insertarModeloArmaCaballero("Casco del Indio",1, 7, 14, 1, 700	, 60, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelindio.gif");
		insertarModeloArmaCaballero("Casco del Rey",1, 8, 16, 1, 800	, 70, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodelrey.gif");
		insertarModeloArmaCaballero("Casco del Transformador",1, 9, 18, 1, 900	, 75, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascodeltranformador.gif");	
		insertarModeloArmaCaballero("Casco Milenario",1, 10, 20, 1, 1000	, 80, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cascomilenario.gif");
		

		
		insertarModeloArmaCaballero("Escudo Basico",3, 1, 2, 1, 80	, 35, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudobasico.gif");
		insertarModeloArmaCaballero("Escudo de Acero",3, 3, 4, 1, 160	, 45, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodeacero.gif");
		insertarModeloArmaCaballero("Escudo de Joenco",3, 5, 6, 1, 240	, 55, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodejoenco.gif");
		insertarModeloArmaCaballero("Escudo del Caleta",3, 7, 8, 1, 310	, 75, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodelcaleta.gif");
		insertarModeloArmaCaballero("Escudo del Craneo",3, 9, 10, 1, 380	, 95, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodelcraneo.gif");	
		insertarModeloArmaCaballero("Escudo de Madera",3, 11, 12, 1, 450	, 115, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodemadera.gif");
		insertarModeloArmaCaballero("Escudo de Metal",3, 13, 14, 1, 550	, 135, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudodemetal.gif");
		insertarModeloArmaCaballero("Escudo Incompleto",3, 15, 16, 1, 660	, 155, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/escudoincompleto.gif");
		

		insertarModeloArmaCaballero("Gorro de Cuero",1,1, 2, 1, 90	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/gorrodecuero.gif");
		insertarModeloArmaCaballero("Traje del Mago",2, 2, 4, 1, 180	, 35, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/trajedelmago.gif");
		insertarModeloArmaCaballero("Gorro del Nomuerto",1, 3, 6, 1, 270	, 55, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/gorrodelnomuerto.gif");
		insertarModeloArmaCaballero("Capa del Loro",2, 4, 2, 7, 360	, 70, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/capadelloro.gif");
		insertarModeloArmaCaballero("Traje de las Monedas",2, 5, 9, 1, 460	, 95, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/trajedelasmonedas.gif");
		insertarModeloArmaCaballero("Cetro de la Avaricia",3, 5, 11, 1, 570	, 110, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cetrodelaavaricia.gif");
		insertarModeloArmaCaballero("Cetro del Ruby",3, 6, 2, 14, 700	, 130, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cetrodelruby.gif");
		insertarModeloArmaCaballero("Catana del Poder",3, 6, 2, 16, 780	, 145, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/catanadelpoder.gif");
		insertarModeloArmaCaballero("Chuzo de la Reina",3, 7, 2, 18, 900	, 165, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/chuzodelareina.gif");
		insertarModeloArmaCaballero("Cetro de la Lujuria",3, 7, 2, 21, 1000	, 180, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/cetrodelalujuria.gif");
		insertarModeloArmaCaballero("Mascara del Burlon",1, 8, 2, 23, 1100	, 195, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mascaradelburlon.gif");
		insertarModeloArmaCaballero("Traje del Hechicero",2, 8, 2, 25, 1300	, 215, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/trajedelhechicero.gif");
		
		
		
		
		insertarModeloArmaCaballero("Espada de Demian",1, 3, 1, 1, 300	, 15, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadedemian.gif");
		insertarModeloArmaCaballero("Espada de Fannia",1, 6, 2, 1, 350	, 35, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadefannia.gif");	
		insertarModeloArmaCaballero("Espada de Fuego",1,9, 3, 1, 400	, 40, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadefuego.gif");
		insertarModeloArmaCaballero("Espada de la Luz",1, 12, 4, 1, 440	, 55, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadelaluz.gif");
		insertarModeloArmaCaballero("Espada del Olvido",1, 15, 5, 1, 490	, 70, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadelolvido.gif");
		insertarModeloArmaCaballero("Espada de Oro",1, 18, 6, 1, 530	, 90, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadeoro.gif");
		insertarModeloArmaCaballero("Espada Dorada",1, 21, 7, 1, 600	, 110, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadadorada.gif");	
		insertarModeloArmaCaballero("Espada del Sabio",1, 24, 8, 1, 630	, 130, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadaldelsabio.gif");
		insertarModeloArmaCaballero("Espada Luminosa",1, 27, 9, 1, 680	, 155, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadaluminosa.gif");
		insertarModeloArmaCaballero("Espada Moughawiche",1, 30, 10, 1, 720	, 170, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadamoughawiche.gif");
		insertarModeloArmaCaballero("Espada Siloe",1, 33, 11, 1, 760	, 190, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadasiloe.gif");
		insertarModeloArmaCaballero("Espada Simbolica",1, 36, 12, 1, 800	, 220, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/espadasimbolica.gif");
		
		
		
		insertarModeloArmaCaballero("Hacha",3, 4, 2, 1, 150	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hacha.gif");
		insertarModeloArmaCaballero("Hacha del Aprendiz",3, 8, 4, 1, 300	, 40, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachadelaprendiz.gif");	
		insertarModeloArmaCaballero("Hacha de Lava",3, 12, 6, 1, 450	, 60, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachadelava.gif");
		insertarModeloArmaCaballero("Hacha del Consumo",3, 16, 8, 1, 600	, 80, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachadelconsumo.gif");
		insertarModeloArmaCaballero("Hacha Infinita",3, 20, 10, 2, 750	, 100, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachainfinita.gif");
		insertarModeloArmaCaballero("Hacha Macabra",3, 24, 12, 1, 900	, 140, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachamacabra.gif");
		insertarModeloArmaCaballero("Hacha Redodna",3, 28, 14, 1, 1050	, 180, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hacharedonda.gif");
		insertarModeloArmaCaballero("Hacha Violenta",3, 32, 16, 1, 1300	, 250, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/hachaviolenta.gif");
		
		insertarModeloArmaCaballero("Mazo Clasico",3, 2, 2, 1, 100	, 15, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazoclasico.gif");
		insertarModeloArmaCaballero("Mazo de Bronce",3, 5, 5, 1, 200	, 35, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodebronce.gif");
		insertarModeloArmaCaballero("Mazo de Gabriel",3, 7, 7, 1, 300	, 55, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodegabriel.gif");
		insertarModeloArmaCaballero("Mazo de la Miseria",3, 10, 10, 1, 400	, 75, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodelamiseria.gif");
		insertarModeloArmaCaballero("Mazo del Dolor",3, 12, 12, 3, 500	, 95, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodeldolor.gif");
		insertarModeloArmaCaballero("Mazo del Esqueleto",3, 15, 15, 1, 600	, 115, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodelesqueleto.gif");
		insertarModeloArmaCaballero("Mazo del Tormento",3, 17, 17, 1, 700	, 135, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodeltormento.gif");
		insertarModeloArmaCaballero("Mazo de Puas", 3,20, 20, 1, 800	, 155, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazodepuas.gif");
		insertarModeloArmaCaballero("Mazo Gigante",3, 22, 22, 1, 900	, 175, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazogigante.gif");
		insertarModeloArmaCaballero("Mazo Punta de Cubo", 3,25, 25, 1, 1000	, 195, 7, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/mazopuntadecubo.gif");
		
		insertarModeloArmaCaballero("Sable Congelado",3, 3, 2, 1, 65	, 20, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/sablecongelado.gif");
		insertarModeloArmaCaballero("Lanza de la Oscuridad",3, 5, 3, 3, 130	, 40, 1, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/lanzadelaoscuridad.gif");
		insertarModeloArmaCaballero("Sable de Urano",3, 7, 4, 1, 195	, 60, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/sabledeurano.gif");
		insertarModeloArmaCaballero("Garras del Gavilan",3, 9, 5, 1, 260	, 80, 2, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/garrasdelgavilan.gif");
		insertarModeloArmaCaballero("Sable de la Luz",3, 11, 6, 1, 325	, 100, 3, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/sabledelaluz.gif");
		insertarModeloArmaCaballero("Manopla del Oso",3, 14, 7, 1, 390	, 120, 4, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/manopladeloso.gif");
		insertarModeloArmaCaballero("Sable del Tiempo", 3,18, 8, 1, 455	, 140, 5, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/sabledeltiempo.gif");
		insertarModeloArmaCaballero("Martillo de la Luz", 3,22, 9, 2, 510	, 160, 6, "src/com/thinkingandlooking/Imagenes/ArmaCaballero/martillodelaluz.gif");
		
		
		
		// Creacion de los modelos de armas terreno
		
		insertarModeloArmaTerreno("Ballesta Gigante", 20, 5, 4, 20, 22, 4, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/ballestagigante.gif");
		insertarModeloArmaTerreno("Bicho Feo", 13, 13, 1, 10, 25, 4, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/bichofeo.gif");
		insertarModeloArmaTerreno("Cadenas Esclavas", 8, 16, 1, 10, 24, 4, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/cadenasesclavas.gif");
		insertarModeloArmaTerreno("Caninos Sangrientos", 15, 10, 1, 15, 23, 4, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/caninossangrientos.gif");
		insertarModeloArmaTerreno("Catapulta Gitante", 19, 6, 4, 20, 22, 4, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/catapultagigante.gif");

		insertarModeloArmaTerreno("Demonio Rojo", 10, 9, 2, 1, 19, 3, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/demoniorojo.gif");
		insertarModeloArmaTerreno("Lagarto Aguatero", 9, 8, 1, 10, 17, 3, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/lagartoaguatero.gif");
		insertarModeloArmaTerreno("Ojo de Fuego", 18, 1, 2, 10, 18, 3, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/ojodefuego.gif");
		insertarModeloArmaTerreno("Ojo de Hielo", 18, 2, 1, 10, 18, 3, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/ojodehielo.gif");
		insertarModeloArmaTerreno("PXNDX", 10, 6, 1, 15, 16, 3, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/pxndx.gif");

		insertarModeloArmaTerreno("Simio Amarillo", 5, 5, 1, 5, 11, 2, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/simioamarillo.gif");
		insertarModeloArmaTerreno("Taurox", 5, 8, 1, 10, 13, 2, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/taurox.gif");
		insertarModeloArmaTerreno("Tigre Dientes con Sarro", 8, 3, 1, 10, 14, 2, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/tigredientesconsarro.gif");
		insertarModeloArmaTerreno("Torre de Arqueros", 6, 4, 4, 15, 13, 2, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/torredearqueros.gif");
		insertarModeloArmaTerreno("Torre Electrica", 7, 5, 3, 20, 12, 2, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/torreelectrica.gif");
	
		insertarModeloArmaTerreno("Barril Explosivo", 5, 1, 3, 1, 8, 1, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/barrilexplosivo.gif");
		insertarModeloArmaTerreno("Lagarto Hambriento", 3, 3, 1, 10, 4, 1, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/lagartohambriento.gif");
		insertarModeloArmaTerreno("Molotov Medieval", 4, 1, 2, 1, 3, 1, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/molotovmedieval.gif");
		insertarModeloArmaTerreno("Planta Venenosa", 3, 3, 2, 10, 6, 1, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/plantavenenosa.gif");
		insertarModeloArmaTerreno("Roedores Asesinos", 1, 5, 1, 20, 4, 1, "src/com/thinkingandlooking/Imagenes/ArmaTerreno/roedoresasesinos.gif");
		// Creacion de las destrezas

		
	}
}
