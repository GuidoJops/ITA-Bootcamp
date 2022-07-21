package s1t2;
/*
 Crea una clase llamada "Producto" con los atributos nombre y precio, y otra clase llamada "Venta". Esta clase tiene por atributos una colecci�n de productos y el precio total de la venta.

La clase "Venta", tiene un m�todo llamado calcularTotal() que lanza la excepci�n personalizada VentaBuidaException y muestra por pantalla "Para hacer una venta primero debes a�adir productos" si la colecci�n de productos est� vac�a. Si la colecci�n tiene productos, entonces debe recorrer la colecci�n y guardar la suma de todos los precios de los productos en el atributo precio total de la venta.

La excepci�n personalizada VentaBuidaException debe ser hija de la clase Exception. A su constructor debemos pasarle el mensaje �Para hacer una venta primero debes a�adir productos� y cuando capturamos la excepci�n, debemos mostrarlo por pantalla con el m�todo getMessage() de la excepci�n.

Escribe el c�digo necesario para generar y capturar una excepci�n de tipo ArrayIndexOutOfBoundsException.
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
			opcion = ingresaInt("\n--Escoge el n�mero que corresponda--\n1.- Agregar Producto\n2.- Ver Productos"
								+ "\n3.- Calcular total de Ventas\n4.- Consultar elemento en la lista seg�n posici�n\n\n0.- Salir del programa");
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
						Venta.lugarEnLaLista(ingresaInt("Dime la posici�n del elemento que quieres visualizar..."));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Recuerda escoger n�meros del 0 al 4");
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
	            System.out.println("Recuerda ingresar un n�mero entero...");
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
