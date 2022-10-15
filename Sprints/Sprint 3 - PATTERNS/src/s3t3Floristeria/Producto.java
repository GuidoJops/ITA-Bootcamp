package s3t3Floristeria;

public abstract class Producto {
	private String nombre;
	private double precio;
	
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public abstract String getNombre();
	
	public double getPrecio() {
		return precio;
	}


}
