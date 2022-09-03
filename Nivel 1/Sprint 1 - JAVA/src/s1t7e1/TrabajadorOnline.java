package s1t7e1;

public class TrabajadorOnline extends Trabajador{
	private final int tarifaInternet;

	public TrabajadorOnline(String nombre, String apellido, double precioHora) {
		super(nombre, apellido, precioHora);
		tarifaInternet = 30; 

	}

		
	@Override
	public double CalculaSueldo(double horasTrabajadas) {
		return horasTrabajadas * getPrecioHora() + tarifaInternet;
	}
}