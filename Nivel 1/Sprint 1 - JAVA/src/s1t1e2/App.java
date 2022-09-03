/*
Crea una classe "Cotxe" amb els atributs: marca, model i potència.

La marca ha de ser estàtic final, el model estàtic i la potència final. Demostra la diferència entre els tres. N’hi ha algun que es pugui inicialitzar al constructor de la classe?

Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i un altre no estàtic anomenat accelerar(). El mètode accelerar ha de mostrar per consola: “El vehicle està accelerant” i el mètode frenar() ha de mostrar: “El vehicle està frenant”. 

Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.

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
