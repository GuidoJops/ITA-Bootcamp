package s1t5e2;
/*
- Exercici 2
Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris 
amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla 
en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F), i la 
seva última data de modificació.
 */


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Directorio {

	public static void main(String[] args) {
		String ruta = ingresaStr("Dime una ruta...");
		recorreDirectorios(ruta);

	}

	public static void recorreDirectorios(String ruta) {
		Path dir = Paths.get(ruta);
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			for (Path file : stream) {
				if (Files.isDirectory(file)) {
					System.out.println("\n-PATH:" + file.toAbsolutePath());
					System.out.println("-FOLDER-NAME: " + file.getFileName() + "-->D" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file));
					recorreDirectorios(file.toAbsolutePath().toString());

				} else {
					System.out.println("\n-PATH:" + file.toAbsolutePath());
					System.out.println("-FILE-NAME: " + file.getFileName() + "-->F" + "\n-LAST-MODIFIED-TIME: "
							+ Files.getLastModifiedTime(file));
				}
			}

		} catch (IOException e) {
			System.out.println("Algo ha ido mal :(");

		}
	}

	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}
	
}
