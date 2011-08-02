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

		String str = "SELECT a.modelRef.nombre, a.modelRef.defensa, a.modelRef.alcance, a.modelRef.oro, a.municiones_actuales, a.id FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login AND a.modelRef.nombre = :nombre";
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
		ArmaTerreno armaT = new ArmaTerreno();
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.id = :id";
		Query query = session.createQuery(str);
		query.setInteger("id", id);
		armaT = (ArmaTerreno) query.uniqueResult();
		CoordenadaArma coor = new CoordenadaArma();
		coor.setArmaTerrenoRef(armaT);
		coor.setX(x);
		coor.setY(y);
		session.save(coor);
		session.getTransaction().commit();
		session.close();
		// lee esto porfa
		// Es esta parte que esta comentada, porq intento actualizar el arma
		// para que tenga el id
		// de la entidad coordenada pero no funciona. me parece q el problema
		// esta en la realcion
		// armaterreno coordenadaarma, lo intente de varias formas y nada
		// para llenar la base de datos rapidito corre pruebaLlenada
		// luego corres MetodosArmaTerreno, pero tienes q colocar los id de
		// usuario, caballero y armaterreno

		/*
		 * Session session1 = SessionHibernate.getInstance().openSession();
		 * session1.beginTransaction(); armaT.setCoorArmaRef(coor); String
		 * queryStr =
		 * "UPDATE ArmaTerreno SET ArmaTerreno = armaT WHERE id = :id"; Query
		 * query1 = session1.createSQLQuery(queryStr); query1.setInteger("id",
		 * armaT.getId()); // query1.setInteger("coor", coor.getId());
		 * query1.executeUpdate();
		 * 
		 * session1.save (coor); session1.getTransaction().commit();
		 * session1.close();
		 */
		return armaT;
	}

	public static void devolverArmaTerreno(ArmaTerreno armaT) {
		CoordenadaArma coor = new CoordenadaArma();
		coor = armaT.getCoorArmaRef();

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String queryStr = "UPDATE CoordenadaArma SET armaTerrenoRef IS null WHERE id = :id";
		Query query = session.createSQLQuery(queryStr);
		query.setInteger("id", coor.getId());
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();

	}

	public static void venderArmaTerreno(Caballero Vendedor,
			Caballero Comprador, ArmaTerreno ArmaVender) {
		Vendedor.getArmaTerrenoList().remove(ArmaVender);
		Comprador.getArmaTerrenoList().add(ArmaVender);
		ArmaVender.setCaballeroRef(Comprador);
		int oroComprador;
		oroComprador = Comprador.getOro() - ArmaVender.getModelRef().getOro();
		Comprador.setOro(oroComprador);
		int oroVendedor;
		oroVendedor = Vendedor.getOro() + ArmaVender.getModelRef().getOro();
		Vendedor.setOro(oroVendedor);

		// realizar el update
	}

	public static List<ModeloArmaTerreno> mostrarArmasInventario() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		String str = "SELECT DISTINCT m FROM ModeloArmaTerreno AS m";
		Query query = session.createQuery(str);
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

	public static void comprarDelInventario(Caballero Comprador,
			ModeloArmaTerreno modeloArmaT) {
		ArmaTerreno armaT = new ArmaTerreno();
		armaT.setCaballeroRef(Comprador);
		armaT.setModelRef(modeloArmaT);
		armaT.setMuniciones_actuales(modeloArmaT.getMuniciones_base());
		Comprador.getArmaTerrenoList().add(armaT);
		modeloArmaT.getArmaTerrenoList().add(armaT);
		int oroComprador;
		oroComprador = Comprador.getOro() - modeloArmaT.getOro();
		Comprador.setOro(oroComprador);
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		// update
		session.save(armaT);
		session.getTransaction().commit();
		session.close();
	}
	public static void venderAlInventario(Caballero Vendedor,
			ArmaTerreno ArmaVender) {
		
		Vendedor.getArmaTerrenoList().remove(ArmaVender);
		int oroVendedor;
		oroVendedor = Vendedor.getOro() + ArmaVender.getModelRef().getOro();
		Vendedor.setOro(oroVendedor);
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		// update caballero
		// borrar la arma vendida
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		Usuario user = new Usuario();
		Caballero cab = new Caballero();

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		user = (Usuario) session.load(Usuario.class, 12290);
		cab = (Caballero) session.load(Caballero.class, 1230);

		session.getTransaction().commit();
		session.close();
		Object aux;

		tablaPrincipal(user);
		aux = tablaPorArma(user, "Bomba");
		usarArmaTerreno(1, 5, 12330);
		/*Usuario user = new Usuario ();
		user.setNombre("sujaira");
		user.setEmail("susi141");
		user.setLogin("susi");
		user.setPais("Vene");
		user.setPassword(123);
		
		Caballero cab = new Caballero ();
		cab.setAtaque(10);
		cab.setNivel(10);
		cab.setUsuario(user);
		
		ModeloArmaTerreno model = new ModeloArmaTerreno();
		model.setNombre("Bomba");
		model.setDefensa(10);
		model.setAlcance(2);
		model.setMuniciones_base(2);
		model.setNivel(1);
		model.setOro(100);
		
		ArmaTerreno armaT = new ArmaTerreno();
		armaT.setCaballeroRef(cab);
		armaT.setModelRef(model);
		armaT.setMuniciones_actuales(model.getMuniciones_base());
		
		CoordenadaArma coor = new CoordenadaArma();
		coor.setX(10);
		coor.setY(2);
		coor.setArmaTerrenoRef(armaT);
		armaT.setCoorArmaRef(coor);
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		session.save(user);
		session.save(armaT);
		session.save(coor);
		
		session.getTransaction().commit();
		session.close();*/
	} 
}
