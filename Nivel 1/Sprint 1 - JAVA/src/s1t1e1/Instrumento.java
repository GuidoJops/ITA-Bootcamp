package s1t1e1;

public abstract class Instrumento {
	private String nombre;
	private int precio;
	
	static {
		System.out.println("Bloque estatico!\n");
	}
	
	public Instrumento(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public abstract String tocar();
	
	public String infoInstrumento() {
		return "El instrumento es un/a: "+ nombre+ " y vale: "+ precio+"€";
	}
}
