/*
 - Exercici 3
Crea una classe amb un m�tode que llanci una ArrayIndexOutOfBoundsException.
Verifica el seu correcte funcionament amb un test jUnit.
 */

package s1t4e3;

import java.util.*;

public class ArrojaExcepcion {
	
	private ArrayList lista = new ArrayList();
	
	

	public  void lugarEnLaLista(int pos) throws ArrayIndexOutOfBoundsException {
		if (lista.size() == 0) {
			throw new ArrayIndexOutOfBoundsException("No hay ning�n elemento en esa posici�n de la lista");
		}
		System.out.println(lista.get(pos));
	}

}
