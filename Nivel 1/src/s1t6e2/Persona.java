/*
- Exercici 2
Crea una classe anomenada Persona amb els atributs nom, cognom i edat. 
Després crea una classe anomenada GenericMethods amb un mètode genèric que
accepti tres arguments de tipus genèric. Aquest mètode només ha d’imprimir per 
pantalla els arguments que ha rebut. Al main() de la classe principal, crida el 
mètode genèric amb diferents tipus de paràmetres.
 */

package s1t6e2;

public class Persona {
	private String nombre, apellido;
	private int edad;
	
	public Persona (String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	
	@Override
	public String toString() {
		return "Nombre: "+ nombre +"\nApellido: "+ apellido +"\nEdad: "+ edad;
		
	}

}
