package br.com.samuelgaitkoski.internacional_api.util;

import br.com.samuelgaitkoski.internacional_api.model.Player;
import br.com.samuelgaitkoski.internacional_api.model.dto.PlayerDTO;

public class PlayerMapping {
    
    private PlayerMapping(){

    }

    public static PlayerDTO fromPlayer (Player player) {
        return new PlayerDTO(player.getId(), player.getName(), player.getPosition(), player.getAge(), 
        player.getWeight(), player.getBirthCity(), player.getBirthCountry(), player.getBirthYear());
    }

    public static Player toPlayer (PlayerDTO playerDTO) {
        return new Player(playerDTO.getId(), playerDTO.getName(), playerDTO.getPosition(), playerDTO.getAge(), 
        playerDTO.getWeight(), playerDTO.getBirthCity(), playerDTO.getBirthCountry(), playerDTO.getBirthYear());
    }

}
