package br.com.samuelgaitkoski.internacional_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.samuelgaitkoski.internacional_api.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer> {
    
    public Optional<Coach> findByName(String name);
}
