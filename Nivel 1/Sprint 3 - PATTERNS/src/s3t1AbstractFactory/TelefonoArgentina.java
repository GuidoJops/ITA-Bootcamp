package s3t1AbstractFactory;

public class TelefonoArgentina implements ITelefono {
	
	private int prefijo;
	private int numero;
	
	public TelefonoArgentina() {
		this.prefijo = 54;
		this.numero = 1165433982;
	}

	@Override
	public void agregar() {
		System.out.println("Telefono de Argentina agregado");

	}

}
