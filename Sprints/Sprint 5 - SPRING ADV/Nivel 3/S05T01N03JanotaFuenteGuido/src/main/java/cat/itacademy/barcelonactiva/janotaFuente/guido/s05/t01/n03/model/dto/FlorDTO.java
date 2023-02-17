package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.model.dto;


public class FlorDTO {

	
	private Long id;
	
	
	private String nombreFlor;


	private String paisFlor;
	
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
