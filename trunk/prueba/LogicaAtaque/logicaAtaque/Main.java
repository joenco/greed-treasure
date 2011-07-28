/*
 * Logica de ataque en las Armas del castillo y el Caballero.
 * Compañia: Thinking&looking
 * Juego: Greed Treasure.
 * Realizado por: Jorge Ortega.
*/

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
   public static void main( String args[] )throws IOException {
        final int JOENCO = 0;
        final int GLADIADOR = 1;
        final int CARLOS = 2;
        final int PILAR = 3;
        final int TERESA = 4;

        final int DRAGON = 0;
        final int FLECHAS = 1;
        final int GALLINAS = 2;
        final int LOBO = 3;
        final int LUZ = 4;

		List<CaballeroBean> cab;
		List<ArmaBean> cab1;

        ArmaBeanLoader arma =new ArmaBeanLoader() ;
        cab1 = arma.loadData();
	ArmaBean arma1 = new ArmaBean();
	arma1 = cab1.get(DRAGON);

        CaballeroBeanLoader enemigo =new  CaballeroBeanLoader() ;
        cab = enemigo.loadData();
        
	CaballeroBean enemigo2 = new CaballeroBean();
	enemigo2 = cab.get(CARLOS);

	for (int i= 0; i<5; i++) {
		Ataque d = new Ataque();
		Atributos e = new Atributos();
		int D = d.DañoArma(arma1, enemigo2);
		int D1 = d.DañoCaballero(arma1, enemigo2);
		e.VidaArma(D1, arma1);
		e.VidaCaballero(D, enemigo2);

		if (D<=0) {
			System.out.println("El Arma ha fallado");
		} else {
			System.out.println("El Arma ha acertado, te ha hecho: "+D+" de daño");
		}

	if (D1<=0) {
			System.out.println("El Caballero ha fallado");
		} else {
			System.out.println("El Caballero ha acertado, el Arma ha recibido: "+D1+" de daño");
			e.ExpCaballero(enemigo2);
		}

		e.ActualizarAtributos(enemigo2);
		//e.Records();

		System.out.println("------ atributos del arma ------");
		System.out.println("La Vida del arma es: "+arma1.getVida());
		System.out.println("Al Arma le quedan: "+arma1.getMuniciones()+" municiones");
		System.out.println("------ atributos del caballero ------");
		System.out.println("La Vida del caballero es: "+enemigo2.getVida());
		System.out.println("La Experiencia  del caballero es: "+enemigo2.getExp());
		System.out.println("El Nivel del caballero es: "+enemigo2.getNivel());
	}
  }
}
