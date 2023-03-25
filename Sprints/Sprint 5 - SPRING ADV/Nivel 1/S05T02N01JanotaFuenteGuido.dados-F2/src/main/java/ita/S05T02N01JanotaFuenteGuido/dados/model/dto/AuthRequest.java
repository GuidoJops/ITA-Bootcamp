package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String name;
    private String userName;
    private String password;

    public AuthRequest() {
        name = "NoNamePlayer";
    }
}
