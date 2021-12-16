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

import br.com.samuelgaitkoski.internacional_api.model.dto.CoachDTO;
import br.com.samuelgaitkoski.internacional_api.service.CoachService;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    
    @Autowired
    private CoachService coachService;

    @GetMapping
    public ResponseEntity<List<CoachDTO>> findAll() {
        var listOfCoaches = coachService.findAll();
        return new ResponseEntity<>(listOfCoaches, HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<CoachDTO> findByName(@PathVariable String name) {
        var result = coachService.findByName(name);

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CoachDTO(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CoachDTO> insert(@RequestBody CoachDTO coachDTO) {
        if (coachDTO != null) {
            var result = coachService.insertOrUpdate(coachDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CoachDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CoachDTO(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<CoachDTO> update(@RequestBody CoachDTO coachDTO) {
        if (coachDTO != null) {
            var result = coachService.insertOrUpdate(coachDTO);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(new CoachDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CoachDTO(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        var isSuccess = coachService.delete(id);
        
        if(isSuccess) {
            return new ResponseEntity<>("Coach removido com sucesso!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Não foi possível remover o coach informado", HttpStatus.NOT_FOUND);
    }
    
}
