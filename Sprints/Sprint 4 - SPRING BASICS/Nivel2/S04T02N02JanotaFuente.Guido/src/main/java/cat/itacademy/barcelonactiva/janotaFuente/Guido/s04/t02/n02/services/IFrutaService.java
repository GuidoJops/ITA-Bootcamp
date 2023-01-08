package cat.itacademy.barcelonactiva.janotaFuente.Guido.s04.t02.n02.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotaFuente.Guido.s04.t02.n02.domain.Fruta;


public interface IFrutaService {
	
	public List<Fruta> getAll();
	
	public Fruta getOne(int id);
	
	public boolean addFruta(Fruta fruta);
	
	public boolean deleteFruta(int id);
	
	public Fruta updateFruta(int id, Fruta fruta);
	


	

}
