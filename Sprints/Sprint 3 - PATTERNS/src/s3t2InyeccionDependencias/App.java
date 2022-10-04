package s3t2InyeccionDependencias;
/*
 Diseña una clase que muestre en pantalla el precio de varios artículos. Ya que tendrá que mostrarlos también en varios tipos de moneda.

IMPORTANTE

Asegúrate de añadirle como Inyección de Dependencia una clase Conversor de Moneda que efectúe la corrección del precio en función del cambio de divisa.
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
