package BD;

import org.hibernate.Session;


import BD.LoadTerreno;

public class NewUser {

	public static char[][] nuevoUsuario(String login, int pass, int tipo) {
		Usuario user = new Usuario();
		PlantillaTerreno pt = new PlantillaTerreno();
		user.setLogin(login);
		user.setPassword(pass);

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();

		pt = (PlantillaTerreno) session.load(PlantillaTerreno.class, tipo);
		pt.getUsuarioList().add(user);
		user.setIdRef(pt);

		session.save(user);

		session.getTransaction().commit();
		session.close();

		char[][] t = new char[16][16];
		t = LoadTerreno.loadData(login);

		return t;

	}

}
