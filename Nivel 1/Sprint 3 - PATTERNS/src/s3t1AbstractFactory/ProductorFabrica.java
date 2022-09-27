package s3t1AbstractFactory;

public class ProductorFabrica {
	public static FabricaAbstracta getFabrica(String tipoFabrica) {
		
		if(tipoFabrica.equalsIgnoreCase("Direccion")) {
			return new FabricaDireccion();
			
		}else if (tipoFabrica.equalsIgnoreCase("Telefono")) {
			return new FabricaTelefono();
			
		}
		return null;
	}

}
