package s1t1e1;

public class Percusion extends Instrumento{
	
	public Percusion(String nombre, int precio) {
		super(nombre, precio);
	}
	
	//@Override
	public String tocar() {
		return "Se esta tocando un instrumento de percusion";
	}
	
}
