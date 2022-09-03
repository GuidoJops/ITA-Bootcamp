package s1t5e3;
/*
- Exercici 3
Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Directorio {

	public static void main(String[] args) {
		String rutaArecorrer = ingresaStr("Dime una ruta para recorrer...");
		String rutaParaGuardar = ingresaStr("Dime una ruta para guardar la información...");
		rutaParaGuardar+= "\\DIRECTORIOS.TXT";

		recorreDirectorios(rutaArecorrer, rutaParaGuardar);

	}

	public static void recorreDirectorios(String rutA, String rutB) {
		Path dir = Paths.get(rutA);
		String str = "";
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			for (Path file : stream) {
				if (Files.isDirectory(file)) {
					str = "\n-PATH:" + file.toAbsolutePath() + "\n" + "-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file)+"\n";
					escribeFichero(str,rutB);
					recorreDirectorios(file.toAbsolutePath().toString(),rutB);

				} else {
					str = "\n-PATH:" + file.toAbsolutePath() + "\n" + "-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file)+"\n";
					escribeFichero(str, rutB);

				}
			}

		} catch (IOException e) {
			System.out.println("Algo ha ido mal :(");

		}

	}
	
	static void escribeFichero(String str, String ruta) {
		try {
			FileWriter wr=new FileWriter(ruta, true); 	//No se sobreescribe el fichero
			BufferedWriter bw = new BufferedWriter(wr);
			
			bw.write(str);	
			bw.close();		//Cierro Buffer
			
		} catch (IOException e) {
			
			System.out.println("Ups..Algo ha fallado al intentar escribir el fichero.");
		}
	}

	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}
	
}
