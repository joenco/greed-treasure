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
	enemigo2 = cab.get(PILAR);

	Ataque d = new Ataque();
	int D = d.DañoArma(arma1, enemigo2); 
	if (D<=0) {
		System.out.println("El Arma ha fallado");
	} else {
		System.out.println("El Arma ha acertado, te ha hecho: "+D+" de daño");
	}

	D = d.DañoCaballero(arma1, enemigo2); 

	if (D<=0) {
		System.out.println("El Caballero ha fallado");
	} else {
		System.out.println("El Caballero ha acertado, el Arma ha recibido: "+D+" de daño");
	}
  }
}
