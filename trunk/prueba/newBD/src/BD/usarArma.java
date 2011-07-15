package BD;



import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import BD.ArmaTerreno;
import BD.ModeloArma;
import BD.Usuario;

public class usarArma {

	public static ArmaTerreno usar(Usuario user, String nombre) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
	    configuration.configure("/BD/hibernate.cfg.xml");
	    SessionFactory sessionFactory = configuration.buildSessionFactory();

	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    org.hibernate.Query query;
		
		String str;
		str = "SELECT imagen, nombre, ataque, defensa, municiones, oro, COUNT(*) FROM ModeloArma, ArmaTerreno WHERE ModeloArma.id = ArmaTerreno.modelRef && ArmaTerreno.refUser= user.id && ModeloArma.nombre = nombre";
		
		query = session.createQuery(str);
		
		ArmaTerreno arma = new ArmaTerreno();
		arma = user.getArmaTerreno().get(0);
		return arma;
	}
}
