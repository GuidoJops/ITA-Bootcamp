/*
 - Exercici 2
Has de fer el mateix que en el punt anterior, però ara, el mètode ha de retornar una llista
amb els Strings que a més de contenir la lletra ‘o’ també tenen més de 5 lletres. Imprimeix el resultat.
 */

package s1t8e2;


import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("Hola", "Manel", "Playa", "Horizonte", "Juego", "Java", "Programa", "OREGANO");
		System.out.println(filtraCadena(stringList));
	}
		
	public static List <String> filtraCadena(List<String> list) {
		
		//Filtra palabras que contengan la letra 'o' y tiene mas de 5 letras
		return list.stream().filter( i -> i.toLowerCase().contains("o") && i.length()>5) .toList();
	}

}
