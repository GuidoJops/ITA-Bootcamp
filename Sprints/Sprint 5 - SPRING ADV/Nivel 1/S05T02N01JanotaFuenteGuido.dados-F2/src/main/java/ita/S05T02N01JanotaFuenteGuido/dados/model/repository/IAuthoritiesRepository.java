package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;


import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Authority;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.AuthorityName;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthoritiesRepository extends  MongoRepository <Authority, String>{

    Optional<Authority> findByRole(AuthorityName role);
}
