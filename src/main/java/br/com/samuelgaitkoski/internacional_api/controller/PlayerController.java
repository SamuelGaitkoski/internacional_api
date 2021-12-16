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

import br.com.samuelgaitkoski.internacional_api.model.dto.PlayerDTO;
import br.com.samuelgaitkoski.internacional_api.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> findAll() {
        var listOfPlayers = playerService.findAll();
        return new ResponseEntity<>(listOfPlayers, HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<PlayerDTO> findByName(@PathVariable String name) {
        var result = playerService.findByName(name);

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new PlayerDTO(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> insert(@RequestBody PlayerDTO playerDTO) {
        if (playerDTO != null) {
            var result = playerService.insertOrUpdate(playerDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new PlayerDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new PlayerDTO(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<PlayerDTO> update(@RequestBody PlayerDTO playerDTO) {
        if (playerDTO != null) {
            var result = playerService.insertOrUpdate(playerDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new PlayerDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new PlayerDTO(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        var isSuccess = playerService.delete(id);
        
        if(isSuccess) {
            return new ResponseEntity<>("Player removido com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível remover o player informado", HttpStatus.NOT_FOUND);
    }

}
