package s3t1AbstractFactory;

public class DireccionEspa�a implements IDireccion {
	
	private String calle, codigoPostal, ciudad;
	private final String PAIS;
	private int numero;
	
	public DireccionEspa�a(String calle, int numero, String codigoPostal, String ciudad) {
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		PAIS = "ESPA�A";
		
	}
	
	public String getDireccion() {
		return  calle +","+ " N�" +numero+ ", cp-"+ codigoPostal + ", Ciudad-"+ ciudad+ ", Pais-"+ PAIS;
		
	}

}
