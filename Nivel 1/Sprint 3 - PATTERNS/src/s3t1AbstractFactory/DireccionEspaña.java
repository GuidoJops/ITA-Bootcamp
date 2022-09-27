package s3t1AbstractFactory;

public class DireccionEspaña implements IDireccion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
//	private pais;
	
	public DireccionEspaña() {
		this.calle = "Calle Santo tomas";
		this.numero = 23;
		this.codigoPostal = "08030";
	}

	@Override
	public void agregar() {
		System.out.println("Direccion de España agregada");
		
	}

}
