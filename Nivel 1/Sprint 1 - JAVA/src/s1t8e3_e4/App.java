/*
- Exercici 3
Crea una llista amb els noms dels mesos de l’any. Imprimeix tots els elements de la llista amb una lambda.
 */

package s1t8e3_e4;


import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> monthsList = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
				"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
		

		System.out.println("-Ejercicio 3-");
		//Expresión Lambda
		monthsList.forEach(i -> System.out.println(i));
		System.out.println("\n----\n");
		
		System.out.println("-Ejercicio 4-");
		//Método de referencia
		monthsList.forEach(System.out::println);
	}


}
