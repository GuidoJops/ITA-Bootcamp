package s1t7e1;

public class Trabajador {
	private String nombre, apellido;
	private double precioHora;

	
	public Trabajador(String nombre, String apellido, double precioHora) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.precioHora = precioHora;
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public String getApellido() {
		return apellido;
		
	}
	
	public double getPrecioHora() {
		return precioHora;
		
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
		
	}
	
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	public String infoSueldoTrabajador(double hs) {
		return "Sueldo de "+ nombre + " " + apellido +" "+ CalculaSueldo(hs)+"€";
	}

	public double CalculaSueldo(double horasTrabajadas) {
		return horasTrabajadas*precioHora;
	}
	
	


}


