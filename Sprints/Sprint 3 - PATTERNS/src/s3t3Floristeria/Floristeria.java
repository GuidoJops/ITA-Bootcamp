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

	public List<Ticket> getCompras() {
		return compras;
	}

	public void setCompras(List<Ticket> compras) {
		this.compras = compras;
	}


	
}
