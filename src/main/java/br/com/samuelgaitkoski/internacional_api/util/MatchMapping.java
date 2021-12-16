package br.com.samuelgaitkoski.internacional_api.util;

import br.com.samuelgaitkoski.internacional_api.model.Match;
import br.com.samuelgaitkoski.internacional_api.model.dto.MatchDTO;

public class MatchMapping {
    
    private MatchMapping() {

    }

    public static MatchDTO fromMatch (Match match) {
        return new MatchDTO(match.getId(), match.getOpponentTeam(), match.getStadium(), match.getWinner(),
        match.getScoreboard(), match.getChampionship());
    }

    public static Match toMatch (MatchDTO matchDTO) {
        return new Match(matchDTO.getId(), matchDTO.getOpponentTeam(), matchDTO.getStadium(), matchDTO.getWinner(),
        matchDTO.getScoreboard(), matchDTO.getChampionship());
    }
    
}
