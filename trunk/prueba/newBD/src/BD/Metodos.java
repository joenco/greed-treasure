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

		String str = "FROM ArmaTerreno AS a WHERE a.id = :id";
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

	public static void retornarArmaTerreno(ArmaTerreno armaT,
			int municiones_gastadas) {

		int municiones = armaT.getMuniciones_actuales();
		municiones = municiones - municiones_gastadas;
		armaT.setMuniciones_actuales(municiones);

		coordenadaArma coor;
		coor = armaT.getRefCoor();
		coor.setRefArma(null);

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = ""; // update con lo que el profe coloco en el foro...

		session.getTransaction().commit();
		session.close();
	}

	public static void venderArmaTerreno(Usuario vendedor, Usuario comprador,
			ArmaTerreno armaT) {
		List<ArmaTerreno> list = new ArrayList<ArmaTerreno>();
		list = vendedor.getArmaTerreno();

		for (ArmaTerreno obj : list) {
			if (obj.getId() == armaT.getId()) {
				list.remove(obj);
			}
		}
		armaT.setRefUser(comprador);
		comprador.getArmaTerreno().add(armaT);
		vendedor.setArmaTerreno(list);
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = ""; // update con lo que el profe coloco en el foro...

		session.getTransaction().commit();
		session.close();
	}
	
	public static ArmaTerreno llenarTablas(String nombreuser, String nombremodelo){
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		Usuario user = new Usuario ();
		user.setLogin(nombreuser);
		ModeloArma bomba = new ModeloArma();
		bomba.setNombre(nombremodelo);
		bomba.setDefensa(10);
		bomba.setAlcanse(20);
		bomba.setMuniciones_base(2);
		bomba.setNivel(3);
		bomba.setOro(30);
		ArmaTerreno armaT = new ArmaTerreno();
		armaT.setModelRef(bomba);
		armaT.setRefUser(user);
		armaT.setMuniciones_actuales(bomba.getMuniciones_base());
		bomba.getArmaTerreno().add(armaT);
		user.getArmaTerreno().add(armaT);
		session.save(user);
		session.save(bomba);
		session.save(armaT);
		session.getTransaction().commit();
		session.close();
		return armaT;
	} 
}