package ArmaBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) {
	Configuration configuration = new AnnotationConfiguration();
    configuration.configure("/ArmaBean/hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Arma a = new Arma();
    for (int i = 0; i < 5; i++) {
      Usuario u = new Usuario();
      Inventario inv = new Inventario();

      inv.setArmaRef(a);
      inv.setUserRef(u);
      a.getInventList().add(inv);
      u.getInList().add(inv);

      session.save(a);
      session.save(u);
    }

    Usuario u = new Usuario();
    for (int i = 0; i < 5; i++) {
      a = new Arma();

      Inventario inv = new Inventario();

      inv.setArmaRef(a);
      inv.setUserRef(u);
      a.getInventList().add(inv);
      u.getInList().add(inv);

      session.save(a);
      session.save(u);
    }

    session.getTransaction().commit();
    session.close();
}
}
