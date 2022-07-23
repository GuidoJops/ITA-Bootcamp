package s1t3e2;

import java.util.*;

public class App {

	public static void main(String[] args) {

	//Creo 1era lista
		List<Integer> numbers = new ArrayList<Integer>();
		
	//Ingreso valores
		int numbersSize = ingresaInt("¿Cuantos valores quieres ingresar a la lista?");
		
		for(int i=0; i<numbersSize; i++){
			numbers.add(ingresaInt("Ingresa un valor para la posición "+ (i+1) + " de la lista..."));
		}

	//Creo 2da Lista
		List<Integer> numbersInversed = new ArrayList<Integer>();
		
	//Recorro 1era lista con ListIterator
		ListIterator<Integer> it =numbers.listIterator();
		System.out.println("\n--Lista Original--");
		
		while(it.hasNext()) {
			System.out.println(it.next().intValue());
		}
		
	//Inserto en orden inverso en 2da lista
		while(it.hasPrevious()) {
			numbersInversed.add(it.previous().intValue());
		}
		
	//Printo 2da Lista con forEach
		System.out.println("\n--Lista Inversa--");
		for(int num : numbersInversed ) {
			System.out.println(num);
			
		}
		System.out.println("\nFIN DEL PROGRAMA");
	}
	
	static int ingresaInt(String str){
		boolean numOk = false;
		int num=-1;
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		while (!numOk) {
			 try{
				 num = Integer.parseInt(sc.nextLine());
	             numOk=true;
	        }catch (Exception e) {
	            System.out.println("Recuerda ingresar un número entero...");
	        }
			
		}		
		return num;	
	}
}
