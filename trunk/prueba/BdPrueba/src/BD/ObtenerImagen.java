package BD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ObtenerImagen {
	
	public static byte[] obtenerImg(char charId) {
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
	
}
