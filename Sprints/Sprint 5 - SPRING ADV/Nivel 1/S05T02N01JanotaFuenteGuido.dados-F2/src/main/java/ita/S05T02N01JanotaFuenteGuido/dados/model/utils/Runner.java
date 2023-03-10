package ita.S05T02N01JanotaFuenteGuido.dados.model.utils;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IRoleRepository authRepo;

    @Override
    public void run(String... args) throws Exception {
        if(authRepo.count() == 0){
            authRepo.saveAll(List.of(
                    new Role(1L,ERole.ADMIN),
                    new Role(2L,ERole.USER)

            ));
        }

    }
}
