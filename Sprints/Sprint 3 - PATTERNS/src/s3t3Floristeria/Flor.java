package s3t3Floristeria;

import java.io.Serializable;

public class Flor extends Producto {
	private String color;
	

	public Flor (String nombre, double precio, String color) {
		super(nombre, precio);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	@Override
	public String getInfo() {
		return "Tipo:   Flor\n"
				+ "Nombre: " + nombre
				+"\nColor:  "+ color
				+"\nPrecio: " + precio + "€\n";
	}

}
