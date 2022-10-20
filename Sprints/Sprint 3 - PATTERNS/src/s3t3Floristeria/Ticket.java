package s3t3Floristeria;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {
	private Cliente cliente;
	private List<Producto> compra;
	private double totalCompra;
	
	
	public Ticket (Cliente cliente, List<Producto> compra) {
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
	
	public String listaCompra() {
		String res="";
		for (Producto p : compra) {
			res += p.getInfo() + "\n";
		}
		return res;
	}

//	@Override
//	public String toString() {
//		
//		return "----------------\n"
//				+ cliente.toString()
//				+ compra.stream().forEach(x-> x.getInfo())
//				+ "\nTotal venta: " + totalCompra;
//				
//	}
	
	@Override
	public String toString() {
		
		return "----------------------------\n"
				+ cliente.toString()
				+"\n\n--Productos--\n"
				+listaCompra()
				+"--------------\n"
				+ "TOTAL DE COMPRA: " + totalCompra
				+"\n----------------------------\n";
				
				
	}
}
