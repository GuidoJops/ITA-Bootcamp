package s3t1AbstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		List<Contacto> contactos = new ArrayList(); // SE PUEDE LLAMAR AGENDA TAMBIEN?¿?¿
		FabricaAbstracta fab;
		int opcion = -1;
		String pais ="";
		
		//MENU
		while(opcion!=0) {
			opcion = ingresaInt("\n--Escoge el número que corresponda--"
					+ "\n1.- Agregar Contacto ARGENTINO"
					+ "\n2.- Agregar Contacto ESPAÑOL"
					+ "\n3.- Ver Contactos de la Agenda"
					+ "\n\n0.- Salir del programa");
			switch(opcion) {
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				case 1:
					pais = "Argentina";
					fab = FabricaProductor.getFabrica(pais);
					agregaContacto(fab, contactos, pais);
					break;
				case 2:
					pais = "España";
					fab = FabricaProductor.getFabrica(pais);
					agregaContacto(fab, contactos, pais);
					break;
				case 3:
					System.out.println(contactos);
				default:
					System.out.println("Recuerda escoger números del 0 al 3");
			}
		}
		
		
		System.out.println("\nFIN DEL PROGRAMA");
		
	}
	
	public static void agregaContacto(FabricaAbstracta fab, List<Contacto> cont, String pais) {
		System.out.println("Se agregará un contacto de "+pais+"\n");
		String nombre= ingresaStr("Dime el nombre").toUpperCase();
		ITelefono tel =  fab.createTelefono(ingresaInt("Dime el Nº de telefono..."));
		IDireccion dir = fab.createDireccion(ingresaStr("Dime la calle"), 
												 ingresaInt("Dime el Nº de la calle"),
												 ingresaStr("Dime el codigo postal"),
												 ingresaStr("Dime la ciudad"));
		
		Contacto contacto = new Contacto(nombre, tel, dir);
		cont.add(contacto);
		System.out.println("Contacto '"+"' de "+pais.toUpperCase()+ " agregado a la agenda");
		
		
		
	}
		
	public static int ingresaInt(String str){
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
	
	public static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();	
	}
}
