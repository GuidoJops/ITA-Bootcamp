package s1t7e1;

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
	

}
