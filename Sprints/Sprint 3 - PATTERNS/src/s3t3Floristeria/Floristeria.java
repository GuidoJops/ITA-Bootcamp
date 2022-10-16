package s3t3Floristeria;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {
	private String nombre;
	private List<Producto> productos;
	private Stock stock;
	private List<Ticket> compras;
	private List<Cliente> clientes;
	
	
	public Floristeria(String nombre){
		this.nombre = nombre;
		productos = new ArrayList();
		stock = new Stock();
		compras = new ArrayList();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private List<Producto> getProductos() {
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

	public List<Ticket> getCompras() {
		return compras;
	}

	public void setCompras(List<Ticket> compras) {
		this.compras = compras;
	}

	public void agregaRetiraProducto(Producto p, int cant, boolean agrega) {
		int indexProducto = compruebaExistencia (p);
		
		if (indexProducto >= 0 && !agrega) {
			// RETIRA
			productos.remove(indexProducto);
			stock.modificaStock(p, cant, agrega);

		}else if (agrega) {
			//AGREGA
			productos.add(p);
			stock.modificaStock(p, cant, agrega);

		} else {
			System.out.println("No es posible eliminar un producto que no existe en la Base de datos");		}
		

	}
	
	
	public void listaProductos() {
		if (productos.size()>0) {
			getProductos().stream().forEach(x-> System.out.println(x.getInfo()));
		} else {
			System.out.println("Actualmente no hay productos en el sistema");
		}		
	}
	
	public int compruebaExistencia(Producto p) {
		boolean existe = false;
		int contador= 0, indexProducto=-1;
		
		while (contador < productos.size() && !existe) {
			if (productos.get(contador).getNombre().equalsIgnoreCase(p.getNombre())){
				indexProducto = contador;
				existe = true;
			}
			contador ++;
		}	
		return indexProducto;
	}
	
}
