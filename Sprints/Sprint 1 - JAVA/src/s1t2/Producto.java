package s1t2;

public class Producto {
	private String nombre;
	private int precio;
	
	
	public Producto (String nombre, int precio) {
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
}	