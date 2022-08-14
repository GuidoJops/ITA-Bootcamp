package s1t7e2;

public class TrabajadorOnline extends Trabajador{
	private final int tarifaInternet;

	public TrabajadorOnline(String nombre, String apellido, double precioHora) {
		super(nombre, apellido, precioHora);
		tarifaInternet = 30; 

	}

	
	@Deprecated
	public void precioInternet() {
		System.out.println("El precio de la tarifa de internet es: " + tarifaInternet + "€");
	}
	
	@Override
	public double CalculaSueldo(double horasTrabajadas) {
		return horasTrabajadas * getPrecioHora() + tarifaInternet;
	}
}