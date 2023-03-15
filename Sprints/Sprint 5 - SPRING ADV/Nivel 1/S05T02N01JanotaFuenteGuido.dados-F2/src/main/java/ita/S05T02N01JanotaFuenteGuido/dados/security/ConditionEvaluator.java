package ita.S05T02N01JanotaFuenteGuido.dados.security;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ConditionEvaluator {

    @Autowired
    private IPlayerService playerService;

    public boolean canPreAuth(String id, Authentication authentication) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // NO ENTIENDO ESTO CHEQUEAR
        return playerService.findPlayerById(id)
                .getName().equals(authentication.getName())
                || authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    }

    public boolean canPreAuth2(PlayerDto playerDto, Authentication authentication) {
        return playerService.changePlayerName(playerDto)
                .getName().equals(authentication.getName())
                || authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    }
}
