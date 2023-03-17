package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.UserDto;

public interface IAuthService {
    PlayerDto registerUser(UserDto userDto);

    String loginUser(UserDto userDto);
}
