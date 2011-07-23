package BD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Metodos {

	public static List<ModeloArma> tablaPrincipal(Usuario user) {
		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
		String str = "SELECT DISTINCT a.modelRef AS c FROM ArmaTerreno AS a WHERE a.refUser.login = :login";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		List<ModeloArma> list = new ArrayList<ModeloArma>();
		for (Object obj : query.list()) {
			ModeloArma ma = (ModeloArma) obj;
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

	public static ArmaTerreno usarArmaTerreno(int x, int y, int id) {

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
		
		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.id = :id";
		Query query = session.createQuery(str);
		query.setInteger("id", id);
		
		ArmaTerreno armaT = new ArmaTerreno();
		armaT = (ArmaTerreno) query.uniqueResult();
		
		coordenadaArma coor = new coordenadaArma();
		coor.setRefArma(armaT);
		coor.setX(x);
		coor.setY(y);

		session.getTransaction().commit();
		session.close();
		return armaT;
	}
}