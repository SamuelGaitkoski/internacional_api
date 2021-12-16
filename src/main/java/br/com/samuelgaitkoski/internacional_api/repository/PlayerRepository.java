package br.com.samuelgaitkoski.internacional_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samuelgaitkoski.internacional_api.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
    public Optional<Player> findByName(String name);
}
