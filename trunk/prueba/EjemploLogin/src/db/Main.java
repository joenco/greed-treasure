package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {

  public static void main(String[] args) {
    Configuration configuration = new AnnotationConfiguration();
    configuration.configure("/db/hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    User bean = new User();
    bean.setNick("usuario");
    bean.setPass("123");
    bean.setName("Jorge Ortega");
    bean.setLastName("Ortega");
    bean.setCountry("Venezuela");
    bean.setEmail("joenco@esdebian.org");
    session.save(bean);

    session.getTransaction().commit();
    session.close();
  }
}
