package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "flor")
public class Flor {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombreFlor;

	@NotNull
	private String paisFlor;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreFlor() {
		return nombreFlor;
	}

	public void setNombreFlor(String nombreFlor) {
		this.nombreFlor = nombreFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

	


	
	
	
}
