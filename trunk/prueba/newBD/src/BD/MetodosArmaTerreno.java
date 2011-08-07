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
		System.err.println("Nombre Defensa Alcance Oro Municiones");
		for (Object obj : query.list()) {
			Object[] objArray = (Object[]) obj;
			list.add(obj);
			System.out.println(objArray[0] + " - " + objArray[1] + " - "
					+ objArray[2] + " - " + objArray[3] + " - " + objArray[4] + " - " + objArray[5] );
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
		System.err.println(armaT.getMuniciones_actuales() + " ; "
				+ armaT.getId() + " ; " + coor.getId());
		return armaT;
	}

	public static void devolverArmaTerreno(ArmaTerreno armaT,
			int municiones_restantes) {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String queryStr = "DELETE FROM t_coordenada_arma WHERE id = :id";
		Query query = session.createSQLQuery(queryStr);
		query.setInteger("id", armaT.getId());
		query.executeUpdate();
	
		
		if (municiones_restantes > 0) {

			String queryStr_1 = "UPDATE t_arma_terreno SET municiones_actuales=:muni WHERE id = :id";
			Query query_1 = session.createSQLQuery(queryStr_1);
			query_1.setInteger("id", armaT.getId());
			query_1.setInteger("muni", municiones_restantes);
			query_1.executeUpdate();

		}
		else {
			String queryStr_2 = "DELETE FROM t_arma_terreno WHERE id = :id";
			Query query_2 = session.createSQLQuery(queryStr_2);
			query_2.setInteger("id", armaT.getId());
			query_2.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void venderArmaTerreno(Caballero Vendedor, Caballero Comprador, ArmaTerreno ArmaVender) {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		ArmaVender.setCaballeroRef(Comprador);
		
		String queryStr = "UPDATE t_arma_terreno SET caballeroref_id=:idcaballero WHERE id = :id";
		Query query = session.createSQLQuery(queryStr);
		query.setInteger("id", ArmaVender.getId());
		query.setInteger("idcaballero", Comprador.getId());
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		int oroComprador;
		oroComprador = Comprador.getOro() - ArmaVender.getModelRef().getOro();
		Comprador.setOro(oroComprador);
		int oroVendedor;
		oroVendedor = Vendedor.getOro() + ArmaVender.getModelRef().getOro();
		Vendedor.setOro(oroVendedor);
		
		updateCaballero(Vendedor);
		updateCaballero(Comprador);
		
	}

	public static void updateCaballero (Caballero cab){
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String queryStr = "UPDATE t_caballero SET oro=:oro WHERE id=:id";
		Query query = session.createSQLQuery(queryStr);
		query.setInteger("id", cab.getId());
		query.setInteger("oro", cab.getOro());
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
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

	public static void comprarDeLaTienda(Caballero Comprador,
			ModeloArmaTerreno modeloArmaT) {
		ArmaTerreno armaT = new ArmaTerreno();
		armaT.setCaballeroRef(Comprador);
		armaT.setModelRef(modeloArmaT);
		armaT.setMuniciones_actuales(modeloArmaT.getMuniciones_base());
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		session.save(armaT);
		
		session.getTransaction().commit();
		session.close();
		int oroComprador;
		oroComprador = Comprador.getOro() - modeloArmaT.getOro();
		Comprador.setOro(oroComprador);
		updateCaballero(Comprador);
	}

	public static void venderAlaTienda(Caballero Vendedor,
			ArmaTerreno ArmaVender) {

		int oroVendedor;
		oroVendedor = Vendedor.getOro() + ArmaVender.getModelRef().getOro();
		Vendedor.setOro(oroVendedor);
		updateCaballero(Vendedor);
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String queryStr_2 = "DELETE FROM t_arma_terreno WHERE id = :id";
		Query query_2 = session.createSQLQuery(queryStr_2);
		query_2.setInteger("id", ArmaVender.getId());
		query_2.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {
		Usuario user = new Usuario();
		Caballero cab = new Caballero();
		Caballero cab2 = new Caballero();
		ArmaTerreno armaT = new ArmaTerreno();
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		user = (Usuario) session.load(Usuario.class, 12831);
		cab = (Caballero) session.load(Caballero.class, 12830);
		cab2 = (Caballero) session.load(Caballero.class, 12831);
		//armaT = (ArmaTerreno) session.load(ArmaTerreno.class, 12854);
		session.getTransaction().commit();
		session.close();
		Object aux;

		 //tablaPrincipal(user);
		// aux = tablaPorArma(user, "Bomba");
		// usarArmaTerreno(1, 5, 12805);
		//devolverArmaTerreno(armaT,0);
		//venderArmaTerreno(cab, cab2, armaT);
		//List <ModeloArmaTerreno> lista = new ArrayList<ModeloArmaTerreno>();
		//lista=mostrarArmasInventario();
		//comprarDeLaTienda(cab, lista.get(1));
		//venderAlaTienda(cab, armaT);
	}
}
