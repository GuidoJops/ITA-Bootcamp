package s1t2;
/*
 Crea una clase llamada "Producto" con los atributos nombre y precio, y otra clase llamada "Venta". Esta clase tiene por atributos una colección de productos y el precio total de la venta.

La clase "Venta", tiene un método llamado calcularTotal() que lanza la excepción personalizada VentaBuidaException y muestra por pantalla "Para hacer una venta primero debes añadir productos" si la colección de productos está vacía. Si la colección tiene productos, entonces debe recorrer la colección y guardar la suma de todos los precios de los productos en el atributo precio total de la venta.

La excepción personalizada VentaBuidaException debe ser hija de la clase Exception. A su constructor debemos pasarle el mensaje “Para hacer una venta primero debes añadir productos” y cuando capturamos la excepción, debemos mostrarlo por pantalla con el método getMessage() de la excepción.

Escribe el código necesario para generar y capturar una excepción de tipo ArrayIndexOutOfBoundsException.
 */

import java.util.*;
public class App {

	public static void main(String[] args) {
		
		menuPrincipal();
		System.out.println("\nFIN DEL PROGRAMA");
	}
	
	
	static void menuPrincipal() {
		int opcion = 1;
		while(opcion!=0) {			
			opcion = ingresaInt("\n--Escoge el número que corresponda--\n1.- Agregar Producto\n2.- Ver Productos"
								+ "\n3.- Calcular total de Ventas\n4.- Consultar elemento en la lista según posición\n\n0.- Salir del programa");
			switch(opcion) {
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				case 1:
					Venta.agregarProducto(ingresaStr("Dime el nombre del producto"),ingresaInt("Dime el precio del producto"));
					break;
				case 2:
					Venta.verProductos();
					break;
				case 3:
					try {
						Venta.calculaTotal();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						Venta.lugarEnLaLista(ingresaInt("Dime la posición del elemento que quieres visualizar..."));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Recuerda escoger números del 0 al 4");
			}
		}

		
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
	
	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();	
	}
	
}
