package BD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import BD.SessionHibernate;

public class loadBD {

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
				coor.setId(i);
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

	/**
	 * @throws Exception
	 *             *
	 ************************************************************************/

	public static void main(String[] args) throws Exception {

		// Crear todos los tiles

		crearTile('a', true, 0, 0, 0, "src/Imagenes/Terreno/pastoseco.gif");
		crearTile('b', true, 0, 1, 1, "src/Imagenes/Terreno/jardin.gif");
		crearTile('f', true, 0, -2, -1, "src/Imagenes/Terreno/monte.gif");
		crearTile('i', true, 0, 1, -1, "src/Imagenes/Terreno/tierra.gif");
		crearTile('H', true, 0, -1, 1, "src/Imagenes/Terreno/siembra.gif");

		crearTile('g', true, 0, 0, 0, "src/Imagenes/Terreno/piedras.gif");
		crearTile('h', true, 0, 0, 0, "src/Imagenes/Terreno/rocas.gif");
		crearTile('p', true, 0, 0, -2, "src/Imagenes/Terreno/lodo.gif");
		crearTile('o', true, 0, 2, 0, "src/Imagenes/Terreno/crater.gif");
		crearTile('G', true, 0, 0, 0, "src/Imagenes/Terreno/rocasgrandes.gif");

		crearTile('d', true, 0, 0, 0, "src/Imagenes/Terreno/desierto.gif");
		crearTile('v', true, 0, 0, 0,"src/Imagenes/Terreno/montañasdesierto.gif");
		crearTile('I', true, 0, 0, 0,"src/Imagenes/Terreno/terrenodisparejo.gif");
		crearTile('s', true, 0, 1, -3,"src/Imagenes/Terreno/montañaneblina.gif");
		crearTile('c', true, 0, -1, -1, "src/Imagenes/Terreno/barro.gif");

		crearTile('e', true, 0, 0, 0, "src/Imagenes/Terreno/nieve.gif");
		crearTile('t', true, 0, 2, -2, "src/Imagenes/Terreno/montañanieve.gif");
		crearTile('u', true, 0, -2, 2, "src/Imagenes/Terreno/montañanieve2.gif");
		crearTile('w', true, 0, 0, 0, "src/Imagenes/Terreno/nieveinclinada.gif");

		crearTile('j', true, 0, 0, 0, "src/Imagenes/Terreno/aguabaja.gif");
		crearTile('k', true, 0, 1, 1, "src/Imagenes/Terreno/aguapiedras.gif");
		crearTile('l', true, 0, 0, -2, "src/Imagenes/Terreno/aguaprofunda.gif");
		crearTile('m', true, 0, 2, 0, "src/Imagenes/Terreno/aguarocas.gif");

		crearTile('y', false, 0, 0, 0, "src/Imagenes/Terreno/precipicio.gif");
		crearTile('z', false, 0, 0, 0,	"src/Imagenes/Terreno/precipiciolava.gif");
		crearTile('A', false, -1, 0, 0, "src/Imagenes/Terreno/obstaculo1.gif");
		crearTile('B', false, -1, 0, 0, "src/Imagenes/Terreno/obstaculo2.gif");
		crearTile('C', false, -1, 0, 0, "src/Imagenes/Terreno/obstaculo3.gif");
		crearTile('D', false, -3, 0, 0, "src/Imagenes/Terreno/obstaculo4.gif");

		crearTile('E', true, 0, 0, 0, "src/Imagenes/Terreno/puenteh.gif");
		crearTile('F', true, 0, 0, 0, "src/Imagenes/Terreno/puentev.gif");

		crearTile('n', false, -5, 0, 0, "src/Imagenes/Terreno/aura.gif");
		crearTile('q', false, -7, 0, 0, "src/Imagenes/Terreno/magma.gif");
		crearTile('r', false, 0, 0, 0, "src/Imagenes/Terreno/molino.gif");
		crearTile('x', false, 5, 0, 0, "src/Imagenes/Terreno/oasis.gif");

		crearTile('1', false, 0, 0, 0, "src/Imagenes/Terreno/castillo1.gif");
		crearTile('2', false, 0, 0, 0, "src/Imagenes/Terreno/castillo2.gif");
		crearTile('3', false, 0, 0, 0, "src/Imagenes/Terreno/castillo3.gif");
		crearTile('4', false, 0, 0, 0, "src/Imagenes/Terreno/castillo4.gif");
		crearTile('5', false, 0, 0, 0, "src/Imagenes/Terreno/castillo5.gif");

		// Creacion de todas las plantillas terreno
		crearPlantilla("Nombre1", 1);
		crearPlantilla("Nombre2", 2);
		crearPlantilla("Nombre3", 3);
		crearPlantilla("Nombre4", 4);
		crearPlantilla("Nombre5", 5);

		// Creacion de los modelos de caballero

		// Creacion de modelos armas

		// Creacion de los modelos de armas terreno

		// Creacion de las destrezas

	}
}
