/*
 *- Ejercicio 6-
Crea una lista con números y cadenas de texto y ordena la lista con las cadenas de más corta a más larga.

- Ejercicio 7
Con la lista del ejercicio anterior, ahora ordénala al revés, de cadena más larga a más corta.
 */

package s1t8e6_e7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class App {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("14", "Hola", "PEPE", "90", "Abuela", "Zorro", "1",
				"Soy la cadena mas larga", "Computador", "Serenata", "Noviembre");

				
		// Ordena segun largo de la cadena
		System.out.println("\n--Ejercicio 6 --\n"
				+ "Orden de MENOR a MAYOR segun largo de cadena--\n");
		list.stream().filter(i -> !i.chars().allMatch(Character::isDigit)).sorted(Comparator.comparing(i -> i.length()))
				.forEach(System.out::println);
		
		System.out.println("\n--Ejercicio 6 V2--\n"
				+ "Orden de MENOR a MAYOR segun largo de cadena--\n");
		list.stream().filter(i -> !i.chars().allMatch(Character::isDigit)).sorted((a, b) -> a.length() - b.length())
		.forEach(System.out::println);
		
		
		System.out.println("\n--Ejercicio 7 --\n" + "Orden de MAYOR a MENOR segun largo de cadena--\n");
		list.stream().filter(i -> !i.chars().allMatch(Character::isDigit)).sorted((a, b) -> b.length() - a.length())
				.forEach(System.out::println);
		
				
//		// Ordena Alfabeticamente
//		list.stream().filter(i -> !Character.isDigit(i.charAt(0))).sorted().forEach(i -> System.out.println(i));
//		
//		System.out.println("\n--Otra forma--\n");
//		
//		list.stream().filter(i -> !i.chars().allMatch(Character::isDigit)).sorted().forEach(System.out::println);
//				




	}

}
