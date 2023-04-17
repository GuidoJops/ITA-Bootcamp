package ita.S05T02N02JanotaFuenteGuido.dados.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequest {

    private String name = "NoNamePlayer"; //Valor por defecto;

    @Email (message = "El nombre de usuario debe ser formato e-mail")
    @NotBlank (message = "El nombre de usuario no puede estar vacío")
    private String userName;

    @NotBlank (message = "La contraseña no puede estar vacía")
    private String password;


}
