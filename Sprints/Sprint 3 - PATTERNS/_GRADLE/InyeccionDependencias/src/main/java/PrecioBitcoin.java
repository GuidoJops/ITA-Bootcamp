package s3t2InyeccionDependencias;

public class PrecioBitcoin implements IMoneda {

	@Override
	public double convierteMoneda(Producto p) {
		System.out.print("Precio en BitCoin --> ");
		return p.getPrecio()*0.000050;	
	}

}