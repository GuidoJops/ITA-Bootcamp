package s1t3e1;
/*
 Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any). Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepció de l'objecte amb atribut "Agost". Després, efectua la inserció en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte.

Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.

Recorre la llista amb un for i amb un iterador.
 */

import java.util.*;

public class App {

	public static void main(String[] args) {
		ArrayList <Mes> mesesArray = new ArrayList();
		
		Mes one = new Mes("Enero");
		Mes two = new Mes("Febrero");
		Mes three = new Mes("Marzo");
		Mes four = new Mes("Abril");
		Mes five = new Mes("Mayo");
		Mes six = new Mes("Junio");
		Mes seven = new Mes("Julio");
		Mes eight = new Mes("Agosto");
		Mes nine = new Mes("Septimebre");
		Mes ten = new Mes("Octubre");
		Mes eleven = new Mes("Noviembre");
		Mes twelve = new Mes("Diciembre");
		
	//AGREGO TODOS LOS MESES A LA LISTA MENOS AGOSTO
		mesesArray.add(one);
		mesesArray.add(two);
		mesesArray.add(three);
		mesesArray.add(four);
		mesesArray.add(five);
		mesesArray.add(six);
		mesesArray.add(seven);
		mesesArray.add(nine);
		mesesArray.add(ten);
		mesesArray.add(eleven);
		mesesArray.add(twelve);
		
		System.out.println("\n--ArrayList SIN Agosto--\n");
		
		for (Mes mes : mesesArray) {
			System.out.println(mes.getNombre());
		}
		
		System.out.println("\n--ArrayList CON Agosto--\n");
		
	//AGREGO AGOSTO EN LA POSICION QUE TOCA
		mesesArray.add(7,eight);
		
		for (Mes mes : mesesArray) {
			System.out.println(mes.getNombre());
		}
		
		System.out.println("\n--HashSet SIN Duplicados--\n");
		
		
	//CONVIERTO ARRAYLIST A HASHSET UTILIZANDO CONSTRUCTOR
		HashSet<Mes> mesesHash = new HashSet(mesesArray);
		
	//AGREGO ELEMENTOS YA EXISTENTES
		mesesHash.add(three);
		mesesHash.add(four);
		mesesHash.add(five);

	//COMPRUEBO QUE NO SE DUPLICAN
		for (Mes mes : mesesHash) {
			System.out.println(mes.getNombre());
		}
		
		System.out.println("\n--Recorro lista con Bucle for--\n");
		for(int i=0; i<mesesArray.size(); i++) {
			System.out.println(mesesArray.get(i).getNombre());
		}
		
		System.out.println("\n--Recorro lista con Iterator--\n");
		Iterator<Mes> it=mesesArray.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getNombre());
		}
		
		System.out.println("\nFIN DEL PROGRAMA");

	}

}
