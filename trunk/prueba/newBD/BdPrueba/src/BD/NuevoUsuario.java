package BD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import BD.LoadTerreno;

public class NuevoUsuario {

	public static char[][] nuevoUsuario(String login, int pass, int tipo) {
		Usuario user = new Usuario();
		PlantillaTerreno pt = new PlantillaTerreno();
		user.setLogin(login);
		user.setPassword(pass);

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		pt = (PlantillaTerreno) session.load(PlantillaTerreno.class, tipo);
		pt.getUsuarioList().add(user);
		user.setIdRef(pt);

		session.save(user);

		session.getTransaction().commit();
		session.close();

		char[][] t = new char[16][16];
		t = LoadTerreno.loadData(login);

		return t;

	}

}
