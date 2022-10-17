package s3t3Floristeria;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Stock implements Serializable {
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
	

	
	public void modificaStock(String nombreFloristeria, Producto p, int cant, boolean agrega) {
		
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
				escribeFichero(nombreFloristeria, existencias);
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
	
	public void escribeFichero(String nombreFloristeria, Map<String, Integer> existencias) {
		
		//ITERAR MAP PARA ESCRIBIR ARCHIVO
		String ruta = "src/s3t3Floristeria/bd/Stock-" + nombreFloristeria.toLowerCase() + ".txt";
		byte data[] = str.getBytes();
		Path p = Paths.get(ruta);

	try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE))) {
			out.write(data, 0, data.length);
		} catch (IOException e) {
			System.out.println("Ups..Algo ha fallado al intentar escribir el fichero.");
		}
	}
}
