/*
- Exercici 2
Crea una classe anomenada Persona amb els atributs nom, cognom i edat. 
Despr�s crea una classe anomenada GenericMethods amb un m�tode gen�ric que
accepti tres arguments de tipus gen�ric. Aquest m�tode nom�s ha d�imprimir per 
pantalla els arguments que ha rebut. Al main() de la classe principal, crida el 
m�tode gen�ric amb diferents tipus de par�metres.
 */

package s1t6e2;

public class GenericMethods {

	
	public <T> void imprimeEnPantalla(T data, T data2, T data3) {
		System.out.println(data);
		System.out.println(data2);
		System.out.println(data3);
		
	}
}
