package s3t3Floristeria;

import java.util.List;

public class Ticket {
	private static int count = 0;
	private final int ID;
	private Cliente cliente;
	private List<Producto> compra;
	private double totalCompra;
	
	
	public Ticket (Cliente cliente, List<Producto> compra) {
		ID = ++count;
		this.cliente = cliente;
		this.compra = compra;
		totalCompra = compra.stream().mapToDouble(Producto::getPrecio).sum();
			
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Producto> getCompra() {
		return compra;
	}

	public void setCompra(List<Producto> compra) {
		this.compra = compra;
	}

	public double getTotalCompra() {
		return totalCompra;
	}

	public int getID() {
		return ID;
	}
	
	
	
	
	
}
