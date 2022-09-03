/*
Crea una classe "Cotxe" amb els atributs: marca, model i pot�ncia.

La marca ha de ser est�tic final, el model est�tic i la pot�ncia final. Demostra la difer�ncia entre els tres. N�hi ha algun que es pugui inicialitzar al constructor de la classe?

Afegeix dos m�todes a la classe "Cotxe". Un m�tode est�tic anomenat frenar() i un altre no est�tic anomenat accelerar(). El m�tode accelerar ha de mostrar per consola: �El vehicle est� accelerant� i el m�tode frenar() ha de mostrar: �El vehicle est� frenant�. 

Demostra com invocar el m�tode est�tic i el no est�tic des del main() de la classe principal.

*/


package s1t1e2;

public class App {

	public static void main(String[] args) {
		Coche car1 = new Coche(200);
		Coche car2 = new Coche(300);
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		
		car1.acelerar();
		car2.acelerar();
		Coche.frenar(car1);
		Coche.frenar(car2);
		

	}

}
