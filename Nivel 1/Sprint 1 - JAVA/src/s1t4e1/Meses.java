/*
 Crea una classe Java que insereixi en una llista ordenada els noms dels mesos de l'any.
Verifica amb jUnit que la llista t� 12 posicions, que no �s nul�la i que en la seva posici� 8 cont� el nom 'agost'.
 */

package s1t4e1;
import java.util.ArrayList;

public class Meses {
	private ArrayList <String> meses = new ArrayList<String>();
	
	

	public Meses () {
		meses.add("Enero");
		meses.add("Febrero");
		meses.add("Marzo");
		meses.add("Abril");
		meses.add("Mayo");
		meses.add("Junio");
		meses.add("Julio");
		meses.add("Agosto");
		meses.add("Septiembre");
		meses.add("Octubre");
		meses.add("Noviembre");
		meses.add("Diciembre");
		
	}
	
	public ArrayList<String> getMeses() {
		return meses;
	}



}
