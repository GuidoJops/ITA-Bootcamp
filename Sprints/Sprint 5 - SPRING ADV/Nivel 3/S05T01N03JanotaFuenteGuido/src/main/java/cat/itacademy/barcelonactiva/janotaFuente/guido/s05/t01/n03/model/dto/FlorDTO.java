package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

public class FlorDTO {

	@ApiModelProperty(notes = "Flor ID", example = "1", required = false, hidden = true)
	private Long id;
	
	@ApiModelProperty(notes = "Nombre de la Flor", example = "Margarita", required = true)
	@NotNull(message="El nombre de la Flor no puede estar vacio")
	private String nombreFlor;

	@ApiModelProperty(notes = "Pais de la Flor", example = "Brasil", required = true)
	@NotNull
	private String paisFlor;
	
	@ApiModelProperty(notes = "Localizacion de la Flor", example = "UE", required = false, hidden = true)
	private String tipoFlor;
	

	
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
	public String getTipoFlor() {
		return tipoFlor;
	}
	public void setTipoFlor(String tipoFlor) {
		this.tipoFlor = tipoFlor;
	}
	
	
	public String defindeTipoFlor(String nombrePais) { 
		String tipo="Fuera UE";
		
		if(PaisesUe.buscaPaisUe(nombrePais)) {
			tipo= "UE";
		}
		return tipo;
	}
		
}
