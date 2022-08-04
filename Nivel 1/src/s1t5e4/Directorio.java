package s1t5e4;
/*
- Exercici 4
Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.*/


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

import s1t2.Venta;


public class Directorio {

	public static void main(String[] args) {
		menuPrincipal();
		
		System.out.println("--FIN DEL PROGRAMA--");
	}
	
	static void menuPrincipal() {
		int opcion = 1;
		while(opcion!=0) {			
			opcion = ingresaInt("\n--Escoge el número que corresponda--\n1.- Listar Directorio\n2.- Listar Árbol de Directorios"
								+ "\n3.- Leer Fichero TXT\n\n0.- Salir del programa");
			switch(opcion) {
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				case 1:
					listarDirectorio(ingresaStr("Dime la ruta que quieres listar..."));
					break;
				case 2:
					String rutaArecorrer = ingresaStr("Dime una ruta para recorrer...");
					subMenuDirectorios(rutaArecorrer);
					break;
				case 3:
					leeFichero(ingresaStr("Dime la ruta del fichero que quieres leer..."));
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
	
	public static void subMenuDirectorios(String rutA) {
		int op = 0;
		while (op != 1 && op != 2) {
			op = ingresaInt("\n\n--Escoge el número que corresponda--\n1.- Imprimir información en pantalla"
					+ "\n2.- Guardar información en un fichero TXT");

			switch (op) {
				case 1:
					directoriosEnPantalla(rutA);
					break;
				case 2:
					String rutaParaGuardar = ingresaStr("Dime una ruta para guardar la información...");
					directoriosEnFichero(rutA, rutaParaGuardar);
					break;
				default:
					System.out.println("Recuerda escoger un Nº entre 1 y 2...");

			}

		}

	}

	public static void listarDirectorio(String ruta) {
		Path dir = Paths.get(ruta);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
			
		} catch (IOException e) {
			System.out.println("Algo ha ido mal :(");
		}

	}
	
	public static void directoriosEnPantalla(String ruta) {
		Path dir = Paths.get(ruta);
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			for (Path file : stream) {
				if (Files.isDirectory(file)) {
					System.out.println("\n-PATH: " + file.toAbsolutePath());
					System.out.println("-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file));
					directoriosEnPantalla(file.toAbsolutePath().toString());

				} else {
					System.out.println("\n-PATH: " + file.toAbsolutePath());
					System.out.println("-FILE-NAME: " + file.getFileName() + "-->F" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file));
				}
			}

		} catch (IOException e) {
			System.out.println("Algo ha ido mal :(");

		}
	}
	
	public static void directoriosEnFichero(String rutA, String rutB) {
		Path dir = Paths.get(rutA);
		String str = "";
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			for (Path file : stream) {
				if (Files.isDirectory(file)) {
					str = "\n-PATH: " + file.toAbsolutePath() + "\n" + "-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file)+"\n";
					
					escribeFichero(str,rutB);
					directoriosEnFichero(file.toAbsolutePath().toString(),rutB);

				} else {
					str = "\n-PATH: " + file.toAbsolutePath() + "\n" + "-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file)+"\n";
					escribeFichero(str, rutB);
				}

			}

		} catch (IOException e) {
			System.out.println("Algo ha ido mal :(");

		}
	}
	
	static void leeFichero(String rut) {
		Path dir = Paths.get(rut);
		try (InputStream in = Files.newInputStream(dir);
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		    System.out.println("\n--Lectura de fichero finalizada");
		} catch (IOException x) {
			System.out.println("Algo ha ido mal...");
		}
	}
		
	static void escribeFichero(String str, String ruta) {
		ruta += "\\DIRECTORIOS.txt";
		byte data[] = str.getBytes();
		Path p = Paths.get(ruta);

	try (OutputStream out = new BufferedOutputStream(
			      Files.newOutputStream(p, CREATE, APPEND))) {
			out.write(data, 0, data.length);
		} catch (IOException x) {
			System.out.println("Ups..Algo ha fallado al intentar escribir el fichero.");
		}
	}
	
	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
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

	
	
//	static void escribeFichero2(String str, String ruta) {
//		ruta+="\\DIRECTORIOS.txt";
//		try {
//			FileWriter wr=new FileWriter(ruta, true); 	//No se sobreescribe el fichero
//			BufferedWriter bw = new BufferedWriter(wr);
//			
//			bw.write(str);	
//			bw.close();		//Cierro Buffer
//					
//		} catch (IOException e) {
//			
//			System.out.println("Ups..Algo ha fallado al intentar escribir el fichero.");
//		}
//	}
	
}
