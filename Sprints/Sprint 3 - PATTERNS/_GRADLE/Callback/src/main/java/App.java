package s3t2Callback;

public class App {

	public static void main(String[] args) {
		Paypal compra1 = new Paypal();
		Tarjeta compra2 = new Tarjeta();
		CuentaBancaria compra3 = new CuentaBancaria();

		TiendaZapatos tz = new TiendaZapatos();
		tz.procesarPago(compra1);
		tz.procesarPago(compra2);
		tz.procesarPago(compra3);
	}

}
