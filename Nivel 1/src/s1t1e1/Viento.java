package s1t1e1;

public class Viento extends Instrumento{
	
	public Viento(String nombre, int precio) {
		super(nombre, precio);
	}
	public String tocar() {
		return "Se esta tocando un instrumento de viento";
	}
	
}
