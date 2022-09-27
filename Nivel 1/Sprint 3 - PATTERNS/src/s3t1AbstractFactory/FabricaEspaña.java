package s3t1AbstractFactory;

public class FabricaEspa�a implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono() {
		return new TelefonoEspa�a();
	}

	@Override
	public IDireccion createDireccion() {
		return new DireccionEspa�a();
	}

}
