package s3t3Floristeria;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class App {
	
   
	public static void main(String[] args) {

		File file = new File("src/s3t3Floristeria/bd/DatosFloristerias.bin");
		List<Floristeria> listaFlori = recuperaListaFloristeria(file);
		




	}

	public static void guardaListaFloristeria(File file, List<Floristeria> lista){

		try {
			FileOutputStream ficheroSalida = new FileOutputStream(file);
			ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
			objetoSalida.writeObject(lista);
			objetoSalida.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no exite");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static List<Floristeria> recuperaListaFloristeria(File file) {
		List<Floristeria> lista = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			lista = (List<Floristeria>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no existe");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
		
}
