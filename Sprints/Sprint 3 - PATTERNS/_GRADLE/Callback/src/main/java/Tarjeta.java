package s3t2Callback;

public class Tarjeta implements PasarelaPago {

	@Override
	public void procesoDePago() {
		System.out.println("Pago realizado con TARJETA DE CREDITO");
	}

}
