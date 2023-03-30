package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String name;

    @Email (message = "El nombre de usuario debe ser formato e-mail")
    @NotBlank (message = "El nombre de usuario no puede estar vacío")
    private String userName;

    @NotBlank (message = "La contraseña no puede estar vacía")
    private String password;

    public AuthRequest () {
        name = "NoNamePlayer"; //Valor por defecto
  
    }

}
