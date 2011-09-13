package BD;

import org.hibernate.Session;

public class pruebaLlenado2 {

	public static Usuario insertarUsuario(String nombre, String login,
			String email, String pais, int pass) {
		Usuario user = new Usuario();
	    user.setNombre(nombre);
		user.setEmail(email);
		user.setLogin(login);
		user.setPais(pais);
		user.setPassword(pass);

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
		
		return user;
	}

	public static Caballero insertarCaballero(int ataque, int defensa, int vida,
			int nivel, int oro, Usuario user) {
		Caballero cab = new Caballero();
		cab.setAtaque(ataque);
		cab.setDefensa(defensa);
		cab.setVida(vida);
		cab.setNivel(nivel);
		cab.setOro(oro);
		cab.setUsuario(user);

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		session.save(cab);

		session.getTransaction().commit();
		session.close();
		
		return cab;
	}

	public static ModeloArmaCaballero insertarModeloArmaTerreno(String nombre, int defensa,
			int alcance, int municiones, int oro, int nivel) {
		ModeloArmaCaballero model = new ModeloArmaCaballero();
		model.setNombre(nombre);
		model.setDefensa(defensa);
		model.setAlcance(alcance);
		model.setMuniciones_base(municiones);
		model.setNivel(nivel);
		model.setOro(oro);

		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		session.save(model);

		session.getTransaction().commit();
		session.close();
		
		return  model;
	}

	public static void insertarArmaTerreno(Caballero cab, ModeloArmaCaballero model) {
		ArmaCaballero armaT = new ArmaCaballero();
		armaT.setArmaCaballeroRef(cab);
		armaT.setRefModel(model);
		armaT.setMuniciones_actuales(model.getMuniciones_base());
		armaT.setExtremidad(ConstantesExtremidades.NO_USADA);
		Session session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		session.save(armaT);

		session.getTransaction().commit();
		session.close();
	}
public static void main(String[] args) {
		Usuario user = insertarUsuario("Sujaira", "susi3", "susi141", "vene", 1234);
		Usuario user2 = insertarUsuario("Fannia", "hermi3", "fanni", "vene", 1234);
		Caballero caball = insertarCaballero(10, 5, 100, 5, 100, user);
		Caballero caball1 = insertarCaballero(10, 5, 100, 5, 100, user2);
		ModeloArmaCaballero bomba = insertarModeloArmaTerreno("Bomba", 10, 2, 2, 15, 1);
		ModeloArmaCaballero flecha = insertarModeloArmaTerreno("Flecha", 10, 20, 1, 20, 1);
		ModeloArmaCaballero espada = insertarModeloArmaTerreno("Espada", 50, 5, 1000, 90, 6);
		insertarArmaTerreno(caball, bomba);
		insertarArmaTerreno(caball, flecha);
		insertarArmaTerreno(caball, bomba);
		insertarArmaTerreno(caball, flecha);
		insertarArmaTerreno(caball, bomba);
		insertarArmaTerreno(caball1, bomba);
		insertarArmaTerreno(caball1, bomba);
		insertarArmaTerreno(caball1, espada);
}

}
