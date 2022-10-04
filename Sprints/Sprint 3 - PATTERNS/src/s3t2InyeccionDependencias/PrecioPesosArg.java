package s3t2InyeccionDependencias;

public class PrecioPesosArg implements IMoneda {

	@Override
	public double convierteMoneda(Producto p) {
		System.out.print("Precio en Pesos Argentinos --> ");
		return Math.round(p.getPrecio()*146.46*100d)/100d;

	}

}