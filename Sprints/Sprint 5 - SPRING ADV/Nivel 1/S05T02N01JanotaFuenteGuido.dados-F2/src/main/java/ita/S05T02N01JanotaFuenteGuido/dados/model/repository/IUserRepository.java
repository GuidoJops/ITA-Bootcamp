package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends  MongoRepository <User, String>{

    Optional<User> findByEmail(String email);

}
