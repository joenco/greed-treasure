package BD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

public class Metodos {

	public static List<ModeloArma> tablaPrincipal(Usuario user) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// String str =
		// "SELECT a.modelRef FROM ArmaTerreno AS a WHERE a.refUser.login = '" +
		// user.getLogin() +"'";
		String str = "SELECT DISTINCT a.modelRef AS c FROM ArmaTerreno AS a WHERE a.refUser.login = :login";

		// String str =
		// "SELECT m.imagen, m.nombre, m.defensa, m.alcanse, m.oro, m.nivel FROM ModeloArma AS m, ArmaTerreno AS a WHERE m.id = a.refModel AND a.refUser.login = "+
		// user + " GROUP BY m.nombre";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		List<ModeloArma> list = new ArrayList<ModeloArma>();
		for (Object obj : query.list()) {
			// Object[] objArray = (Object[]) obj;
			ModeloArma ma = (ModeloArma) obj;
			list.add(ma);
			// System.out.println(objArray[0] + ";" + objArray[1]);
			System.err.println(ma.getId() + "; " + ma.getNombre());
		}
		session.getTransaction().commit();
		session.close();
		return list;

	}

	public static List<Object> tablaPorArma(Usuario user, String nombre) {

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String str = "SELECT a.modelRef.nombre, a.modelRef.defensa, a.modelRef.alcanse, a.modelRef.oro, a.municiones_actuales, a.id FROM ArmaTerreno AS a WHERE a.refUser.login = :login AND a.modelRef.nombre = :nombre";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		query.setString("nombre", nombre);
		List<Object> list = new ArrayList<Object>();
		for (Object obj : query.list()) {
			Object[] objArray = (Object[]) obj;
			list.add(obj);
			System.err.println("Nombre Defensa Alcance Oro Municiones");
			System.out.println(objArray[0] + " - " + objArray[1] + " - "
					+ objArray[2] + " - " + objArray[3] + " - " + objArray[4]);
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public static ArmaTerreno usarArmaTerreno(Usuario user, int x, int y, int id) {

		Configuration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.id = :id";
		Query query = session.createQuery(str);
		String idstring = " ";
		idstring = Integer.toString(id);
		query.setString("id", idstring);
		List<ArmaTerreno> list = new ArrayList<ArmaTerreno>();
		for (Object obj : query.list()) {
			ArmaTerreno at = (ArmaTerreno) obj;
			list.add(at);
			System.out.println(at.getId() + " - " + at.getMuniciones_actuales());
		}
		/*
		 * coordenadaArma cArma = new coordenadaArma(); cArma.setX(x)
		 * cArma.setX(x);
		 */
		session.getTransaction().commit();
		session.close();
		return list.get(0);
	}
}
