package s3t2InyeccionDependencias;
/*
 Dise�a una clase que muestre en pantalla el precio de varios art�culos. Ya que tendr� que mostrarlos tambi�n en varios tipos de moneda.

IMPORTANTE

Aseg�rate de a�adirle como Inyecci�n de Dependencia una clase Conversor de Moneda que efect�e la correcci�n del precio en funci�n del cambio de divisa.
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
