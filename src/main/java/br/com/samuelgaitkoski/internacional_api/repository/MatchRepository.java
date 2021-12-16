package br.com.samuelgaitkoski.internacional_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samuelgaitkoski.internacional_api.model.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    
    public Optional<Match> findByName(String opponentTeam);
}
