package s3t1AbstractFactory;

public class TelefonoEspa�a implements ITelefono {
	
	private int prefijo;
	private int numero;
	
	public TelefonoEspa�a() {
		this.prefijo = 34;
		this.numero = 637492019;
		
	}

	@Override
	public void getTelefono() {
		System.out.println("TELEFONO ESPA�A: +"+prefijo +" "+numero);

	}

}
