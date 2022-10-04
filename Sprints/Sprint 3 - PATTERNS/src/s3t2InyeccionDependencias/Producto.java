package s3t2InyeccionDependencias;

public class Producto {
	private String nombre;
	private double precio;  // precio por defecto en EUROS

	public Producto (String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public static void cambiaMoneda(IMoneda moneda, Producto p) {
		System.out.println(moneda.convierteMoneda(p));
	}
	
	@Override
	public String toString() {
		return nombre + " -  "+ precio + " EUROS";

	}

}
