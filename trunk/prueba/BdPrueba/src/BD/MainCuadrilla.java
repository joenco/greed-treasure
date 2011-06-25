package BD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import BD.Cuadrilla;


public class MainCuadrilla {
	public static void main(String[] args) throws Exception {
	    Configuration configuration = new Configuration();
	    configuration.configure("/BD/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    Cuadrilla a = new Cuadrilla();

	    //CreoCuadrilla
	    a.setEsOcupable(true);
  
	    a.setCharId('a');
	    // XXX: beware with the path
	    File file = new File("/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/agua/arrecife.gif");
	    FileInputStream fis = new FileInputStream(file);
	    BufferedInputStream bis = new BufferedInputStream(fis);
	    byte[] buf = new byte[(int) file.length()];
	    bis.read(buf);
	    a.setImg(buf);
   	    
	    session.save(a);
	    session.getTransaction().commit();
	    //CreoCuadrilla\
	        	        	      
	    Cuadrilla b = new Cuadrilla();

	    //CreoCuadrilla
	    b.setEsOcupable(true);
  
	    b.setCharId('b');
	    // XXX: beware with the path
	    File bfile = new File("/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/agua/bosqueotono.gif");
	    FileInputStream bfis = new FileInputStream(bfile);
	    BufferedInputStream bbis = new BufferedInputStream(bfis);
	    byte[] bbuf = new byte[(int) file.length()];
	    bbis.read(bbuf);
	    b.setImg(bbuf);
   	    
	    session.save(b);
	    session.getTransaction().commit();
	    //CreoCuadrilla\
	    Cuadrilla c = new Cuadrilla();

	    //CreoCuadrilla
	    c.setEsOcupable(true);
  
	    c.setCharId('c');
	    // XXX: beware with the path
	    File cfile = new File("/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/agua/castilloagua.gif");
	    FileInputStream cfis = new FileInputStream(cfile);
	    BufferedInputStream cbis = new BufferedInputStream(cfis);
	    byte[] cbuf = new byte[(int) file.length()];
	    cbis.read(cbuf);
	    c.setImg(cbuf);
   	    
	    session.save(c);
	    session.getTransaction().commit();
	    //CreoCuadrilla\
	    Cuadrilla d = new Cuadrilla();

	    //CreoCuadrilla
	    d.setEsOcupable(true);
  
	    d.setCharId('d');
	    // XXX: beware with the path
	    File dfile = new File("/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/agua/pantanoagua.gif");
	    FileInputStream dfis = new FileInputStream(dfile);
	    BufferedInputStream dbis = new BufferedInputStream(dfis);
	    byte[] dbuf = new byte[(int) file.length()];
	    dbis.read(dbuf);
	    d.setImg(dbuf);
   	    
	    session.save(d);
	    session.getTransaction().commit();
	    //CreoCuadrilla\
	    Cuadrilla e = new Cuadrilla();

	    //CreoCuadrilla
	    e.setEsOcupable(true);
  
	    e.setCharId('a');
	    // XXX: beware with the path
	    File efile = new File("/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/agua/puente.gif");
	    FileInputStream efis = new FileInputStream(efile);
	    BufferedInputStream ebis = new BufferedInputStream(efis);
	    byte[] ebuf = new byte[(int) file.length()];
	    ebis.read(ebuf);
	    e.setImg(ebuf);
   	    
	    session.save(e);
	    session.getTransaction().commit();
	    //CreoCuadrilla\      	        
	    
	    session.close();
	  }

}
