package ita.S05T02N01JanotaFuenteGuido.dados.model.dto;

public class AuthResponseDto {

    private String accesToken;
    private String tokenType = "Bearer";

    public AuthResponseDto(String accesToken){
        this.accesToken = accesToken;
    }
}
