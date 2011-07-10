package ArmaBean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {
public static void main(String[] args) throws Exception {
	AnnotationConfiguration configuration = new AnnotationConfiguration();
    configuration.configure("/ArmaBean/hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    
    Usuario u = new Usuario ("Fannia","123","hermi");
    Arma a = new Arma("Bomba", 5, 7, 2, 3, 100,u);
    List <Arma> list = new ArrayList<Arma>();
    a.usar();
    File file = new File("/home/susi/workspace/ArmaBean/proyecto/Bomba.jpg");
    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);
    byte[] buf = new byte[(int) file.length()];
    bis.read(buf);
    a.setImagen(buf);
    list.add(a);
    u.setArmaList(list);
    session.save(u);
    session.save(a);
   a=null;
    
    a = new Arma("Espada", 5, 7, 2, 3, 100,u);
    File file1 = new File("/home/susi/workspace/ArmaBean/proyecto/espada.jpg");
    FileInputStream fis1 = new FileInputStream(file1);
    BufferedInputStream bis1 = new BufferedInputStream(fis1);
    byte[] buf1 = new byte[(int) file1.length()];
    bis1.read(buf1);
    a.setImagen(buf1);
    list.add(a);
    u.setArmaList(list);
    session.save(u);
    session.save(a);
    a=null;
    
    a = new Arma("Espada", 10, 5, 1, 3, 500,u);
    File file12 = new File("/home/susi/workspace/ArmaBean/proyecto/espada.jpg");
    FileInputStream fis2 = new FileInputStream(file12);
    BufferedInputStream bis2 = new BufferedInputStream(fis2);
    byte[] buf2 = new byte[(int) file12.length()];
    bis2.read(buf2);
    a.setImagen(buf2);
    list.add(a);
    u.setArmaList(list);
    session.save(u);
    session.save(a);
    a=null;
    
    a = new Arma("Flecha", 2, 7, 8, 1, 10,u);
    File file3 = new File("/home/susi/workspace/ArmaBean/proyecto/flecha.jpeg");
    FileInputStream fis3 = new FileInputStream(file3);
    BufferedInputStream bis3 = new BufferedInputStream(fis3);
    byte[] buf3 = new byte[(int) file3.length()];
    bis3.read(buf3);
    a.setImagen(buf3);
    list.add(a);
    u.setArmaList(list);
    session.save(u);
    session.save(a);
    
    a = new Arma("Flecha", 2, 7, 8, 1, 10,u);
    File file4 = new File("/home/susi/workspace/ArmaBean/proyecto/flecha.jpeg");
    FileInputStream fis4 = new FileInputStream(file4);
    BufferedInputStream bis4 = new BufferedInputStream(fis4);
    byte[] buf4 = new byte[(int) file4.length()];
    bis4.read(buf4);
    a.setImagen(buf4);
    list.add(a);
    u.setArmaList(list);
    session.save(u);
    session.save(a);
    
    session.getTransaction().commit();
    session.close();
	}
}
