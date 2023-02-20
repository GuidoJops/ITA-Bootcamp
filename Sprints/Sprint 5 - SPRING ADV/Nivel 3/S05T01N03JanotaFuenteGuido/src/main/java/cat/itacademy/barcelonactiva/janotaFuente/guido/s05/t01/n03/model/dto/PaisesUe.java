package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto;

import java.util.Arrays;
import java.util.List;


public class PaisesUe {
	
	
	private static  List<String> listaPaisesUe = Arrays.asList("Alemania","Austria","Bélgica","Bulgaria","Chipre",
			 "Croacia","Dinamarca","España","Eslovaquia","Eslovenia",
			 "Estonia","Finlandia","Francia","Grecia","Hungría",
			 "Irlanda","Italia","Letonia","Lituania","Luxemburgo",
			 "Malta","Países Bajos","Polonia","Portugal",
			 "República Checa","Rumania","Suecia");

	
	

	
	public static List<String> getListaPaisesUe() {
		return listaPaisesUe;
	}

	public static void setListaPaisesUe(List<String> listaPaisesUe) {
		PaisesUe.listaPaisesUe = listaPaisesUe;
	}





	public  static  boolean buscaPaisUe(String nombrePais) {
		boolean paisOk = false;
		int contador= 0;
		
		while (contador < listaPaisesUe.size() && !paisOk) {
			if (listaPaisesUe.get(contador).equalsIgnoreCase(nombrePais)){
				paisOk = true;
			}
			contador ++;
		}	
		return paisOk;
		
	}

}
