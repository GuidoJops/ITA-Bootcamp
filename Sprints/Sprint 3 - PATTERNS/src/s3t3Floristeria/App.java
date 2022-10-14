package s3t3Floristeria;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		//-----PRUEBAS------
		
		Producto p1 = new Arbol("arbol1", 23.2, 1.2);
		Producto p2 = new Arbol("arbol2", 109, 3.2);
		Producto p3 = new Arbol("arbol3", 500, 8.2);
		Cliente cl1 = new Cliente("Juan", "233123G");
		System.out.println(	p1.getNombre());
		
		List<Producto> test = new ArrayList();
		test.add(p1);
		test.add(p2);
		
		List<Producto> test2 = new ArrayList();
		test2.add(p1);
		test2.add(p2);
		test2.add(p3);
		
		
		Ticket tk1 = new Ticket(cl1,test);
		Ticket tk2 = new Ticket(cl1,test2);

		System.out.println(tk1.getTotalCompra());
		System.out.println(tk2.getTotalCompra());
		
		//-----FIN PRUEBAS------



	}

}
