package ita.S05T02N01JanotaFuenteGuido.dados.model.services;

import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthRequest;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.AuthResponse;
import ita.S05T02N01JanotaFuenteGuido.dados.model.dto.PlayerDto;

public interface IAuthService {
    PlayerDto registerUser(AuthRequest authRequest);
    AuthResponse loginUser(AuthRequest authRequest);
}
