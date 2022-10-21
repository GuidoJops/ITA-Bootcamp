package s3t3Floristeria;

public class Arbol extends Producto {
	private double altura;
	

	public Arbol (String nombre, double precio, double altura) {
		super(nombre, precio);
		this.altura = altura;
	}
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	@Override
	public String getInfo() {
		return "Tipo:   Árbol\n"
				+ "Nombre: " + nombre
				+"\nAltura: "+ altura + "mts"
				+"\nPrecio: " + precio + "€\n";
	}


}
