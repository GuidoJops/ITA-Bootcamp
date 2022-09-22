/*
 Crea una classe que repliqui el funcionament del comando 'Undo'. Aquesta classe ser� utilitzada per la classe Main, que permetr� introduir opcions per consola.

La classe 'Undo' ha de guardar les �ltimes comandes introdu�des. Ha de permetre afegir o eliminar comandes, aix� com llistar les �ltimes comandes introdu�des (semblant a la comanda 'history' en Linux).
La classe 'Undo' ha d'implementar imprescindiblement un patr� Singleton.
 */
package s3t1Singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
	private static Undo instance;
	private List<String> memory;
	
	
	private Undo() {
		memory = new ArrayList<String>();
		
	}
	
	public static Undo getInstance() {
		if(instance == null) {
			instance = new Undo();
		}
		return instance;
		
	}	
	
	public void insert(String str) {
		memory.add(str);
		
	}
	
	public void delete() {
		if(memory.size() !=0) {
			memory.remove(memory.size()-1);
		} else {
			System.out.println("La memoria esta vacia\n");
		}
	}
	
	public void list() {
		memory.forEach(System.out::println);
		//System.out.println(memory);
		
	}
	
	

}
