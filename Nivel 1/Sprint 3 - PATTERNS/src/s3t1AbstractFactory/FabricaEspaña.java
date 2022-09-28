package s3t1AbstractFactory;

public class FabricaEspa�a implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono(int numero) {
		return new TelefonoEspa�a(numero);
	}

	@Override
	public IDireccion createDireccion(String calle, int numero, String codigoPostal, String ciudad) {
		return new DireccionEspa�a(calle, numero, codigoPostal, ciudad);
	}

}
