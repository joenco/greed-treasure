package com.thinkingandlooking.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultasCaballero {
	
	public static List<Object> getContrincantes(Usuario usuario) {
		
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "FROM Caballero WHERE id <> :att_id AND nivel >=:att_nivel";
		Query query = session.createQuery(str);
		query.setParameter("att_id", usuario.getCaballero().getId());
		query.setParameter("att_nivel",usuario.getCaballero().getNivel());
		List<Object> list=new ArrayList<Object>();
		
		 for (Object obj : query.list()) {
			 
			list.add(obj);
			
	        }
		 return list;
		
	   }
}
