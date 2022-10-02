package s3t1AbstractFactory;

public class TelefonoArgentina implements ITelefono {
	
	private final int PREFIJO;
	private int numero;
	
	public TelefonoArgentina(int numero) {
		this.PREFIJO = 54;
		this.numero = numero;
	}
	
	@Override
	public String getTelefono() {
		return "+"+PREFIJO +"-"+numero;

	}


}
