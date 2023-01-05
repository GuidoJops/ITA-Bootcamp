package cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.janotafuente.guido.s04.t02.n01.model.domain.Fruta;

public interface IFrutaService {
	
	public List<Fruta> getAll();
	
	public Fruta getOne(int id);
	
	public boolean addFruta(Fruta fruta);
	
	public boolean deleteFruta(int id);
	
	public Fruta updateFruta(int id, Fruta fruta);
	

}
