package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.dto;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n01.S05T01N01JanotaFuenteGuido.model.domain.Pais;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SucursalDto {
	
	private Long id;
	
	@NotEmpty(message="El nombre de la Sucurasl no puede estar vacio")
	@NotNull
	private String nombreSucursal;
	
	private Pais paisSucursal;
	private String tipoSucursal;
	private String[] listaPaisesUe= {"Alemania","Austria","Bélgica","Bulgaria","Chipre",
									 "Croacia","Dinamarca","España","Eslovaquia","Eslovenia",
									 "Estonia","Finlandia","Francia","Grecia","Hungría",
									 "Irlanda","Italia","Letonia","Lituania","Luxemburgo",
									 "Malta","Países Bajos","Polonia","Portugal",
									 "República Checa","Rumania","Suecia"};
	
	
	
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
	public String getTipoSucursal() {
		return tipoSucursal;
	}
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	public String[] getListaPaisesUe() {
		return listaPaisesUe;
	}

	public void setListaPaisesUe(String[] listaPaisesUe) {
		this.listaPaisesUe = listaPaisesUe;
	}

	
	
	public String defindeTipoSucursal(String nombrePais) { 
		String tipo="Fuera UE";
		
		for (String pais : listaPaisesUe) {
			if(pais.equalsIgnoreCase(nombrePais)) {
				tipo ="UE";
				
			}
			
		}
		return tipo;
		 
	}

}
