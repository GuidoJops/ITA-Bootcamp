package s3t1AbstractFactory;

public class TelefonoVacio implements ITelefono {

	@Override
	public void agregar() {
		System.out.println("Se necesitan datos del pais para agregar un telefono");


	}

}
