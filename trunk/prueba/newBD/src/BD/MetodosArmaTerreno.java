package BD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class MetodosArmaTerreno {
	public static List<ModeloArmaTerreno> tablaPrincipal(Usuario user) {
		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
		String str = "SELECT DISTINCT a.modelRef AS c FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		List<ModeloArmaTerreno> list = new ArrayList<ModeloArmaTerreno>();
		for (Object obj : query.list()) {
			ModeloArmaTerreno ma = (ModeloArmaTerreno) obj;
			list.add(ma);
			System.err.println(ma.getId() + "; " + ma.getNombre());
		}
		session.getTransaction().commit();
		session.close();
		return list;

	}

	public static List<Object> tablaPorArma(Usuario user, String nombre) {

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();

		String str = "SELECT a.modelRef.nombre, a.modelRef.defensa, a.modelRef.alcanse, a.modelRef.oro, a.municiones_actuales, a.id FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login AND a.modelRef.nombre = :nombre";
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

	public static ArmaTerreno usarArmaTerreno(int x, int y, int id) {

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
		
		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.id = :id";
		Query query = session.createQuery(str);
		query.setInteger("id", id);
		
		ArmaTerreno armaT = new ArmaTerreno();
		armaT = (ArmaTerreno) query.uniqueResult();
		
		CoordenadaArma coor = new CoordenadaArma();
		coor.setArmaTerrenoRef(armaT);
		coor.setX(x);
		coor.setY(y);
		armaT.setCoorArmaRef(coor);
		String queryStr = "UPDATE ArmaTerreno SET armaT WHERE id = :id";
        Query query1 = session.createSQLQuery(queryStr);
        query1.setInteger("id", armaT.getId());
        query1.executeUpdate();
        
		session.save (coor);
		session.getTransaction().commit();
		session.close();
		return armaT;
	}
	
/*	public static void devolverArmaTerreno(ArmaTerreno armaT){
		CoordenadaArma coor = new CoordenadaArma();
		coor = armaT.getCoorArmaRef();
		coor.setArmaTerrenoRef(null);		
		armaT.setCoorArmaRef(null);
		
		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
        
        String queryStr = "UPDATE ArmaTerreno SET armaT = now() WHERE id = :id";
        Query query = session.createSQLQuery(queryStr);
        query.setInteger("idUser", armaT.getId());
        query.executeUpdate();
        
        session.getTransaction().commit();
		session.close();
        
	}*/
}
