package ita.S05T02N01JanotaFuenteGuido.dados.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String userName;
    private String token;
}
