package s3t3Floristeria;

import java.util.HashMap;

public class Stock {
	private HashMap<Producto, Integer> existencias;
	private double valorStock;

	
	public Stock() {
		existencias = new HashMap();
		valorStock = 0;
	}


	public HashMap<Producto, Integer> getExistencias() {
		return existencias;
	}


	public void setExistencias(HashMap<Producto, Integer> existencias) {
		this.existencias = existencias;
	}


	public double getValorStock() {
		return valorStock;
	}


	public void setValorStock(double valorStock) {
		this.valorStock = valorStock;
	}
}
