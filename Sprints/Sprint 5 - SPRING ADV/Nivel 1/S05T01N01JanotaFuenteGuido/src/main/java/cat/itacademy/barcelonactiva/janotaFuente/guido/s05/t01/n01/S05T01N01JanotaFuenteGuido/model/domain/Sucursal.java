package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table (name = "sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreSucursal;
	
	@ManyToOne
	@JoinColumn (name="pais_id")
	private Pais paisSucursal;
	
			
//	public Sucursal() {
//			
//	}
	
//	public Sucursal(String nombreSucursal, Pais paisSucursal) {
//		this.nombreSucursal = nombreSucursal;
//		this.paisSucursal = paisSucursal;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public Pais getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(Pais paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	
	
	
}
