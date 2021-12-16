package br.com.samuelgaitkoski.internacional_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samuelgaitkoski.internacional_api.model.dto.MatchDTO;
import br.com.samuelgaitkoski.internacional_api.repository.MatchRepository;
import br.com.samuelgaitkoski.internacional_api.util.MatchMapping;

@Service
public class MatchService {
    
    @Autowired
    private MatchRepository matchRepository;

    public MatchDTO insertOrUpdate(MatchDTO matchDTO) {
        var result = matchRepository.save(MatchMapping.toMatch(matchDTO));
        return MatchMapping.fromMatch(result);
    }

    public List<MatchDTO> findAll() {
        return matchRepository.findAll().stream().map(match -> MatchMapping.fromMatch(match)).
        collect(Collectors.toList());
    }

    public MatchDTO findByName(String opponentTeam) {
        var result = matchRepository.findByName(opponentTeam);

        if(result.isPresent()) { 
            return MatchMapping.fromMatch(result.get());
        }
        return new MatchDTO();
    }

    public boolean delete (int id) {
        var result = matchRepository.findById(id);

        if(result.isPresent()) {
            matchRepository.deleteById(id);
            result = matchRepository.findById(id);
            return result.isEmpty();
        } else {
            return false;
        }
    }
    
}
