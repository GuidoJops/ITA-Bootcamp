package s3t1AbstractFactory;

public class TelefonoEspa�a implements ITelefono {
	
	private int prefijo;
	private int numero;
	
	public TelefonoEspa�a() {
		this.prefijo = 34;
		this.numero = 637492019;
		
	}

	@Override
	public void agregar() {
		System.out.println("Telefono de Espa�a agregado");

	}

}
