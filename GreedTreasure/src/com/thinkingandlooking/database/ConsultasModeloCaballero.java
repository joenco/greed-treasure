package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultasModeloCaballero {
	public static List<ModeloCaballero> getModelosCaballeros() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM ModeloCaballero";
		Query query = session.createQuery(str);

		List<ModeloCaballero> list = new ArrayList<ModeloCaballero>();
		
		for (Object obj : query.list()) {
			ModeloCaballero ma = (ModeloCaballero) obj;
			list.add(ma);
			System.err.println(ma.getId() + "; " + ma.getNombreModelo());
		}
		session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	//BORRAR UNA VEZ ESTE HECHO LO DEMAS
	public static String [] getModelosCaballerosProvicional() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM ModeloCaballero";
		Query query = session.createQuery(str);
		int i=0;

		String [] list =new String [query.list().size()];
		
		for (Object obj : query.list()) {
			ModeloCaballero ma = (ModeloCaballero) obj;
			list[i++]=ma.getNombreModelo();
		
			System.err.println(ma.getId() + "; " + ma.getNombreModelo());
		}
		session.getTransaction().commit();
		session.close();
		
		return list;
	}


}
