/*
 Crea una classe que repliqui el funcionament del comando 'Undo'. Aquesta classe serà utilitzada per la classe Main, que permetrà introduir opcions per consola.

La classe 'Undo' ha de guardar les últimes comandes introduïdes. Ha de permetre afegir o eliminar comandes, així com llistar les últimes comandes introduïdes (semblant a la comanda 'history' en Linux).
La classe 'Undo' ha d'implementar imprescindiblement un patró Singleton.
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
