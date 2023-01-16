package cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "frutas")
public class Fruta {
	

	@Id 
	private String id;
	private String nombre;
	private int cantidadQuilos;
	
	
	public Fruta () {
		
	}
	
	public Fruta( String nombre, int cantidadQuilos) {
		this.nombre = nombre;
		this.cantidadQuilos = cantidadQuilos;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidadQuilos() {
		return cantidadQuilos;
	}
	public void setCantidadQuilos(int cantidadQuilos) {
		this.cantidadQuilos = cantidadQuilos;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"nombre\":\"" + nombre + "\", \"cantidadQuilos\":\"" + cantidadQuilos + "\"}";
	}
	
}
