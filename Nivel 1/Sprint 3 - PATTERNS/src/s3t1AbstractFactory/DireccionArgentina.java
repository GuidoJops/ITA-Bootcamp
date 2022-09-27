package s3t1AbstractFactory;

public class DireccionArgentina implements IDireccion {
	
	private String calle;
	private int numero;
	private String codigoPostal;
//	private pais;
	
	public DireccionArgentina() {
		this.calle = "Calle Libertador";
		this.numero = 223;
		this.codigoPostal = "1428";
	}

	@Override
	public void agregar() {
		System.out.println("Direccion de Argentina agregada");
		
	}

}
