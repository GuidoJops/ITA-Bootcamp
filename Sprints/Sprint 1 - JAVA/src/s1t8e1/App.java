/*
 -Exercici 1
A partir d’una llista de Strings, escriu un mètode que retorna una llista
 de totes les cadenes que contenen la lletra ‘o’. Imprimeix el resultat.
 */

package s1t8e1;


import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("Hola", "Manel", "Playa", "Horizonte", "Juego", "Java", "Programa", "OREGANO");
		System.out.println(filtraCadena(stringList));
	}
	
	public static List <String> filtraCadena(List<String> list) {
		
		//Filtra palabras que contengan la letra 'o'
		return list.stream().filter(i -> i.toLowerCase().contains("o")).toList();
	}

}
