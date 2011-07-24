
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Vida {
	private ArmaBean arma;
	private CaballeroBean user;
	private int d;
	public int VidaArma(int d, ArmaBean arma) {
		int vida;
		arma.setVida(arma.getVida()-d);
		vida = arma.getVida();
		return vida;
	}

	public int VidaCaballero(int d, CaballeroBean user) {
		int vida;
		user.setVida(user.getVida()-d);
		vida = user.getVida();
		return vida;
	}
}
