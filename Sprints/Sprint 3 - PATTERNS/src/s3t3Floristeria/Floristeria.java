package s3t3Floristeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Floristeria implements Serializable {
	private String nombre;
	private List<Producto> productos;
	private Stock stock;
	private List<Ticket> ventas;
	
	
	public Floristeria(String nombre){
		this.nombre = nombre;
		productos = new ArrayList();
		stock = new Stock();
		ventas = new ArrayList();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Ticket> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ticket> ventas) {
		this.ventas = ventas;
	}

	public void agregaProducto(Producto p, boolean agrega) {
		productos.add(p);
//		stock.modificaStock(nombre, p, cant, agrega);
		stock.modificaStock2(this);
	}
	
	public void retiraProducto() {
		boolean bucle = true;
		int indexProducto;
		System.out.println("\n-----------------------------------------");
		System.out.println("Productos disponibles en Floristeria " + getNombre().toUpperCase());
		System.out.println("-----------------------------------------\n");
		listaProductos();
		
		while(bucle){
			String eliminar = App.ingresaStr("\nDime el nombre del producto que quieres eliminar...");
			indexProducto = compruebaExistencia(eliminar);
			if (indexProducto == -1) {
				System.out.println("El nombre ingresado no coincide con ningún producto");
			}else {
				Producto producto = productos.get(indexProducto);
				productos.remove(indexProducto);
				stock.modificaStock2(this);
//				stock.modificaStock(nombre, producto, 1, false);
				bucle = false;
				System.out.println(producto.getClass().getSimpleName()+ " "+ producto.getNombre()+ " eliminado");
				
			}

		}
	}
		
	public void listaProductos() {
		if (productos.size()>0) {
			getProductos().stream().forEach(x-> System.out.println(x.getInfo()));
		} else {
			System.out.println("Actualmente no hay productos en el sistema");
		}		
	}
	
	public int compruebaExistencia(String nombre) {
		boolean existe = false;
		int contador= 0, indexProducto=-1;
		
		while (contador < productos.size() && !existe) {
			if (productos.get(contador).getNombre().equalsIgnoreCase(nombre)){
				indexProducto = contador;
				existe = true;
			}
			contador ++;
		}	
		return indexProducto;
	}
	
	public void agregaCompra(Ticket co) {
		ventas.add(co);
	}
	
}
