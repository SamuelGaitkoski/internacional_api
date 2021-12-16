package br.com.samuelgaitkoski.internacional_api.util;

import br.com.samuelgaitkoski.internacional_api.model.Coach;
import br.com.samuelgaitkoski.internacional_api.model.dto.CoachDTO;

public class CoachMapping {
    
    private CoachMapping() {

    }

    public static CoachDTO fromCoach(Coach coach) {
        return new CoachDTO(coach.getId(), coach.getName(), coach.getNickname(), coach.getAge(), 
        coach.getHeight(), coach.getBirthCity(), coach.getBirthCountry());
    }

    public static Coach toCoach(CoachDTO coachDTO) {
        return new Coach(coachDTO.getId(), coachDTO.getName(), coachDTO.getNickname(), coachDTO.getAge(),
        coachDTO.getHeight(), coachDTO.getBirthCity(), coachDTO.getBirthCountry());
    }
    
}
