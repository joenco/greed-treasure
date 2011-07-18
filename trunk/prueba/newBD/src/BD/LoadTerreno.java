package BD;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class LoadTerreno {

	public static char[][] loadData(String login) {

		char[][] terreno = new char[16][16];

		Usuario u = new Usuario();
		PlantillaTerreno pt = new PlantillaTerreno();

		Session session = SessionHibernate.getInstance().openSession();
        session.beginTransaction();
        
		Query q = session.createQuery("FROM Usuario WHERE login=:att_login");
		q.setParameter("att_login", login);

		u = (Usuario) q.uniqueResult();
		pt = (PlantillaTerreno) session.load(PlantillaTerreno.class, u
				.getidRef().getTipo());

		List<Coordenada> c;
		c = pt.getFonTList();
		Tile cuad;

		for (Coordenada auxCoor : c) {
			cuad = auxCoor.getIdTileRef();
			terreno[auxCoor.getX()][auxCoor.getY()] = cuad.getCharId();
		}

		session.getTransaction().commit();
		session.close();

		return terreno;

	}

}
