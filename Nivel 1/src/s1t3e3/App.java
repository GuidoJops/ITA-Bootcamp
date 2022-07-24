/*
 Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals. 
 El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. 
 El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, guardat en el HashMap. 
 Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. 
 Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades les capitals de 10 països 
 de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.
 */
package s1t3e3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
	static int numberCountries=0, index=-1;
	static HashMap<String, String> countries = new HashMap<String,String>();
	static List<Integer> randomNumbers = new ArrayList<>();
	

	public static void main(String[] args) {
		int score;
		String user = ingresaStr("Dime tu nombre");		
		leeFichero();
		
		
		//GENERO LISTA DE NUMEROS RANDOM (pasar a funcion??)
		for (int i = 0; i < numberCountries; i++) {
			randomNumbers.add(i);
		}
		Collections.shuffle(randomNumbers);
		
		
		
			
		score = evaluaCantAciertos(numberCountries);
		escribeFichero(user, score);
		
		
	
		System.out.println("\nFIN DEL PROGRAMA");
	}
	
	
	//LEE FICHEROS Y AGREGA CONTENIDO A HASHMAP
	static void leeFichero() {
		FileReader fl;
		BufferedReader br;
		String line;
		String [] kv;
		
		try {
			fl = new FileReader("src/s1t3e3/Countries.txt");
			br = new BufferedReader(fl);
			System.out.println("Lectura de fichero Exitosa!\n");
			
			do {
				line = br.readLine();
				if(line!=null) {
					kv = line.split(" ");
					countries.put(kv[0],kv[1]);
					numberCountries+=1;
				}
				
			}while(line!=null);	
			
			br.close();			//Cierro Buffer
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error.\nVerifique la ruta del fichero.");
		}
	}
	
	static void escribeFichero(String usr, int score) {
		try {
			String line;
			FileWriter wr=new FileWriter("src/s1t3e3/Puntajes.txt", true); //No se sobrescribe el fichero
			BufferedWriter bw = new BufferedWriter(wr);
			
			bw.write(usr + "---> "+ score+"\n");
			
			System.out.println(usr + " ha conseguido: "+ score + " puntos.");
			
			System.out.println("\nSe ha cargado el puntaje en el fichero externo");
			
			bw.close();	//Cierro Buffer
			
		} catch (IOException e) {
			
			System.out.println("Ups..Algo ha fallado al intentar escribir el fichero.");
		}
	}
	
	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}

	static int evaluaCantAciertos(int numberCountries) {
		int score = 0;
		
		for(int i=10; i>0;i--) {
			Object key = countries.keySet().toArray()[numRandom()];
			Object value = countries.get(key).toUpperCase();
			String str = ingresaStr("Acierta la Captial de "+ key+"...");
//			System.out.println(value); 			//Respuesta correcta
			
			if (compruebaAcierto(value, str)) {
				score++;
			}
			
		}
	
		return score;
		
	}
	
	static boolean compruebaAcierto(Object val, String str) {
		return (val.equals(str.toUpperCase().replace(" ", "_")));
	}

	static int numRandom() {
		index++;
//		System.out.println(randomNumbers.get(index));
		return randomNumbers.get(index);
		
		
	}

}
