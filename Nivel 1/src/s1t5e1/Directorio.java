package s1t5e1;
/*Exercici 1
 *Crea una classe que llisti alfabèticament 
 *el contingut d'un directori rebut per paràmetre.
 */

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Directorio {

	public static void main(String[] args) {
		String ruta = ingresaStr("Dime la ruta que quieres listar...");
		listarDirectorio(ruta);
	}

	public static void listarDirectorio(String ruta) {
		Path dir = Paths.get(ruta);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
			
		} catch (IOException | DirectoryIteratorException e) {
			System.out.println("Algo ha ido mal :(");
		}

	}

	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}
}
