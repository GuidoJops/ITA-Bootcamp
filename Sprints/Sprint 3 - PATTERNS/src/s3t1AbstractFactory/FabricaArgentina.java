package s3t1AbstractFactory;

public class FabricaArgentina implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono(int numero) {
		return new TelefonoArgentina(numero);
	}

	@Override
	public IDireccion createDireccion(String calle, int numero, String codigoPostal, String ciudad) {
		return new DireccionArgentina(calle, numero, codigoPostal, ciudad);
	}

}


