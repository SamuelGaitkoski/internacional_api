package br.com.samuelgaitkoski.internacional_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samuelgaitkoski.internacional_api.model.dto.PlayerDTO;
import br.com.samuelgaitkoski.internacional_api.repository.PlayerRepository;
import br.com.samuelgaitkoski.internacional_api.util.PlayerMapping;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerDTO insertOrUpdate(PlayerDTO playerDTO) {
        var result = playerRepository.save(PlayerMapping.toPlayer(playerDTO));
        return PlayerMapping.fromPlayer(result);
    }

    public List<PlayerDTO> findAll() {
        return playerRepository.findAll().stream().map(player -> PlayerMapping.fromPlayer(player)).
        collect(Collectors.toList());
    }

    public PlayerDTO findByName(String name) {
        var result = playerRepository.findByName(name);

        if(result.isPresent()) { 
            return PlayerMapping.fromPlayer(result.get());
        }
        return new PlayerDTO();
    }

    public boolean delete (int id) {
        var result = playerRepository.findById(id);

        if(result.isPresent()) {
            playerRepository.deleteById(id);
            result = playerRepository.findById(id);
            return result.isEmpty();
        } else {
            return false;
        }
    }
    
}
