package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String name;
    private String userName;
    private String password;

    public UserDto() {
        name = "NoNamePlayer";
    }
}
