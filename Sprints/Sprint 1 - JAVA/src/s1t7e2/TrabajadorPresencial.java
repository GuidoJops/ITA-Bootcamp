package s1t7e2;

public class TrabajadorPresencial extends Trabajador {
	static double gasolina;
	
	public TrabajadorPresencial(String nombre, String apellido, double precioHora) {
		super(nombre, apellido, precioHora);
		gasolina = 150; //Completar valor

	}

	
	@Override
	public double CalculaSueldo(double horasTrabajadas) {
		return horasTrabajadas * getPrecioHora() + gasolina;
	}
	
	@Deprecated
	public void gastogasolina() {
		System.out.println("EL gasto de Gasolina es: " + gasolina+ "€");
	}
}