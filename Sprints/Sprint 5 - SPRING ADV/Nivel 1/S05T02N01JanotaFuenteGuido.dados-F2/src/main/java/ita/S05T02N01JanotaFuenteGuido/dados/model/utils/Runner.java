package ita.S05T02N01JanotaFuenteGuido.dados.model.utils;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.ERole;
import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Role;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private IRoleRepository roleRepo;
    @Autowired
    private IPlayerRepository playerRepo;

//    @Autowired
//    private IUserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        if(roleRepo.count() == 0){
            roleRepo.saveAll(List.of(
                    new Role(1L,ERole.ROLE_ADMIN),
                    new Role(2L,ERole.ROLE_USER)

            ));
        }


//        User user =  new User("testuser", new BCryptPasswordEncoder().encode("321"));
//        user.getRoles().add(roleRepo.findByType(ERole.ROLE_USER).get());
//        userRepo.save(user);

//       Player player = playerRepo.findByUserName("Pulga").get();
//                player.getRoles().add(roleRepo.findByType(ERole.ROLE_USER).get());
//        playerRepo.save(player);
    }

}
