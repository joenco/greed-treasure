package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class MetodosArmaTerreno {
	
	/*****************************************************
	 * Desde aqui estan los metodos para cumplir con los *
	 * requerimientos de IS....                          *   
	******************************************************/
	
	//Recibiendo el usuario, este metodo retorna una lista con todos los
	//modelos de armas que el usuario posee es su inventario...
	public static List<Object> tablaPrincipal(Usuario user) {
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "SELECT DISTINCT a.modelRef AS c FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		
		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list() )
			list.add(obj);
			   
			
		
		session.getTransaction().commit();
		session.close();
		return list;

	}
	
	//Recibiendo el usuario y el nombre del modelo, este metodo retorna una lista con todas las
	//armas terreno que el usuario posee es su inventario para ese modelo que no se encuentre
	// en uso actualmente ...
	public static List<Object> tablaPorArma(Usuario user, String nombre) {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login AND a.modelRef.nombre = :nombre";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		query.setString("nombre", nombre);
		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list()) {
			ArmaTerreno arma = (ArmaTerreno) obj;
			if (!armaEnUso(arma)){
				list.add(obj);
			}
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}
	//retorna la lista de armas que estan en el terreno actualmente
	public static List<ArmaTerreno> tablaArmaEnUso(Usuario user, String nombre){
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "SELECT a FROM ArmaTerreno AS a WHERE a.caballeroRef.usuario.login = :login AND a.modelRef.nombre = :nombre";
		Query query = session.createQuery(str);
		query.setString("login", user.getLogin());
		query.setString("nombre", nombre);
		List<ArmaTerreno> list = new ArrayList<ArmaTerreno>();
		System.err.println("Nombre id");
		for (Object obj : query.list()) {
			ArmaTerreno arma = (ArmaTerreno) obj;
			if (armaEnUso(arma)){
				list.add(arma);
			    System.out.println(arma.getModelRef().getNombre() + " - " + arma.getId());
			}
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	//Cada ves que se utiliza un armaTerreno se le asigna una coordenada
	//y se guarda la base de datos del juego
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
	//Este metodo recive el arma y las municiones restantes
	//con lo cual se eliminara las coordenadas y
	// se actulizaran o eliminara el arma de acuerdo a las mucniones restantes
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

	//Este metodo realiza el intercambio de armas entre dos Caballeros
	//con su respectiva actulizacion en el oro de cada uno.
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
	//Actulizar el oro de un caballero se lleva a cabo en repetidas ocasiones
	// por lo q este metodo sirve para no copiar este pedazo de codigo en cada metodos
	// de compra o venta de armas
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
	//Con este metodo se le puede mostrar al usuario la lista de armas q
	// la tienda posee, de esta forma puede seleccionar cual arma comprar
	// considerando que a la tienda nunca se le agotaran las armas
	public static List<Object> mostrarArmasInventario() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		String str = "SELECT DISTINCT m FROM ModeloArmaTerreno AS m ORDER BY nivel,oro";
		Query query = session.createQuery(str);
		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list()) {
			list.add(obj);
		}
    
		session.getTransaction().commit();
		session.close();
		return list;
	}

	//Con este metodo un caballero compra un arma de la tienda
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
	
	//Con este metodo un caballero vende un arma a la tienda
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
	/// retorna true si el arma esta siendo usada actualemte
	public static boolean armaEnUso(ArmaTerreno armaT){

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		//ArmaTerreno armaT = (ArmaTerreno) session.load(ArmaTerreno.class, 12860);
		String str = "SELECT c FROM CoordenadaArma AS c WHERE c.id = :id";
		Query query = session.createQuery(str);
		query.setInteger("id", armaT.getId());
		
		CoordenadaArma coor = new CoordenadaArma();
		coor = (CoordenadaArma) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		if (coor == null){
			return false;
		}
		else {
			return true;
		}
	}
}
