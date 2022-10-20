package s3t3Floristeria;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class App {
		static File file = new File("src/s3t3Floristeria/bd/DatosFloristerias.bin");
		static List<Floristeria> tiendas = recuperaListaFloristeria(file);
//		static List<Floristeria> tiendas = new ArrayList();
	
	public static void main(String[] args) {
		
		/*
		 0-Muestra Floristerias disponibles y da la opcion de crear una nueva - Selecciona una
		 OPCIONES DENTRO DE FLORISTERIA
		 1- Agregar Producto
		 2- Retirar Producto
		 3- Ver Productos de la Floristeria
		 4- Ver Stock de productos (Cantidades)
		 5- Ver Valor total € de la Floristeria
		 6- Generar Compra (Ticket)
		 7- Ver todas las ventas de la Floristeria
		 8- Ver Ganancias de la Floristeria  
		 
		 */
		
		//BORRAR
//		tiendas.add(new Floristeria("JUAN"));
//		tiendas.add(new Floristeria("pepe"));
//		tiendas.add(new Floristeria("EOLANDO"));
		//---
		
		menuInicial();
		guardaListaFloristeria(file);
		System.out.println("\nFIN DEL PROGRAMA");
		
	}
	
	public static void menuInicial() {

		Floristeria f = null;
		int opcion= 1;
		if (tiendas.size() > 0) {
			while(opcion!=0) {
				System.out.println("\nActualmente hay " + tiendas.size() + " Foristerias en el sistema.\n¿Qué deseas hacer?\n");
				System.out.println("1- Seleccionar una floristeria existente");
				System.out.println("2- Crear una nueva Floristeria\n");
				System.out.println("0- Salir del Programa\n");
				opcion = ingresaNum("Ingresa una opcion para continuar...");
				switch (opcion) {
					case 0:
						System.out.println("Saliendo del programa...");
						break;
					case 1:
						//METODO LISTAR FLORISTERIAS
						System.out.println("\n----------------------------------");
						System.out.println("FLORISTERIAS EN SISTEMA");
						System.out.println("----------------------------------\n");
						tiendas.stream().forEach(x -> System.out.println("-Floristeria " + x.getNombre()));
						System.out.println("\n----------------------------------");
						//--------
						f = tiendas.get(buscaFloristeria(ingresaStr("Dime el nombre de la Floristeria")));
						System.out.println("\n----------------------------------");
						System.out.println("Floristeria " + f.getNombre() + " seleccionada");
						System.out.println("----------------------------------\n");
						menuFloristerias(f);
						break;
					case 2:
						f = creaFLoristeria();
						tiendas.add(f);
						menuFloristerias(f);
						break;
					default:
						System.out.println("INGRESA UN NÚMERO VÁLIDO");
						
				}
			}
			
		} else { 
			System.out.println("A continuación crearemos una Floristeria para comenzar.");
			f = creaFLoristeria();
			tiendas.add(f);
			menuFloristerias(f);
			menuInicial();
		}
	}
	
	public static void menuFloristerias(Floristeria f) {
		int opcion = 1;
		while(opcion!=0) {
			System.out.println("\n-----------------------------------------");
			System.out.println("Opciones para Floristeria " + f.getNombre().toUpperCase());
			System.out.println("-----------------------------------------\n");
			
			System.out.println("1- Agregar Producto");
			System.out.println("2- Retirar Producto");
			System.out.println("3- Ver Productos");
			System.out.println("4- Ver Stock de Productos (Cantidades)");
			System.out.println("5- Ver Valor Total € de Stock");
			System.out.println("6- Generar Compra (Ticket)");
			System.out.println("7- Ver todas las ventas");
			System.out.println("8- Ver Ganancias\n");
			
			System.out.println("9- Seleccionar/crear otra Floristeria");
			System.out.println("0- Volver al Menu Anterior\n");
			opcion = ingresaNum("Ingresa una opcion para continuar...");
			
			switch (opcion) {
				case 0, 9:
					System.out.println("Volviendo al Menú Inicial...");
					opcion = 0;
					break;
				case 1:
					f.agregaProducto(defineProducto());
					break;
				case 2:
					f.listaProductos();
					if (f.getProductos().size()>0) {
						f.retiraProducto(ingresaStr("Dime el nombre del producto que quieres eliminar"));
					}
					break;
				case 3:
					f.listaProductos();
					break;
				case 4:
					System.out.println(f.getStock().getExistencias());
					break;
				case 5:
					System.out.println("Valor total de stock de Floristeria " + f.getNombre().toUpperCase());
					System.out.println(f.getStock().calculaValorDeStock(f)+"€");
					break;
				case 6:
					generaTicket(f);
					break;
				case 7:
					f.listaVentas();
					break;
				case 8:
					System.out.println("Ganancias registradas para Floristeria " + f.getNombre().toUpperCase());
					System.out.println(f.calculaGanancia()+"€");
					break;				
				default:
					System.out.println("INGRESA UN NÚMERO VÁLIDO");
			}
		
		}
	
	}
	
	public static void generaTicket(Floristeria f) {
		Cliente c = generaCliente(f);
		List<Producto> p = generaListaCompra(f);
		f.actualizaVentas(new Ticket(c,p));
		System.out.println("Compra registrada correctamente");
	
		
	}
	
	
	public static List<Producto> generaListaCompra(Floristeria f) {
		boolean bucle = true;
		int indexProducto;
		List<Producto> p = new ArrayList();
		f.listaProductos();
		System.out.println("\nIngresa el nombre de los productos que quieres agregar a la lista de compra\nCuando acabes ingresa 'FIN'");
		while(bucle){
			String nombre = ingresaStr("...");
			if(nombre.equalsIgnoreCase("fin")) {
				bucle = false;
			} else {
				indexProducto = f.compruebaExistencia(nombre);
				if (indexProducto == -1) {
					System.out.println("El nombre ingresado no coincide con ningún producto");
				}else {
					Producto producto = f.getProductos().get(indexProducto);
					p.add(producto);
					f.retiraProducto(nombre);
					System.out.println(producto.getClass().getSimpleName()+ " "+ producto.getNombre()+ " agregado a la lista de compra");
					
				}

			}
			
		}
		return p;
	}
	
	public static Cliente generaCliente(Floristeria f) {
		int opcion=1, indexTicket;
		Cliente c=null;
		String nombre="", dni="";
		
		if (f.getVentas().size() > 0) {
			while(opcion!=0) {
				f.listaClientes();
				System.out.println("\n¿Qué deseas hacer?\n");
				System.out.println("1- Seleccionar un Ciente existente");
				System.out.println("2- Crear un Nuevo Cliente\n");
//				System.out.println("0- Salir del Programa\n");
				opcion = ingresaNum("Ingresa una opcion para continuar...");
				switch (opcion) {
//					case 0:
//						System.out.println("Saliendo del programa...");
//						break;
					case 1:
						dni = ingresaStr("Dime el DNI del Cliente");
						indexTicket = f.buscaCliente(dni);
						
						if (indexTicket > -1) {
							c = f.getVentas().get(indexTicket).getCliente();
							System.out.println("Cliente "+ c.getNombre()+ " Seleccionado");
							opcion = 0;
						}else {
							System.out.println("El dni ingresado no pertenece a ningún Cliente");
						}
						break;
					case 2:
						nombre = ingresaStr("Dime el NOMBRE del nuevo Cliente");
						dni = ingresaStr("Dime el DNI del nuevo Cliente");
						indexTicket = f.buscaCliente(dni);
						
						if (indexTicket == -1) {
							c = new Cliente (nombre, dni);
							opcion = 0;
						}else {
							System.out.println("El dni ingresado ya pertenece a un Cliente");
						}
						break;
					default:
						System.out.println("INGRESA UN NÚMERO VÁLIDO");
				}
			}
		} else {
			System.out.println("Actualmente no hay ningun cliente en el sistema de esta Floristeria.\n");
			nombre = ingresaStr("Dime el NOMBRE de un nuevo Cliente");
			dni = ingresaStr("Dime el DNI del nuevo Cliente");
			indexTicket = f.buscaCliente(dni);
			
			if (indexTicket == -1) {
				c = new Cliente (nombre, dni);
			}else {
				System.out.println("El dni ingresado ya pertenece a un Cliente");
			}
			
		}
		return c;
		
	}
	
	
	public static Producto defineProducto() {
		boolean bucle = true;
		Producto p = null;
		String nombre="";
		int precio=0;
		int opcion=0;
		while(bucle) {
			System.out.println("\nQue producto deseas Agregar?\n");
			System.out.println("1- Arbol");
			System.out.println("2- Flor");
			System.out.println("3- Decoración\n");
//			System.out.println("0- Volver al Menú Anterior\n");
			
			opcion = ingresaNum("Ingresa una opcion para continuar...");
			switch (opcion) {
				case 1:
					nombre = ingresaStr("Dime el nombre del Árbol");
					precio = ingresaNum("Dime el precio del Árbol");
					double altura = ingresaNum("Dime la altura del Árbol");
					p = new Arbol(nombre, precio, altura);
					bucle = false;
					break;
				default:
					System.out.println("INGRESA UN NÚMERO VÁLIDO");
			
			}
		}
		return p;
		
	}
	
	public static Floristeria creaFLoristeria() {
		Floristeria f = new Floristeria(ingresaStr("Dime el nombre de la Floristeria nueva..."));
		System.out.println("\nFloristeria " + f.getNombre() + " creada correctamente");
		return f;
	}

	public static int buscaFloristeria(String nombre) {
		boolean encontrada = false;
		int contador = 0, index = -1;
		
		while (contador < tiendas.size() && !encontrada) {
			if (tiendas.get(contador).getNombre().equalsIgnoreCase(nombre)){
				index = contador;
				encontrada = true;
			}
			contador ++;
		}	
		return index;
	}
	

	public static void guardaListaFloristeria(File file){

		try {
			FileOutputStream ficheroSalida = new FileOutputStream(file);
			ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
			objetoSalida.writeObject(tiendas);
			objetoSalida.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no exite");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

	public static List<Floristeria> recuperaListaFloristeria(File file) {
		tiendas = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			tiendas = (List<Floristeria>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("Actualmente no hay FLoristerias ingresadas en el sistema.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tiendas;
	}
	
		
	public static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();	
	}
	
	
	public static int ingresaNum(String str) {			
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextInt();	
	}


}
