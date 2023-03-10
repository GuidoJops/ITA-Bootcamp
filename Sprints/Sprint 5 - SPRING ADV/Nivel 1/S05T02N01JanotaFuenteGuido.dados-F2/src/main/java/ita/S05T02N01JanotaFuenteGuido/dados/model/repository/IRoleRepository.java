package ita.S05T02N01JanotaFuenteGuido.dados.model.repository;


import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends  MongoRepository <Role, Long>{

    Optional<Role> findByRoleType(ERole role);
}
