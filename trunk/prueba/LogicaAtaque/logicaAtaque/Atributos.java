/*
 * Logica de ataque en las Armas del castillo y el Caballero.
 * Compañia: Thinking&looking
 * Juego: Greed Treasure.
 * Realizado por: Jorge Ortega.
*/

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Atributos {
	private CaballeroBean user;
	private CaballeroBean user1;
	private ArmaBean arma;
	private int d;

// experiencia que se obtiene cuando el caballero ataca y es efectivo.
	public void ExpCaballero(CaballeroBean user) {
		user.setExp(user.getExp()+5*user.getNivel());
	}

// experiencia que se obtiene cuando es atacado el castillo y la defensa es efectiva.
	public void ExpCastillo(CaballeroBean user) {
		user.setExp(user.getExp()+2*user.getNivel());
	}

// experiencia que se obtiene por la victoria(ya sea porque vencio al caballero o al castillo).
	public void ExpVictoria(CaballeroBean user) {
		user.setExp(user.getExp()+25*user.getNivel());
	}

// actualizando los atributos del usuario según su nivel.
	public void ActualizarAtributos(CaballeroBean user) {

	// actualizando nivel
	int n = (int) (150*(Math.pow(user.getNivel(), (1.1+user.getNivel()/10.0))));
		user.setNivel(user.getNivel()+(user.getExp()/n));

	// actualizando ataque y defensa predeterminada.
		user.setDefensa(user.getDefensa()+user.getNivel()/(user.getNivel()*2));
		user.setAtaque(user.getAtaque()+user.getNivel()/(user.getNivel()*2));
	}

// vida del arma (debe guardarse en base de datos)
public void VidaArma(int d, ArmaBean arma) {
		arma.setVida(arma.getVida()-d);

		if (arma.getVida()<=0) {
			arma.setVida(0);
		}
	}

// vida del caballero (debe mantenerse en memoria)
	public void VidaCaballero(int d, CaballeroBean user) {
		user.setVida(user.getVida()-d);

		if (user.getVida()<=0) {
			user.setVida(0);
		}
	}

// actualizamos el record de los usuarios.
	public void Records(CaballeroBean user, CaballeroBean user1) {
		user.setVictoria(user.getVictoria()+1);
		user.setCantOro((int) (user.getCantOro()+user.getCantOro()*0.1));
		user1.setDerrota(user1.getDerrota()+1);
		user1.setCantOro((int) (user1.getCantOro()-user1.getCantOro()*0.1));
	}
}
