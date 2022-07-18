package s1t1e1;

public class Cuerda extends Instrumento{
	
	public Cuerda(String nombre, int precio) {
		super(nombre, precio);
	}
	public String tocar() {
		return "Se esta tocando un instrumento de cuerda";
	}
	
}
