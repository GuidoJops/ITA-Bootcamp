/*
 *- Exercici 8
Crea una Functional Interface que contingui un mètode anomenat reverse(). 
Aquest mètode ha de rebre i ha de retornar un String. En el main() de la classe principal, 
injecta a la interfície creada mitjançant una lambda, el cos del mètode, de manera que torni 
la mateixa cadena que rep com a paràmetre però al revés. Invoca la instància de la interfície 
passant-li una cadena i comprova si el resultat és correcte.
 */

package s1t8e8;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Finter f1 = str -> {
			String result = "";
			for (int i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return "Cadena al reves: " + result;
		};

		System.out.println(f1.reverse(ingresaStr("Ingresa una cadena de texto...")));
	}

	static String ingresaStr(String str) {
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}
}
