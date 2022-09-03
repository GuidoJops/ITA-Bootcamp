package s1t1e2;

public class Coche {
	static private final String MARCA;
	static private  String modelo;
	private final int POTENCIA;
	
	static {
		MARCA = "BMW";
		modelo ="320d";
	}
	
	public Coche(int potencia) {
		POTENCIA = potencia;
	}
	
	public static void frenar(Coche car) {
		System.out.println("El vehiculo "+ car+ " está frenando");
	}
	
	public void acelerar() {
		System.out.println("El vehiculo " +toString()+" está acelerando");
	}

	public String toString() {
		return MARCA + " "+ modelo + " de "+ POTENCIA + "hp";
	}
}
