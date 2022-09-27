package s3t1AbstractFactory;

public class TelefonoEspaña implements ITelefono {
	
	private int prefijo;
	private int numero;
	
	public TelefonoEspaña() {
		this.prefijo = 34;
		this.numero = 637492019;
		
	}

	@Override
	public void getTelefono() {
		System.out.println("TELEFONO ESPAÑA: +"+prefijo +" "+numero);

	}

}
