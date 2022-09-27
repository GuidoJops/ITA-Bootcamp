package s3t1AbstractFactory;

public class FabricaTelefono implements FabricaAbstracta {

	@Override
	public ITelefono getpaisTelefono(String pais) {
		
		if(pais.equalsIgnoreCase("España")) {
			return new TelefonoEspaña();
			
		} else if (pais.equalsIgnoreCase("Argentina")) {
			return new TelefonoArgentina();
		}
		return new TelefonoVacio();
	}

	@Override
	public IDireccion getpaisDireccion(String pais) {
		return null;
	}

}
