package s1t2;
//
import java.util.ArrayList;

public class Venta {
	static private ArrayList <Producto> listaProductos;
	static private int precioTotalVentas;
	
	static {
		listaProductos = new ArrayList<Producto>();
		precioTotalVentas = 0;
	}
	
	public static ArrayList<Producto> getListaProdcutos() {
		return listaProductos;
	}
	
	public static void calculaTotal() throws VentaVaciaException {
		int acum=0;
		
		if (listaProductos.size()!=0) {
			
			for (int i=0; i<listaProductos.size(); i++) {
				acum +=listaProductos.get(i).getPrecio();
			}
			precioTotalVentas = acum;
			System.out.println("El precio total de Ventas es: " + precioTotalVentas+"€");
			
		} else {
			throw new VentaVaciaException("Para hacer una venta primero debes añadir productos");
		}
		
		
	}
	
	public static void  agregarProducto(String nombre, int precio) {
		Producto p = new Producto (nombre, precio);
		listaProductos.add(p);
		System.out.println("Producto "+ p.getNombre().toUpperCase() +" agregado correctamente.");
		
	}
	
	public static void verProductos() {
		if(listaProductos.size()!=0) {
			for(int i=0; i<listaProductos.size(); i++) {
				System.out.println(listaProductos.get(i).getNombre().toUpperCase()+ "---> "+ listaProductos.get(i).getPrecio()+"€");			
			}
			
		} else {
			System.out.println("No hay ningún producto en la lista");
		}
		
	}
	
//Si se ingresa una posición mayor al tamaño de la lista salta la Excepcion
	public static void lugarEnLaLista(int pos) throws ArrayIndexOutOfBoundsException{
		if (listaProductos.size()!=0) {
			System.out.println("El Producto que se encuentra en esa posición es: " +listaProductos.get(pos).getNombre());
			
		} else {
			throw new ArrayIndexOutOfBoundsException("No hay ningún elemento en esa posición de la lista");
		}
	}

	
}
