package prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		  Configuration configuration = new AnnotationConfiguration();
		    configuration.configure("/prueba/hibernate.cfg.xml");
		    SessionFactory sessionFactory = configuration.buildSessionFactory();

		    Session session = sessionFactory.openSession();
		    session.beginTransaction();

		    Usuario u = new Usuario();
		    Caballero c = new Caballero();
		    c.setNombre("CAMELOT");
		    u.setClave("funciono");
		    u.setLogin("Paris");
		    u.setNombre("Star Trek Voyager");
		    u.setCaballero(c);
		    //    c.setPersona(p);

		    session.save(u);

		    session.getTransaction().commit();
		    session.close();
	}
}
