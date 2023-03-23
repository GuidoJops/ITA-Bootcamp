package ita.S05T02N01JanotaFuenteGuido.dados.utils;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    private IRoleRepository roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IPlayerRepository playerRepo;

    @Override
    public void run(String... args) throws Exception {

/*
* --Se agregan los Roles y un Usario Admin la primera vez que se ejecuta el programa--
*/
        if(roleRepo.count() == 0){
            roleRepo.saveAll(List.of(
                    new Role(1L,ERole.ROLE_ADMIN),
                    new Role(2L,ERole.ROLE_USER)

            ));
            log.info("Roles USER y ADMIN creados.");
        }

        if (playerRepo.count() == 0) {

            Player adminPlayer = new Player();
            adminPlayer.setName("DEFAULT-ADMIN");
            adminPlayer.setUserName("admin");
            adminPlayer.setPassword(passwordEncoder.encode("admin"));
            adminPlayer.setRoles(roleRepo.findAll());
            playerRepo.save(adminPlayer);
            log.info("Usuario 'admin' creado.");
        }


    }

}
