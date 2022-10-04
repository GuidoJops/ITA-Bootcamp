package s3t2InyeccionDependencias;
/*
Dissenya una classe que mostri en pantalla el preu de diversos articles. Ja que haurà de mostrar-los també en diversos tipus de moneda.

IMPORTANTE

Assegura't d'afegir-li com a Injecció de Dependència una classe Convertidor de Moneda que efectuï la correcció del preu en funció del canvi de divisa.
*/

public class App {

	public static void main(String[] args) {

		
		Producto p1 = new Producto("TELEFONO",140);
		Producto p2 = new Producto("TABLET",230);
		Producto p3 = new Producto("NEVERA",345);
		
		System.out.println(p1);
		Producto.cambiaMoneda(new PrecioDolar(),p1);
		Producto.cambiaMoneda(new PrecioBitcoin(),p1);
		Producto.cambiaMoneda(new PrecioPesosArg(),p1);
		System.out.println("---\n");
		
		System.out.println(p2);
		Producto.cambiaMoneda(new PrecioDolar(),p2);
		Producto.cambiaMoneda(new PrecioBitcoin(),p2);
		Producto.cambiaMoneda(new PrecioPesosArg(),p2);
		System.out.println("---\n");
		
		System.out.println(p3);
		Producto.cambiaMoneda(new PrecioDolar(),p3);
		Producto.cambiaMoneda(new PrecioBitcoin(),p3);
		Producto.cambiaMoneda(new PrecioPesosArg(),p3);
		System.out.println("---\n");
	
	}

}
