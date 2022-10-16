package s3t3Floristeria;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	private Map<String, Integer> existencias;
	private double valorStock;

	
	public Stock() {
		existencias = new HashMap();
		existencias.put("ARBOL", 0);
		existencias.put("FLOR", 0);
		existencias.put("DECORACION", 0);
		
		valorStock = 0;
	}


	public Map<String, Integer> getExistencias() {
		return existencias;
	}


	public void setExistencias(Map<String, Integer> existencias) {
		this.existencias = existencias;
	}


	public double getValorStock() {
		return valorStock;
	}


//	public void setValorStock(double valorStock) {
//		this.valorStock = valorStock;
//	}
	

	
	public void modificaStock(Producto p, int cant, boolean agrega) {
		
		switch (p.getClass().getSimpleName()) {
		
			case "Arbol":
				int valor = existencias.get("ARBOL");
				if(agrega) {
					//AGREGA
					existencias.put("ARBOL", valor + cant);
				} else {
					//RETIRA
					existencias.put("ARBOL", valor - cant);
				}	
				System.out.println("Se ha modificado el Stock de ARBOL");
				actualizaValorStock(p,cant, agrega);
				break;
				
			case "Flor":
				break;
			
			case "Decoracion":
				break;
								
			default:
				System.out.println("Algo ha fallado, intenta otra vez");
		}
		
	}
	
	
	public void actualizaValorStock(Producto p, int cant, boolean agrega) {
		if (agrega) {
			valorStock += (p.getPrecio()*cant);	
		} else {
			valorStock -= (p.getPrecio()*cant);	
		}
			
	}
}
