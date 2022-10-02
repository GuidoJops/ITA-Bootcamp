package s3t1Command;

public class Vehiculo {
	private String tipo;


	public Vehiculo(String tipo) {
		this.tipo=tipo;
	}
	

	public void arrancar(Vehiculo v) {
		System.out.println("El vehiculo " + v.tipo + " arranca");
	}
	
	public void acelerar(Vehiculo v) {
		System.out.println("El vehiculo " + v.tipo + " acelera");
	}
	
	public void frenar(Vehiculo v) {
		System.out.println("El vehiculo " + v.tipo + " frena");
	}
}
