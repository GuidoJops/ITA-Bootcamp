package ita.S05T02N01JanotaFuenteGuido.dados.model.utils;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Authority;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.AuthorityName;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IAuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IAuthoritiesRepository authRepo;

    @Override
    public void run(String... args) throws Exception {
        if(authRepo.count() == 0){
            authRepo.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }

    }
}
