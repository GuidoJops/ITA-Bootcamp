package s3t1AbstractFactory;

public class DireccionEspa�a implements IDireccion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
//	private pais;
	
	public DireccionEspa�a() {
		this.calle = "Calle Santo tomas";
		this.numero = 643;
		this.codigoPostal = "08030";
	}

	@Override
	public void getDireccion() {
		System.out.println("DIRECCION ESPA�A: " + calle +","+ " N� " +numero+ ", cp: "+ codigoPostal );
	}

}
