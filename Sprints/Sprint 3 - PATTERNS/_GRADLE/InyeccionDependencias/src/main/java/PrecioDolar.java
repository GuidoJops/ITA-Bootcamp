package s3t2InyeccionDependencias;

public class PrecioDolar implements IMoneda {

	@Override
	public double convierteMoneda(Producto p) {
		System.out.print("Precio en D�lares --> ");
		return Math.round(p.getPrecio()*0.96*100d)/100d;

	}

}