package s3t2Callback;

public class CuentaBancaria implements PasarelaPago {

	@Override
	public void procesoDePago() {
		System.out.println("Pago realizado. Dinero trasnferido desde CUENTA BANCARIA");
	}

}
