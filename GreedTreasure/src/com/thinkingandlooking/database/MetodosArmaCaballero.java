package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class MetodosArmaCaballero {

	

	public static List<Object> tablaPrincipal(Usuario user) {
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM ArmaCaballero  WHERE extremidad >:sin_usar AND armaCaballeroRef=:id";
		Query query = session.createQuery(str);
		query.setInteger("sin_usar", ConstantesExtremidades.NO_USADA);
		query.setInteger("id", user.getCaballero().getId());
		

		List<Object> list = new ArrayList<Object>();

		for (Object obj : query.list())
			list.add(obj);

		session.getTransaction().commit();
		session.close();
		return list;

	}
	
	
	
	public static List<Object> modeloArmaCaballero() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "FROM ModeloArmaCaballero";
		Query query = session.createQuery(str);


		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list() )
			list.add(obj);
		
		session.getTransaction().commit();
		session.close();

		return list;
	}
	
	// Listar todos los modelo armas caballeros para comprar
	public static List<ModeloArmaCaballero> modeloArma() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "FROM ModeloArmaCaballero";
		Query query = session.createQuery(str);

		List<ModeloArmaCaballero> list = new ArrayList<ModeloArmaCaballero>();

		for (Object obj : query.list()) {
			ModeloArmaCaballero ma = (ModeloArmaCaballero) obj;
			list.add(ma);
			System.err.println(ma.getId() + "; " + ma.getNombre());
		}
		session.getTransaction().commit();
		session.close();

		return list;
	}

	// Listar todas las armas de un caballero que no estan siendo usadas
	// en este caso pregunto por todas las armas que tengan extremidad= NO_USADA
	// si quieres saber los datos de su modelo asosiado como hay navegabilidad
	// eso
	// no es problema solo preguntas por su modelRef y los atributos que desees
	// del
	// modelo

	public static List<ArmaCaballero> armasSinUsar(String login) {
		Usuario u = new Usuario();

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
								
		q.setParameter("att_login", login);
		u = (Usuario) q.uniqueResult();

		String str = "FROM ArmaCaballero  WHERE extremidad =:sin_usar AND armaCaballeroRef=:id";
		Query query = session.createQuery(str);
		query.setInteger("sin_usar", ConstantesExtremidades.NO_USADA);
		query.setInteger("id", u.getCaballero().getId());
		List<ArmaCaballero> list = new ArrayList<ArmaCaballero>();

		for (Object obj : query.list()) {
			ArmaCaballero ma = (ArmaCaballero) obj;
			list.add(ma);
			System.err.println(ma.getRefModel().getId() + "; "
					+ ma.getRefModel().getNombre());

		}

		session.getTransaction().commit();
		session.close();

		return list;

	}

	// Listar todas las armas de un caballero que estan siendo usadas
	// Es igual al caso anterior solo que la extremidad es distinta de NO_USADA

	public static List<ArmaCaballero> armasEnUso(String login) {
		Usuario u = new Usuario();

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
		q.setParameter("att_login", login);
		u = (Usuario) q.uniqueResult();

		String str = "FROM ArmaCaballero  WHERE extremidad >:sin_usar AND armaCaballeroRef=:id";
		Query query = session.createQuery(str);
		query.setInteger("sin_usar", ConstantesExtremidades.NO_USADA);
		query.setInteger("id", u.getCaballero().getId());
		List<ArmaCaballero> list = new ArrayList<ArmaCaballero>();

		for (Object obj : query.list()) {
			ArmaCaballero ma = (ArmaCaballero) obj;
			list.add(ma);
			System.err.println(ma.getRefModel().getId() + "; "
					+ ma.getRefModel().getNombre());

		}

		session.getTransaction().commit();
		session.close();

		return list;

	}

	// Comprar un arma
	// Despues que yo te paso la lista con todos los modelos armas caballero
	// el usuario debe escoger una y enviarmela para atualizar con el siguiente
	// metodo

	public static void comprarArma(ModeloArmaCaballero m, String login) {

		Usuario u = new Usuario();
		ArmaCaballero a = new ArmaCaballero();
		a.setMuniciones_actuales(m.getMuniciones_base());

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
		q.setParameter("att_login", login);

		u = (Usuario) q.uniqueResult();
		u.getCaballero().getArmaCaballeroList().add(a);
		m.getArmaCaballero().add(a);

		// Actualizar el oro que gasto el caballero comprado el arma
		int oro = u.getCaballero().getOro() - m.getOro();

		String str = "UPDATE Caballero SET oro=:oro WHERE id=:id";
		Query query = session.createQuery(str);
		query.setInteger("oro", oro);
		query.setInteger("id", u.getCaballero().getId());
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();

	}

	// Despues que se lista las armas sin usar
	// si el usuario desea usar una
	// el metodo actualiza en que extremidad
	// que sera usada

	public static void usarArma(ArmaCaballero a, int c) {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		String str = "UPDATE ArmaCaballero SET extremidad=:ex WHERE id=:id";
		Query query = session.createQuery(str);
		query.setInteger("ex", c);
		query.setInteger("id", a.getId());
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();

	}

}
