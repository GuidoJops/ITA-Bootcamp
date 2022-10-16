package s3t3Floristeria;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		//-----PRUEBAS------
		
		Producto p1 = new Arbol("arbol1", 10, 1.2);
		Producto p2 = new Arbol("arbol2", 20, 3.2);
		Producto p3 = new Arbol("arbol3", 30, 8.2);
		Floristeria f1 = new Floristeria("Pepa");
		
		f1.listaProductos();
		
		f1.agregaRetiraProducto(p3, 2, true);
		
		System.out.println(f1.getStock().getExistencias());
	
		f1.listaProductos();
		System.out.println("Valor de STock-->" + f1.getStock().getValorStock());
		
		System.out.println("-----------");
		
		f1.agregaRetiraProducto(p2, 2, true);
		
		System.out.println(f1.getStock().getExistencias());
	
		f1.listaProductos();
		System.out.println("Valor de STock-->" + f1.getStock().getValorStock());
		
		
		System.out.println("-----------");
		
		
		f1.agregaRetiraProducto(p1, 1, false);
		
		System.out.println(f1.getStock().getExistencias());
		
		f1.listaProductos();
		
		System.out.println("Valor de STock-->" + f1.getStock().getValorStock());
		

		
		//-----FIN PRUEBAS------



	}

}
