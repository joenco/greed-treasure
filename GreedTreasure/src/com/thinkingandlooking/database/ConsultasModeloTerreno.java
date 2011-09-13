package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultasModeloTerreno {
	
	public static List<PlantillaTerreno> getModelosTerrenos() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM PlantillaTerreno";
		Query query = session.createQuery(str);

		List<PlantillaTerreno> list = new ArrayList<PlantillaTerreno>();
		
		for (Object obj : query.list()) {
			PlantillaTerreno modeloTerreno = (PlantillaTerreno) obj;
			list.add(modeloTerreno);
			
		}
		session.getTransaction().commit();
		session.close();
		
		return list;
	}
	
	//BORRAR UNA VEZ ESTE HECHO LO DEMAS
	public static String [] ConsultasModeloTerrenoprovicional(){

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM PlantillaTerreno";
		Query query = session.createQuery(str);
		int i=0;

		String [] list =new String [query.list().size()];
		
		for (Object obj : query.list()) {
			PlantillaTerreno modeloTerreno = (PlantillaTerreno) obj;
			list[i++]=modeloTerreno.getName();
		
		}
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
