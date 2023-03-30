package ita.S05T02N01JanotaFuenteGuido.dados.security;

import ita.S05T02N01JanotaFuenteGuido.dados.model.domain.Player;
import ita.S05T02N01JanotaFuenteGuido.dados.model.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailService -> Administrador de credenciales de Usuario
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IPlayerRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player user = userRepo.findByUserName(username).orElseThrow(()->
                new UsernameNotFoundException("No se encontró un usuario con userName:" + username));

        return new CustomUserDetails(user);
    }


}
