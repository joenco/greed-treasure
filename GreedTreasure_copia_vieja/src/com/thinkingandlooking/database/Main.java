package com.thinkingandlooking.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {

  public static void main(String[] args) {
    Configuration configuration = new AnnotationConfiguration();
    configuration.configure("com/thinkingandlooking/database/hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    User bean = new User();
    bean.setNick("a");
    bean.setPass("a");
    bean.setCantOro(1000);
    bean.setNivel(1);
    bean.setVictoria(0);
    bean.setDerrota(0);
    bean.setName("Jorge");
    bean.setLastName("Ortega");
    bean.setCountry("Venezuela");
    bean.setEmail("joenco@esdebian.org");
    bean.setTerreno("TerrenoPlaya");
    bean.setCaballero("Gladiador");
    session.save(bean);

    session.getTransaction().commit();
    session.close();
  }
}
