package s3t1AbstractFactory;

public class FabricaArgentina implements FabricaAbstracta {

	@Override
	public ITelefono createTelefono() {
		return new TelefonoArgentina();
	}

	@Override
	public IDireccion createDireccion() {
		return new DireccionArgentina();
	}

}


