package s3t1AbstractFactory;

public class FabricaDireccion implements FabricaAbstracta {

	@Override
	public ITelefono getpaisTelefono(String pais) {
		return null;
	}

	@Override
	public IDireccion getpaisDireccion(String pais) {
		
		if (pais.equalsIgnoreCase("España")){
			return new DireccionEspaña();
			
		}else if (pais.equalsIgnoreCase("Argentina")) {
			return new DireccionArgentina();
		}
		return new DireccionVacia();
	}

}
