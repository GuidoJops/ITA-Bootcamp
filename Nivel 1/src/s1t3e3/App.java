package s1t3e3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/*
 Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals. 
 El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. 
 El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, guardat en el HashMap. 
 Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. 
 Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades les capitals de 10 països 
 de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.
 */
public class App {

	public static void main(String[] args) {
		String user="";
		FileReader fl;
		BufferedReader br;
		String line;
		String [] kv;
		int numberCountries=0, score;
		
		HashMap<String, String> countries = new HashMap<String,String>();
		
		
		user = ingresaStr("Dime tu nombre");
		
		try {
			fl = new FileReader("src/s1t3e3/Countries.txt");
			br = new BufferedReader(fl);
			System.out.println("Lectura de fichero Exitosa!");
			
			do {
				line = br.readLine();
				if(line!=null) {
					kv = line.split(" ");
					countries.put(kv[0],kv[1]);
					//System.out.println(kv[0]);
					numberCountries+=1;
//					System.out.println(kv[1]);

				}
				
			}while(line!=null);	
			
			br.close();	//Cierro Buffer
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error.\nVerifique la ruta del fichero.");
		}
			
		for (String key:countries.keySet()) {
	    String value = countries.get(key);
//	    System.out.println( key +"-->"+ value);
		}
		System.out.println(numberCountries);
		score = juego(countries,numberCountries);
		escribeFichero(user, score);
	
		System.out.println("\nFIN DEL PROGRAMA");
	}
	
	static void escribeFichero(String usr, int score) {
		try {
			String line;
			FileWriter wr=new FileWriter("src/s1t3e3/Puntajes.txt", true); //No se sobrescribe el fichero
			BufferedWriter bw = new BufferedWriter(wr);
			
			bw.write(usr + "---> "+ score+"\n");
			
			System.out.println("Se ha cargado el puntaje en el fichero externo");
			
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

	static int juego(HashMap<String, String> countries, int numberCountries) {
		int score = 0, randomNumber;
		for(int i=3; i>0;i--) {
			
			randomNumber = (int) (Math.floor(Math.random() * (numberCountries)));; //A veces da el mismo Nº
			Object key = countries.keySet().toArray()[randomNumber];
			Object value = countries.get(key).toUpperCase();
			String str = ingresaStr("Acierta la Captial de "+ key+"..." + randomNumber);
			System.out.println(value);
			if (compruebaAcierto(value, str)) {
				score++;
			}
			
		}
	
		return score;
		
	}
	
	static boolean compruebaAcierto(Object val, String str) {
		return (val.equals(str.toUpperCase().replace(" ", "_")));
	}
}
