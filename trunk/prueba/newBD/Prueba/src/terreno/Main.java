package terreno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {
	
	
	public static void main(String[] args) {
		
	    Configuration configuration = new AnnotationConfiguration();
	    configuration.configure("/terreno/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();

	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    Terreno bean = new Terreno();
	    bean.setX("1");
	    bean.setY("2");
	    bean.setUsuario("Fannia");
	    bean.setTipo("d");
	    session.save(bean);

	    session.getTransaction().commit();
	    session.close();
	  }

}
