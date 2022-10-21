package s3t3Floristeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	public void agregaProducto(Producto p) {
		productos.add(p);
		stock.modificaStock2(this);
	}
	
	public void retiraProducto(String eliminar) {
		boolean bucle = true;
		int indexProducto;

		
		while(bucle){
			indexProducto = compruebaExistencia(eliminar);
			if (indexProducto == -1) {
				System.out.println("El nombre ingresado no coincide con ningún producto");
			}else {
				Producto producto = productos.get(indexProducto);
				productos.remove(indexProducto);
				stock.modificaStock2(this);
				bucle = false;
			}

		}
	}
		
	public void listaProductos() {
		if (productos.size()>0) {
			System.out.println("\n---------------------------------------------------");
			System.out.println("Productos disponibles en Floristeria " + nombre.toUpperCase());
			System.out.println("----------------------------------------------------");
			
			productos.stream().forEach(x-> System.out.println(x.getInfo()));
			
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
	
	public void listaClientes() {
		Set<Cliente> clientes = new HashSet();
		if (ventas.size()>0) {
			System.out.println("\n-----------------------------------------");
			System.out.println("Clientes de Floristeria " + nombre.toUpperCase());
			System.out.println("-----------------------------------------\n");

			for (Ticket item : ventas) {
				clientes.add(item.getCliente());
			}
			clientes.stream().forEach(System.out::println);
			
		} else {
			System.out.println("Actualmente no hay Clientes en el sistema");
		}		
	}
	
	public int buscaCliente(String  dni) {
		boolean encontrada = false;
		int contador = 0, index = -1;
		
		while (contador < ventas.size() && !encontrada) {
			if (ventas.get(contador).getCliente().getDni().equalsIgnoreCase(dni)){
				index = contador;
				encontrada = true;
			}
			contador ++;
		}	
		return index;
	}

	public void actualizaVentas(Ticket t) {
		ventas.add(t);
	}
	
	public void listaVentas() {
		System.out.println("\n-----------------------------------------");
		System.out.println("Compras registradas en Floristeria " + nombre.toUpperCase());
		System.out.println("-----------------------------------------");
		
		if(ventas.size() > 0) {
			ventas.stream().forEach(x->System.out.println(x.toString()));
		} else {
			System.out.println("Actualmente no hay ventas registradas");
		}

	}

	public double calculaGanancia() {
		return ventas.stream().mapToDouble(Ticket::getTotalCompra).sum();
	}
	
	public void listaCantidadesStock() {
		listaProductos();
		stock.listaCantidades();
	}

	public void valorStock() {
		System.out.println("---------------------------------------");
		System.out.println("Valor de Stock de Floristeria " + nombre);
		System.out.println("---------------------------------------");
		System.out.println(stock.calculaValorDeStock(this) + "€");
	}
}
