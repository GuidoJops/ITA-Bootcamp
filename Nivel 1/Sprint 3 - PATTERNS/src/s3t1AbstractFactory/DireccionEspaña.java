package s3t1AbstractFactory;

public class DireccionEspaña implements IDireccion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
//	private pais;
	
	public DireccionEspaña() {
		this.calle = "Calle Santo tomas";
		this.numero = 643;
		this.codigoPostal = "08030";
	}

	@Override
	public void getDireccion() {
		System.out.println("DIRECCION ESPAÑA: " + calle +","+ " Nº " +numero+ ", cp: "+ codigoPostal );
	}

}
