package s3t1AbstractFactory;

public class FabricaEspaña implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono() {
		return new TelefonoEspaña();
	}

	@Override
	public IDireccion createDireccion() {
		return new DireccionEspaña();
	}

}
