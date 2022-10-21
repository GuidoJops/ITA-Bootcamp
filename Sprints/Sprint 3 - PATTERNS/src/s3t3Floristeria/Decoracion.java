package s3t3Floristeria;

public class Decoracion extends Producto {
	private String material;
	

	public Decoracion (String nombre, double precio, String material) {
		super(nombre, precio);
		this.material = material;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	
	@Override
	public String getInfo() {
		return "Tipo:     Decoración\n"
				+ "Nombre:   " + nombre
				+"\nMaterial: "+ material
				+"\nPrecio:   " + precio + "€\n";
	}

}
