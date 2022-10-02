package s3t1AbstractFactory;

public interface FabricaAbstracta {
	ITelefono createTelefono(int numero);
	IDireccion createDireccion(String calle, int numero, String codigoPostal, String ciudad);

}
