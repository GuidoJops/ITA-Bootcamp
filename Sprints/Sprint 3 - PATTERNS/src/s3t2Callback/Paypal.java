package s3t2callback;

public class Paypal implements PasarelaPago {
	
	@Override
	public void procesoDePago() {
		System.out.println("Pago realizado con PAYPAL");
	}

}
