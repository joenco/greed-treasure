package BD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ObtenerImgTerreno {
	
	public static byte[] obtenerImg(char charId) {
		byte[] img = new byte[7000];
		Tile tile = new Tile();

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		tile = (Tile) session.load(Tile.class, charId);
		img = tile.getImg();
		session.getTransaction().commit();
		session.close();
		return img;
	}
	
}