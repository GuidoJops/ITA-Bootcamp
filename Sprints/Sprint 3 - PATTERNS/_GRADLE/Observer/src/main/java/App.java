package s3t2Observer;

public class App {

	public static void main(String[] args) {
		Sujeto bolsa = new Sujeto();
		
		new Agencia(bolsa,"Agencia Uno");
		new Agencia(bolsa,"Agencia Dos");
		new Agencia(bolsa,"Agencia Tres");
		
		// false = baja		true = sube
		System.out.println("Baja");	
		bolsa.setEstado(false);
	    System.out.println("Sube");	
	    bolsa.setEstado(true);

	}

}
