package s3t1AbstractFactory;

public class TelefonoArgentina implements ITelefono {
	
	private int prefijo;
	private int numero;
	
	public TelefonoArgentina() {
		this.prefijo = 54;
		this.numero = 1165433982;
	}

	@Override
	public void getTelefono() {
		System.out.println("TELEFONO ARGENTINA: +"+prefijo +" "+numero);

	}

}
