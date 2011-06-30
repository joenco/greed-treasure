/*
 * Logica de ataque en las Armas del castillo y el Caballero.
 * Compañia: Thinking&looking
 * Juego: Greed Treasure.
 * Realizado por: Jorge Ortega.
*/

import javax.swing.*;
import java.io.*;

class LogicaAtaque {
  public static void main( String args[] )throws IOException {

	// variables:
	int a=0, b=0, c=0, A=3, C=1, p=0;
	double vidaA=100, vidaC=100;
	BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));

	//variables del Arma
	int nv; //nivel del arma
	int aa = 3; // fuerza de ataque del arma
	int alc = 3; // fuerza de alcance del arma
	int efec=8; //efectividad del arma
	int da = 3; // fuerza defensiva del arma.
	int ra = 2; // resistencia del arma.

	// variables del caballero
	int  nc = 1; //nivel del caballero
	int hab = 1; // habilidad del caballero
	int fc = 1; // fortaleza del caballero
	int ac = 1; // fuerza de ataque predeterminada del caballero
	int aac = 4; //sumatoria de la fuerza de ataque de las armas del caballero.
	int dc = 1; // fuerza defensiva predeterminada del caballero.
	int dac = 6; // sumatoria de las armas defensivas del caballero.

	int r=1;
    while (r!=0) {

	//solicitamos al usuario datos del arma.
	System.out.println("Datos del Arma del castillo");
	System.out.println("Ingrese el nivel del arma:");
	nv = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fuerza de ataque del arma:");
	aa = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fuerza de alcance del arma:");
	alc = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese cual es la efectividad del arma:");
	efec = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fuerza defensiva del arma:");
	da = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la resistencia de ataque del arma:");
	ra = Integer.parseInt(lectura.readLine());

	// datos del caballero
	System.out.println("Datos del Caballero");
	System.out.println("Ingrese el nivel del caballero");
	nc = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la habilidad del caballero");
	hab = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fortaleza del caballero");
	fc = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fuerza de ataque predeterminada del caballero");
	ac = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la sumatoria de fuerzas de ataquepor las armas del caballero");
	aac = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la fuerza defensiva predeterminada del caballero");
	dc = Integer.parseInt(lectura.readLine());
	System.out.println("Ingrese la sumatoria de fuerzas defensivas por las armas del caballero");
	dac = Integer.parseInt(lectura.readLine());

	// efectividad del caballero
	C=C+nv/10; // aumenta en 1 cada 10 niveles.

	// Mostramos datos de la simulación
	System.out.println("Datos de la simulación");
	System.out.println("Arma castillo.");
	System.out.println("nivel: "+nv+"ataque: "+aa+" alcance: "+alc+" efectividad: "+efec+" defensa: "+da+" resistencia: "+ra);
	System.out.println("Caballero.");
	System.out.println("nivel: "+nc+"ataque: "+ac+" habilidad: "+hab+" fortaleza: "+fc+" ataque acumulado: "+aac+" Defensa: "+dc+" defens aculmulada: "+dac);

	// aumentamos la efectividad de ataque si la diferencia de nivel es mayor a 5
	if ((nv-nc)>5) { A=A+1; } // en el arma
	if ((nc-nv) > 5) { C=C+1; } // en el caballero

	// comprobamos que atributos ayudan al caballero (habilidad o fuerza) cuando es atacado)
	if ((hab-fc) >= 3) {
		A=a-1;
		C=C+1;
	}
	if (hab==nc*8) { C=C+hab/8; }
	if ((fc-hab) >= 3) {
		fc=fc+1;
	}
	if (fc==nc*10) { fc=fc+fc/10; }
		vidaA=vidaC=100;
		a=c=0;

		// cantidad de simulaciones
		System.out.println("Coloque el número de iteraciones:");
		b = Integer.parseInt(lectura.readLine());
     for (int i=0; i<b; i++) {
		int n = (int)Math.round(Math.random()*A); // numero aleatorio entre 0 y 9
		int n1 = (int)Math.round(Math.random()*C); // numero aleatorio entre 0 y 9
		int n2 = (int)Math.round(Math.random()*4)+6; // respuesta de las armas defensivas del caballero.
		int n3 = (int)Math.round(Math.random()*4)+6; // respuesta de las armas ofensivas del caballero.
		p=p+1;
		if (n==0) { //en este rango no es efectiva el Arma
			System.out.println("uFF! El Arma ha fallado!");
		} else {
			a=a+1;
			int atk = aa+alc+nv;
			double d = atk-(n2/10.0)*(dc+dac)-0.7*fc;
			if (d<=0) {
			  d=1.0; }

			// descontamos el daño a la vida del caballero
			vidaC=vidaC-d; //vida del caballero.
			System.out.println("Hit! El Arma ha acertado. Daño ocasionado: "+d);
		}
		if (n1==0) { // en este rango no es efectivo el caballero.
			System.out.println("uFF! El Caballero ha fallado!");
		}else {
			c=c+1;
			int atkc = ac+nc;
			double d1 = atkc+(n3/10.0)*(aac+fc)-da-ra;
			if (d1<=0) {
			  d1=1.0; }

			// descontamos el daño a la vida del arma
			vidaA=vidaA-d1; // vida del arma
			System.out.println("Hit! El Caballero ha acertado. Daño ocasionado: "+d1);
		}
     if (vidaA<1 || vidaC<1) { i=b; }
     }
		// mostramos información sobre el ataque.
		System.out.println("Número de iteraciones: "+p);
		System.out.println("----------");
		if (vidaC<1) {
			System.out.println("Tu caballero ha muerto! que descanse en PAZ!");
		} else {
			System.out.println("Vida del caballero: "+vidaC);
		}
		System.out.println("La efectividad del ataque fue: "+(c*100)/p+"%");
		System.out.println("----------");
		if (vidaA<1) {
			System.out.println("El Arma del castillo ha sido derrumbada!");
		} else {
			System.out.println("Vida del arma: "+vidaA);
		}
		System.out.println("La efectividad del ataque fue: "+(a*100)/p+"%");

		System.out.println("Probar con otros valores? Escriba 1 si la respuesta es positiva o 0 en caso contrario");
		r = Integer.parseInt(lectura.readLine());
    }
  }
}

// notas a considerar
// en el caballero:
// habilidad (hab): empieza en 1
// fortaleza (fc): empieza en 1
// la hab y fc empezaran en aumento en el nivel 3, incrementando en una unidad (el usuario es el que elije donde colocarlo)
// nivel (nc): discutir como sera el aumento, debe comenzar en 1
// ataque predeterminado (ac): nivel/2 empezando en 1 y redondeando al entero menor.
// ataque por armas del caballero (aac): 2*nivel+2 (considerar en las armas)
// defensa predeterminada (dc): nivel/2 empezando en 1 y redondeando al entero menor.
// defensa por armas del caballero (aac): 2*nivel+2 (considerar en las armas)
// el ataque del arma debe ser  mayor (rango 2<aa>4) con respecto a la defensa del caballero en su mismo nivel.
