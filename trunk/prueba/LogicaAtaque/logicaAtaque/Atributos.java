
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Atributos {
	private CaballeroBean user;
	private ArmaBean arma;
	private int d;

// experiencia que se obtiene cuando el caballero ataca y es efectivo.
	public void ExpCaballero(CaballeroBean user) {
		user.setExp(user.getExp()+2);
	}

// experiencia que se obtiene cuando es atacado el castillo y la defensa es efectiva.
	public void ExpCastillo(CaballeroBean user) {
		user.setExp(user.getExp()+2);
	}

// experiencia que se obtiene por la victoria(ya sea porque vencio al caballero o al castillo).
	public void ExpVictoria(CaballeroBean user) {
		user.setExp(user.getExp()+20);
	}

// actualizando los atributos del usuario según su nivel.
	public void ActualizarAtributos(CaballeroBean user) {

	// actualizando nivel
		user.setNivel(user.getNivel()+(user.getExp()/(150*user.getNivel()+100*(user.getNivel()-1))));

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
}
