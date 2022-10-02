package s3t2callback;

public class Tarjeta implements PasarelaPago {

	@Override
	public void procesoDePago() {
		System.out.println("Pago realizado con TARJETA DE CREDITO");
	}

}
