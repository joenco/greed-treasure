package BD;

import org.hibernate.Session;

public class ObtenerImgTerreno {
	
	public static byte[] obtenerImg(char charId) {
		byte[] img = new byte[7000];
		Tile tile = new Tile();

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
        
		tile = (Tile) session.load(Tile.class, charId);
		img = tile.getImg();
		session.getTransaction().commit();
		session.close();
		return img;
	}
	
}