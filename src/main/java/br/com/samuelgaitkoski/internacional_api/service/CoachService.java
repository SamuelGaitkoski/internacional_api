package br.com.samuelgaitkoski.internacional_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samuelgaitkoski.internacional_api.model.dto.CoachDTO;
import br.com.samuelgaitkoski.internacional_api.repository.CoachRepository;
import br.com.samuelgaitkoski.internacional_api.util.CoachMapping;

@Service
public class CoachService {
    
    @Autowired
    private CoachRepository coachRepository;

    public CoachDTO insertOrUpdate(CoachDTO coachDTO) {
        var result = coachRepository.save(CoachMapping.toCoach(coachDTO));
        return CoachMapping.fromCoach(result);
    }

    public List<CoachDTO> findAll() {
        return coachRepository.findAll().stream().map(coach -> CoachMapping.fromCoach(coach)).
        collect(Collectors.toList());
    }

    public CoachDTO findByName(String name) {
        var result = coachRepository.findByName(name);

        if(result.isPresent()) { 
            return CoachMapping.fromCoach(result.get());
        }
        return new CoachDTO();
    }

    public boolean delete (int id) {
        var result = coachRepository.findById(id);

        if(result.isPresent()) {
            coachRepository.deleteById(id);
            result = coachRepository.findById(id);
            return result.isEmpty();
        } else {
            return false;
        }
    }

}
