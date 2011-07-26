
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Ataque {
	private ArmaBean arma;
	private CaballeroBean user;
	public int DañoArma(ArmaBean arma, CaballeroBean user) {
	int A=9, C=0;;
		// elementos de ataque del arma.
		int aa = arma.getAtaque();
		int alc = arma.getAlcance();
		int nv = arma.getNivel();

		// elementos de defensa del caballero
		int dc = user.getDefensa();
		int sd = user.getSD();
		int hab = user.getHab();
		int nc = user.getNivel();
		int n = (int)Math.round(Math.random()*A); // numero aleatorio entre 0 y 9
		int n2 = (int)Math.round(Math.random()*4)+6; // respuesta de las armas defensivas del caballero.
		int d=0;

		if (n==0) { //en este rango no es efectiva el Arma
			d = 0;
		} else {
			int atk = aa+alc+nv;
			d = (int) (atk-(n2/10.0)*(dc+sd));
			if (d<=0) {
			  d=1; }
		}

		return d;
	}

	public int DañoCaballero(ArmaBean arma, CaballeroBean user) {
	int A=4, C=2;
		// elementos de ataque del caballero.
		int ac = user.getAtaque();
		int sa = user.getSA();
		int nc = user.getNivel();

		// elementos de defensa del arma
		int da = arma.getDefensa();
		int ra = arma.getRA();

		int d=0;
		int n1 = (int)Math.round(Math.random()*C); // numero aleatorio entre 0 y 1
		int n3 = (int)Math.round(Math.random()*4)+6; // respuesta de las armas ofensivas del caballero.

		if (n1==0) { //en este rango no es efectiva el Arma
			d = 0;
		} else {
			int atk = ac+nc;
			d =(int) (atk+(n3/10.0)*(sa)-da-ra);
			if (d<=0) {
			  d=1; }
		}

		return d;
	}
}
