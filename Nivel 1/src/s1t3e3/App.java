package s1t3e3;

import java.io.BufferedReader;
import java.io.FileReader;
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
		String user;
		FileReader fl;
		BufferedReader br;
		String line;
		String [] kv;
		//int cont=0;
		
		HashMap<String, String> countries = new HashMap<String,String>();
		
		
//		user = ingresaStr("Dime tu nombre")
		
		try {
			fl = new FileReader("src/s1t3e3/Countries.txt");
			br = new BufferedReader(fl);
			
			do {
				line = br.readLine();
				if(line!=null) {
					kv = line.split(" ");
					countries.put(kv[0],kv[1]);
					//System.out.println(kv[0]);
					//cont+=1;
//					System.out.println(kv[1]);

				}
				
			}while(line!=null);	
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error.\nVerifique la ruta del fichero.");
		}
			
		for (String key:countries.keySet()) {
	    String value = countries.get(key);
	    System.out.println( key +"-->"+ value);
	}
		//System.out.println(cont);
		juego(countries);
	
		System.out.println("\nFIN DEL PROGRAMA");
	}
	

	static String ingresaStr(String str) {		
		Scanner input = new Scanner(System.in);
		System.out.println(str);
		return input.nextLine();
	}

	static void juego(HashMap<String, String> countries) {
		int puntaje = 0;
		for(int i=10; i>0;i--) {
			int randomNumber = (int) (Math.floor(Math.random() * (51+1)));
			Object key = countries.keySet().toArray()[randomNumber];
			Object value = countries.get(key).toUpperCase();
			String str = ingresaStr("Acierta la Captial de "+ key+"...");
			System.out.println(value);
			if (compruebaAcierto(value, str)) {
				puntaje++;
			}
			
		}
	
		System.out.println(puntaje);
		
	}
	
	static boolean compruebaAcierto(Object val, String str) {
		return (val.equals(str.toUpperCase()));
	}
}
