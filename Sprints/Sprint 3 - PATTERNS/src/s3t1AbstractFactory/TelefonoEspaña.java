package s3t1AbstractFactory;

public class TelefonoEspa�a implements ITelefono {
	
	private final int PREFIJO;
	private int numero;
	
	public TelefonoEspa�a(int numero) {
		this.PREFIJO = 34;
		this.numero = numero;
	}
	
	@Override
	public String getTelefono() {
		return "+"+PREFIJO +"-"+numero;

	}


}
