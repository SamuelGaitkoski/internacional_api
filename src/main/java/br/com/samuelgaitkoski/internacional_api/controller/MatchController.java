package br.com.samuelgaitkoski.internacional_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuelgaitkoski.internacional_api.model.dto.MatchDTO;
import br.com.samuelgaitkoski.internacional_api.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {
    
    @Autowired
    private MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> findAll() {
        var listOfMatches = matchService.findAll();
        return new ResponseEntity<>(listOfMatches, HttpStatus.OK);
    }
    
    @GetMapping("/name/{opponentTeam}")
    public ResponseEntity<MatchDTO> findByName(@PathVariable String opponentTeam) {
        var result = matchService.findByName(opponentTeam);

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MatchDTO(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MatchDTO> insert(@RequestBody MatchDTO matchDTO) {
        if (matchDTO != null) {
            var result = matchService.insertOrUpdate(matchDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new MatchDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new MatchDTO(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<MatchDTO> update(@RequestBody MatchDTO matchDTO) {
        if (matchDTO != null) {
            var result = matchService.insertOrUpdate(matchDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new MatchDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new MatchDTO(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        var isSuccess = matchService.delete(id);
        
        if(isSuccess) {
            return new ResponseEntity<>("Match removida com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível remover a match informada", HttpStatus.NOT_FOUND);
    }
    
}
