package BD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class MetodosArmaCaballero {
	
	// Listar todos los modelo armas caballeros para comprar
	
	public static List<ModeloArmaCaballero> modeloArma() {

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "SELECT * FROM ModeloArmaCaballero";
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
	
	public static List<Object> armasSinUsar(String login) {
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "SELECT a.modelRef, municiones_actuales, extremidad  FROM ArmaCaballero AS a WHERE extremidad = : sin_usar AND a.armacaballeroRef.usuario.login = :login";
		Query query = session.createQuery(str);
		query.setInteger("sin_usar", 0);
		query.setString("login", login);
		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list()) {
			//Object o = () obj;
			list.add(obj);
			
		}
		
		session.getTransaction().commit();
		session.close();

		return list;

		}
	
// Listar todas las armas de un caballero que estan siendo usadas
	
	public static List<Object> armasEnUso(String login) {
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		String str = "SELECT a.modelRef, municiones_actuales, extremidad  FROM ArmaCaballero AS a WHERE extremidad > : sin_usar AND a.armacaballeroRef.usuario.login = :login";
		Query query = session.createQuery(str);
		query.setInteger("sin_usar", 0);
		query.setString("login", login);
		List<Object> list = new ArrayList<Object>();
		
		for (Object obj : query.list()) {
			//Object o = () obj;
			list.add(obj);
			
		}
		
		session.getTransaction().commit();
		session.close();

		return list;

		}
	
    // Comprar un arma
	// Despues que yo te paso la lista con todos los modelos armas caballero
	// el usuario debe escoger una y enviarmela para atualizar con el siguiente metodo
	
	public static void comprarArma(ModeloArmaCaballero m, String login) {
		
		Usuario u = new Usuario();
		//ArmaCaballero ac = new ArmaCaballero();
		ArmaCaballero a = new ArmaCaballero();
		a.setMuniciones_actuales(m.getMuniciones_base());
		
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
		q.setParameter("att_login", login);

		u = (Usuario) q.uniqueResult();
		u.getCaballero().getArmaCaballeroList().add(a);
		m.getArmaCaballero().add(a);
				
		session.getTransaction().commit();
		session.close();

		
		}
	
	public static void main(String[] args) {

//		Usuario user = new Usuario ();
//		user.setNombre("sujaira");
//		user.setEmail("susi141");
//		user.setLogin("susi");
//		user.setPais("Vene");
//		user.setPassword(123);
//		
//		Caballero cab = new Caballero ();
//		cab.setAtaque(10);
//		cab.setNivel(10);
//		cab.setUsuario(user);
//		
//		user.setCaballero(cab);
//		ModeloArmaCaballero model = new ModeloArmaCaballero();
//		model.setNombre("Bomba");
//		model.setDefensa(10);
//		model.setAlcance(2);
//		model.setMuniciones_base(2);
//		model.setNivel(1);
//		model.setOro(100);
//		
//		ArmaCaballero armaT = new ArmaCaballero();
//		armaT.setArmaCaballeroRef(cab);
//		armaT.setMuniciones_actuales(model.getMuniciones_base());
//		
//		
//		Session session = SessionHibernate.getInstance().openSession();
//		session.beginTransaction();
//		session.save(user);
//		session.save(armaT);
//		
//		session.getTransaction().commit();
//		session.close();
	} 
	

}
