package s3t3Floristeria;

public abstract class Producto {
	String nombre;
	double precio;
	
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public abstract String getNombre();
	
	public abstract double getPrecio();


}
