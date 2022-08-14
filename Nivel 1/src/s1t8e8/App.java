/*
 *- Exercici 8
Crea una Functional Interface que contingui un m�tode anomenat reverse(). 
Aquest m�tode ha de rebre i ha de retornar un String. En el main() de la classe principal, 
injecta a la interf�cie creada mitjan�ant una lambda, el cos del m�tode, de manera que torni 
la mateixa cadena que rep com a par�metre per� al rev�s. Invoca la inst�ncia de la interf�cie 
passant-li una cadena i comprova si el resultat �s correcte.
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
