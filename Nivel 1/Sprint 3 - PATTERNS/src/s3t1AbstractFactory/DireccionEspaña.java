package s3t1AbstractFactory;

public class DireccionEspa�a implements IDireccion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
//	private pais;
	
	public DireccionEspa�a() {
		this.calle = "Calle Santo tomas";
		this.numero = 23;
		this.codigoPostal = "08030";
	}

	@Override
	public void agregar() {
		System.out.println("Direccion de Espa�a agregada");
		
	}

}
