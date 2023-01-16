package cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s04.t02.n03.domain.Fruta;



public interface IFrutaService {
	
	public List<Fruta> getAll();
	
	public Fruta getOne(String id);
	
	public boolean addFruta(Fruta fruta);
	
	public boolean deleteFruta(String id);
	
	public Fruta updateFruta(String id, Fruta fruta);
	


	

}
