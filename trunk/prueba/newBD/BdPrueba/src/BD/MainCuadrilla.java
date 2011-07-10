package BD;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.hibernate.AnnotationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import BD.Cuadrilla;


public class MainCuadrilla {
	public static void main(String[] args) throws Exception {
	    AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure("/BD/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();

	    Session session = sessionFactory.openSession();
	    session.beginTransaction();

	    Cuadrilla a = new Cuadrilla();
	    a.setEsOcupable(true);
	    a.setCharId('a');
	    File file = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/a.gif");
	    FileInputStream fis = new FileInputStream(file);
	    BufferedInputStream bis = new BufferedInputStream(fis);
	    byte[] buf = new byte[(int) file.length()];
	    bis.read(buf);
	    a.setImg(buf);
	    session.save(a);
	        	        	      
	    Cuadrilla b = new Cuadrilla();
	    b.setEsOcupable(true);
	    b.setCharId('b');
	    File bfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/b.gif");
	    FileInputStream bfis = new FileInputStream(bfile);
	    BufferedInputStream bbis = new BufferedInputStream(bfis);
	    byte[] bbuf = new byte[(int) file.length()];
	    bbis.read(bbuf);
	    b.setImg(bbuf);
	    session.save(b);
	    
	    Cuadrilla c = new Cuadrilla();
	    c.setEsOcupable(true);
	    c.setCharId('c');
	    File cfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/c.gif");
	    FileInputStream cfis = new FileInputStream(cfile);
	    BufferedInputStream cbis = new BufferedInputStream(cfis);
	    byte[] cbuf = new byte[(int) file.length()];
	    cbis.read(cbuf);
	    c.setImg(cbuf);
	    session.save(c);

	    Cuadrilla d = new Cuadrilla();
	    d.setEsOcupable(true);
	    d.setCharId('d');
	    File dfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/d.gif");
	    FileInputStream dfis = new FileInputStream(dfile);
	    BufferedInputStream dbis = new BufferedInputStream(dfis);
	    byte[] dbuf = new byte[(int) file.length()];
	    dbis.read(dbuf);
	    d.setImg(dbuf);
   	    session.save(d);
	    
	    Cuadrilla e = new Cuadrilla();
	    e.setEsOcupable(true);
  	    e.setCharId('e');
	    File efile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/e.gif");
	    FileInputStream efis = new FileInputStream(efile);
	    BufferedInputStream ebis = new BufferedInputStream(efis);
	    byte[] ebuf = new byte[(int) file.length()];
	    ebis.read(ebuf);
	    e.setImg(ebuf);
   	    session.save(e);
   
   	    Cuadrilla f = new Cuadrilla();
	    f.setEsOcupable(true);
	    f.setCharId('f');
	    File ffile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/f.gif");
	    FileInputStream ffis = new FileInputStream(ffile);
	    BufferedInputStream fbis = new BufferedInputStream(ffis);
	    byte[] fbuf = new byte[(int) file.length()];
	    fbis.read(fbuf);
	    f.setImg(fbuf);
	    session.save(f);
   	    
	    Cuadrilla g = new Cuadrilla();
	    g.setEsOcupable(true);
	    g.setCharId('g');
	    File gfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/g.gif");
	    FileInputStream gfis = new FileInputStream(gfile);
	    BufferedInputStream gbis = new BufferedInputStream(gfis);
	    byte[] gbuf = new byte[(int) file.length()];
	    gbis.read(gbuf);
	    g.setImg(gbuf);
	    session.save(g);
	    
	    Cuadrilla h = new Cuadrilla();
	    h.setEsOcupable(true);
	    h.setCharId('h');
	    File hfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/h.gif");
	    FileInputStream hfis = new FileInputStream(hfile);
	    BufferedInputStream hbis = new BufferedInputStream(hfis);
	    byte[] hbuf = new byte[(int) file.length()];
	    hbis.read(hbuf);
	    h.setImg(hbuf);
	    session.save(h);
	    
	    Cuadrilla i = new Cuadrilla();
	    i.setEsOcupable(true);
	    i.setCharId('i');
	    File ifile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/i.gif");
	    FileInputStream ifis = new FileInputStream(ifile);
	    BufferedInputStream ibis = new BufferedInputStream(ifis);
	    byte[] ibuf = new byte[(int) file.length()];
	    ibis.read(ibuf);
	    i.setImg(ibuf);
	    session.save(i);
	    
	    Cuadrilla j = new Cuadrilla();
	    j.setEsOcupable(true);
	    j.setCharId('j');
	    File jfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/j.gif");
	    FileInputStream jfis = new FileInputStream(jfile);
	    BufferedInputStream jbis = new BufferedInputStream(jfis);
	    byte[] jbuf = new byte[(int) file.length()];
	    jbis.read(jbuf);
	    j.setImg(jbuf);
	    session.save(j);
	    
	    Cuadrilla k = new Cuadrilla();
	    k.setEsOcupable(true);
	    k.setCharId('k');
	    File kfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/k.gif");
	    FileInputStream kfis = new FileInputStream(kfile);
	    BufferedInputStream kbis = new BufferedInputStream(kfis);
	    byte[] kbuf = new byte[(int) file.length()];
	    kbis.read(kbuf);
	    k.setImg(kbuf);
	    session.save(k);
	    
	    Cuadrilla l = new Cuadrilla();
	    l.setEsOcupable(true);
	    l.setCharId('l');
	    File lfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/l.gif");
	    FileInputStream lfis = new FileInputStream(lfile);
	    BufferedInputStream lbis = new BufferedInputStream(lfis);
	    byte[] lbuf = new byte[(int) file.length()];
	    lbis.read(lbuf);
	    l.setImg(lbuf);
	    session.save(l);
	    
	    Cuadrilla m = new Cuadrilla();
	    m.setEsOcupable(true);
	    m.setCharId('m');
	    File mfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/m.gif");
	    FileInputStream mfis = new FileInputStream(mfile);
	    BufferedInputStream mbis = new BufferedInputStream(mfis);
	    byte[] mbuf = new byte[(int) file.length()];
	    mbis.read(mbuf);
	    m.setImg(mbuf);
	    session.save(m);
	    
	    Cuadrilla n = new Cuadrilla();
	    n.setEsOcupable(true);
	    n.setCharId('n');
	    File nfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/n.gif");
	    FileInputStream nfis = new FileInputStream(nfile);
	    BufferedInputStream nbis = new BufferedInputStream(nfis);
	    byte[] nbuf = new byte[(int) file.length()];
	    nbis.read(nbuf);
	    n.setImg(nbuf);
	    session.save(n);
	    
	    Cuadrilla o = new Cuadrilla();
	    o.setEsOcupable(true);
	    o.setCharId('o');
	    File ofile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/o.gif");
	    FileInputStream ofis = new FileInputStream(ofile);
	    BufferedInputStream obis = new BufferedInputStream(ofis);
	    byte[] obuf = new byte[(int) file.length()];
	    obis.read(obuf);
	    o.setImg(obuf);
	    session.save(o);
	    
	    Cuadrilla p = new Cuadrilla();
	    p.setEsOcupable(true);
	    p.setCharId('p');
	    File pfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/p.gif");
	    FileInputStream pfis = new FileInputStream(pfile);
	    BufferedInputStream pbis = new BufferedInputStream(pfis);
	    byte[] pbuf = new byte[(int) file.length()];
	    pbis.read(pbuf);
	    p.setImg(pbuf);
	    session.save(p);
   	    
	    Cuadrilla q = new Cuadrilla();
	    q.setEsOcupable(true);
	    q.setCharId('q');
	    File qfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/q.gif");
	    FileInputStream qfis = new FileInputStream(qfile);
	    BufferedInputStream qbis = new BufferedInputStream(qfis);
	    byte[] qbuf = new byte[(int) file.length()];
	    qbis.read(qbuf);
	    q.setImg(qbuf);
	    session.save(q);
	    
	    Cuadrilla r = new Cuadrilla();
	    r.setEsOcupable(true);
	    r.setCharId('r');
	    File rfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/r.gif");
	    FileInputStream rfis = new FileInputStream(rfile);
	    BufferedInputStream rbis = new BufferedInputStream(rfis);
	    byte[] rbuf = new byte[(int) file.length()];
	    rbis.read(rbuf);
	    r.setImg(rbuf);
	    session.save(r);
	    
	    Cuadrilla s = new Cuadrilla();
	    s.setEsOcupable(true);
	    s.setCharId('s');
	    File sfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/s.gif");
	    FileInputStream sfis = new FileInputStream(sfile);
	    BufferedInputStream sbis = new BufferedInputStream(sfis);
	    byte[] sbuf = new byte[(int) file.length()];
	    sbis.read(sbuf);
	    s.setImg(sbuf);
	    session.save(s);
	    
	    Cuadrilla t = new Cuadrilla();
	    t.setEsOcupable(true);
	    t.setCharId('t');
	    File tfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/t.gif");
	    FileInputStream tfis = new FileInputStream(tfile);
	    BufferedInputStream tbis = new BufferedInputStream(tfis);
	    byte[] tbuf = new byte[(int) file.length()];
	    tbis.read(tbuf);
	    t.setImg(tbuf);
	    session.save(t);
	    
	    Cuadrilla u = new Cuadrilla();
	    u.setEsOcupable(true);
	    u.setCharId('u');
	    File ufile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/u.gif");
	    FileInputStream ufis = new FileInputStream(ufile);
	    BufferedInputStream ubis = new BufferedInputStream(ufis);
	    byte[] ubuf = new byte[(int) file.length()];
	    ubis.read(ubuf);
	    u.setImg(ubuf);
	    session.save(u);
	    
	    Cuadrilla v = new Cuadrilla();
	    v.setEsOcupable(true);
	    v.setCharId('v');
	    File vfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/v.gif");
	    FileInputStream vfis = new FileInputStream(vfile);
	    BufferedInputStream vbis = new BufferedInputStream(vfis);
	    byte[] vbuf = new byte[(int) file.length()];
	    vbis.read(vbuf);
	    v.setImg(vbuf);
	    session.save(v);
	    
	    Cuadrilla w = new Cuadrilla();
	    w.setEsOcupable(true);
	    w.setCharId('w');
	    File wfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/w.gif");
	    FileInputStream wfis = new FileInputStream(wfile);
	    BufferedInputStream wbis = new BufferedInputStream(wfis);
	    byte[] wbuf = new byte[(int) file.length()];
	    wbis.read(wbuf);
	    w.setImg(wbuf);
	    session.save(w);
	    
	    Cuadrilla x = new Cuadrilla();
	    x.setEsOcupable(true);
	    x.setCharId('x');
	    File xfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/x.gif");
	    FileInputStream xfis = new FileInputStream(xfile);
	    BufferedInputStream xbis = new BufferedInputStream(xfis);
	    byte[] xbuf = new byte[(int) file.length()];
	    xbis.read(xbuf);
	    x.setImg(xbuf);
	    session.save(x);
	    
	    Cuadrilla y = new Cuadrilla();
	    y.setEsOcupable(true);
	    y.setCharId('y');
	    File yfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/y.gif");
	    FileInputStream yfis = new FileInputStream(yfile);
	    BufferedInputStream ybis = new BufferedInputStream(yfis);
	    byte[] ybuf = new byte[(int) file.length()];
	    ybis.read(ybuf);
	    y.setImg(ybuf);
	    session.save(y);
	    
	    Cuadrilla z = new Cuadrilla();
	    z.setEsOcupable(true);
	    z.setCharId('z');
	    File zfile = new File("/home/gsusgp/workspace/EdicionDeTerreno/src/com/thinkinglooking/terreno/Images/terreno/y.gif");
	    FileInputStream zfis = new FileInputStream(zfile);
	    BufferedInputStream zbis = new BufferedInputStream(zfis);
	    byte[] zbuf = new byte[(int) file.length()];
	    zbis.read(zbuf);
	    z.setImg(zbuf);
	    session.save(z);
	        	     	    	    
   	       	      	    
	    session.getTransaction().commit();
	    session.close();
	  }

}
