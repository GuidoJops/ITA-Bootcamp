package s3t1AbstractFactory;

public class DireccionArgentina implements IDireccion {
	
	private String calle, codigoPostal, ciudad;
	private final String PAIS;
	private int numero;
	
	public DireccionArgentina(String calle, int numero, String codigoPostal, String ciudad) {
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		PAIS = "ARGENTINA";
		
	}
	
	public String getDireccion() {
		return  calle +","+ " Nº" +numero+ ", cp-"+ codigoPostal + ", Ciudad-"+ ciudad+ ", Pais-"+ PAIS;
		
	}

}
