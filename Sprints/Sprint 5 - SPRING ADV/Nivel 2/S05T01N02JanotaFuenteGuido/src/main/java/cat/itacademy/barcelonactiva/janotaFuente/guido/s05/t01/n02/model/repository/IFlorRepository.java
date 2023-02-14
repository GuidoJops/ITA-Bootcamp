package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n02.model.domain.Flor;

@Repository
public interface IFlorRepository extends JpaRepository<Flor, Long>{

	public Flor findBynombreFlor(String nombre);
}
