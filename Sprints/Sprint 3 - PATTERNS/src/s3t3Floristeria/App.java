package s3t3Floristeria;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class App {
	public static List<Floristeria> tiendas;
	
	public static void main(String[] args) {
		File file = new File("src/s3t3Floristeria/bd/DatosFloristerias.bin");
		tiendas = recuperaListaFloristeria(file);

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
				opcion = ingresaInt("Ingresa una opcion para continuar...");
				switch (opcion) {
					case 0:
						System.out.println("Saliendo del programa...");
						break;
					case 1:
						System.out.println("\n----------------------------------");
						System.out.println("FLORISTERIAS EN SISTEMA");
						System.out.println("----------------------------------\n");
						tiendas.stream().forEach(x -> System.out.println("-Floristeria " + x.getNombre()));
						System.out.println("\n----------------------------------");
						int indexFloristeria = buscaFloristeria(ingresaStr("Dime el nombre de la Floristeria"));
						if (indexFloristeria == -1) {
							System.out.println("xx-El nombre ingresado no es válido-xx");
						} else {
							f = tiendas.get(indexFloristeria);
							System.out.println("\nFloristeria " + f.getNombre() + " seleccionada");
							System.out.println("----------------------------------\n");
							menuFloristerias(f);
						}					
						break;
					case 2:
						f = creaFLoristeria();
						tiendas.add(f);
						menuFloristerias(f);
						break;
					default:
						System.out.println("xx-Ingresa un número válido-xx");
						
				}
			}
			
		} else { 
			System.out.println("A continuación crearemos una Floristeria para comenzar.\n");
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
			System.out.println("-----------------------------------------");
			
			System.out.println("1- Agregar Producto");
			System.out.println("2- Retirar Producto");
			System.out.println("3- Ver Productos");
			System.out.println("4- Ver Stock de Productos (Cantidades)");
			System.out.println("5- Ver Valor Total € de Stock");
			System.out.println("6- Generar Compra (Ticket)");
			System.out.println("7- Ver todas las Compras");
			System.out.println("8- Ver Ganancias\n");
			
			System.out.println("9- Seleccionar/crear otra Floristeria");
			System.out.println("0- Volver al Menu Anterior");
			System.out.println("-----------------------------------------\n");
						
			opcion = ingresaInt("Ingresa una opcion para continuar...");
			
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
					f.listaCantidadesStock();
					break;
				case 5:
					f.valorStock();
					break;
				case 6:
					generaTicket(f);
					break;
				case 7:
					f.listaVentas();
					break;
				case 8:
					System.out.println(f.calculaGanancia());
					break;				
				default:
					System.out.println("xx-Ingresa un número válido-xx");
			}
		
		}
	
	}
	
	public static void generaTicket(Floristeria f) {
		if (f.getProductos().size() > 0 ) {
			Cliente c = generaCliente(f);
			List<Producto> p = generaListaCompra(f);
			f.actualizaVentas(new Ticket(c,p));
			System.out.println("Compra registrada correctamente");	
		} else {
			System.out.println("xx-No hay productos en Stock para realizar una compra-xx");
		}
	
	}
	
	public static List<Producto> generaListaCompra(Floristeria f) {
		boolean bucle = true;
		int indexProducto;
		List<Producto> p = new ArrayList();
		f.listaProductos();
		System.out.println("\nIngresa el nombre de los productos que quieres agregar al carrito de compra\nCuando acabes ingresa 'FIN'");
		
		while(bucle){
			if (f.getProductos().size() <= 0 ) {
				System.out.println("No hay más Productos en Stock para seleccionar\n");
				bucle = false;
			} else {
				String nombre = ingresaStr("...");
				if(nombre.equalsIgnoreCase("fin")) {
					bucle = false;
				} else {
					indexProducto = f.compruebaExistencia(nombre);
					if (indexProducto == -1) {
						System.out.println("xx-El nombre ingresado no coincide con ningún producto\nIngresa un nombre válido-xx");
					} else {
						Producto producto = f.getProductos().get(indexProducto);
						p.add(producto);
						f.retiraProducto(nombre);
						System.out.println(producto.getClass().getSimpleName()+ " "+ producto.getNombre()+ " agregado al carrito de compra\n");
						
					}

				}
			}
						
		}
		return p;
	}
	
	public static Cliente generaCliente(Floristeria f) { //CHEQUEAR-EVITAR REPETIR
		int opcion=1, indexTicket;
		Cliente c=null;
		String nombre="", dni="";
		
		if (f.getVentas().size() > 0) {
			while(opcion!=0) {
				f.listaClientes();
				System.out.println("\n¿Qué deseas hacer?\n");
				System.out.println("1- Seleccionar un Ciente existente");
				System.out.println("2- Crear un Nuevo Cliente\n");
				opcion = ingresaInt("Ingresa una opcion para continuar...");
				switch (opcion) {
					case 1:
						dni = ingresaStr("Dime el DNI del Cliente");
						indexTicket = f.buscaCliente(dni);
						
						if (indexTicket > -1) {
							c = f.getVentas().get(indexTicket).getCliente();
							System.out.println("Cliente "+ c.getNombre()+ " Seleccionado");
							opcion = 0;
						}else {
							System.out.println("xx-El dni ingresado no pertenece a ningún Cliente-xx");
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
							System.out.println("xx-El dni ingresado ya pertenece a un Cliente-xx");
						}
						break;
					default:
						System.out.println("xx-Ingresa un número válido-xx");				}
			}
		} else {
			System.out.println("Actualmente no hay ningun cliente en el sistema de esta Floristeria.\n");
			nombre = ingresaStr("Dime el NOMBRE de un nuevo Cliente");
			dni = ingresaStr("Dime el DNI del nuevo Cliente");
			indexTicket = f.buscaCliente(dni);
			
			if (indexTicket == -1) {
				c = new Cliente (nombre, dni);
			}else {
				System.out.println("xx-El dni ingresado ya pertenece a un Cliente-xx");
			}
			
		}
		return c;
		
	}
	
	public static Producto defineProducto() {
		boolean bucle = true;
		Producto p = null;
		String nombre="";
		double precio=0;
		int opcion=0;
		
		while(bucle) {
			System.out.println("\nQue producto deseas Agregar?\n");
			System.out.println("1- Arbol");
			System.out.println("2- Flor");
			System.out.println("3- Decoración\n");
			
			opcion = ingresaInt("Ingresa una opcion para continuar...");
			switch (opcion) {
				case 1:
					nombre = ingresaStr("Dime el nombre del Árbol");
					precio = ingresaDecimal("Dime el precio del Árbol");
					double altura = ingresaDecimal("Dime la altura del Árbol");
					p = new Arbol(nombre, precio, altura);
					bucle = false;
					break;
				case 2:
					nombre = ingresaStr("Dime el nombre de la Flor");
					precio = ingresaDecimal("Dime el precio de la Flor");
					String color = ingresaStr("Dime el color de la Flor");
					p = new Flor(nombre, precio, color);
					bucle = false;
					break;
				case 3:
					nombre = ingresaStr("Dime el nombre de la Decoración");
					precio = ingresaDecimal("Dime el precio de la Decoración");
					String material = defineMaterialDeco();
					p = new Decoracion(nombre, precio, material);
					bucle = false;
					break;
					
				default:
					System.out.println("xx-Ingresa un número válido-xx");
			
			}
		}
		return p;
	
	}
	
	public static String defineMaterialDeco() {
		boolean bucle = true;
		int opcion=0;
		String material="";
		while(bucle) {
			System.out.println("\nOpciones de Material para Decoración\n");
			System.out.println("1- Madera");
			System.out.println("2- Plástico");
			
			opcion = ingresaInt("Dime el material de la Decoración...");
			switch(opcion) {
				case 1:
					material = "Madera";
					bucle=false;
					break;
				case 2:
					material = "Plástico";
					bucle = false;
					break;
				default:
					System.out.println("xx-Ingresa un número válido-xx");
			}
		}
		
		return material;
		
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
			System.out.println("Error al intentar guardar datos--> El fichero no exite");
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
			System.out.println("Actualmente no hay Floristerias en el sistema.\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tiendas;
	}
	
	public static String ingresaStr(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		String res = sc.nextLine();
		while (res.length() == 0) {
			System.out.println("xx-No has ingresado ningún valor-xx\n");
			res = ingresaStr(str);
		}
		return res;	
	}

	static double ingresaDecimal(String str){
		boolean numOk = false;
		double num=-1;
		Scanner sc = new Scanner(System.in);
		System.out.println(str);
		while (!numOk) {
			 try{
				 num = Double.parseDouble(sc.nextLine());
				 numOk=true;
	        }catch (Exception e) {
	            System.out.println("Recuerda ingresar un número válido...");
	        }
			
		}		
		return num;	
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
	            System.out.println("Recuerda ingresar un número válido...");
	        }
			
		}		
		return num;	
	}


}
