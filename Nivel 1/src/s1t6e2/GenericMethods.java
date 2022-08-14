/*
- Exercici 2
Crea una classe anomenada Persona amb els atributs nom, cognom i edat. 
Després crea una classe anomenada GenericMethods amb un mètode genèric que
accepti tres arguments de tipus genèric. Aquest mètode només ha d’imprimir per 
pantalla els arguments que ha rebut. Al main() de la classe principal, crida el 
mètode genèric amb diferents tipus de paràmetres.
 */

package s1t6e2;

public class GenericMethods {

	
	public <T> void imprimeEnPantalla(T data, T data2, T data3) {
		System.out.println(data);
		System.out.println(data2);
		System.out.println(data3);
		
	}
}
