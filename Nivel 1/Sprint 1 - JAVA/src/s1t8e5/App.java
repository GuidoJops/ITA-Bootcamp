/*
 * - Exercici 5
Crea una Functional Interface amb un m�tode anomenat getPiValue() que ha de retornar un double. 
Des del main() de la classe principal, inst�ncia la interf�cie i assigna-li el valor 3.1415. 
Invoca el m�tode getPiValue() i imprimeix el resultat.
 */
package s1t8e5;

public class App {

	public static void main(String[] args) {
		
		F_interface pi = () -> 3.1415d;
						
		System.out.println(pi.getPiValue());

	}

}


