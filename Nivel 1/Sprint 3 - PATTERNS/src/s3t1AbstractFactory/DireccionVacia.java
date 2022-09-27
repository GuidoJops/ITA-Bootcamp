package s3t1AbstractFactory;

public class DireccionVacia implements IDireccion {

	@Override
	public void agregar() {
		System.out.println("Se necesitan datos del pais para agregar una direccion");

	}

}
