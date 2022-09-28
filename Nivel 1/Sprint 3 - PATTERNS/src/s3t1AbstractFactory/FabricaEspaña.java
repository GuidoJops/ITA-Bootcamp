package s3t1AbstractFactory;

public class FabricaEspaña implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono(int numero) {
		return new TelefonoEspaña(numero);
	}

	@Override
	public IDireccion createDireccion(String calle, int numero, String codigoPostal, String ciudad) {
		return new DireccionEspaña(calle, numero, codigoPostal, ciudad);
	}

}
