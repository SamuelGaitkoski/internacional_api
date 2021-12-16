package br.com.samuelgaitkoski.internacional_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public Map<String, Map<String, String>> home() {
        var map = new HashMap<String, Map<String, String>>();
        var mapPlayers = new HashMap<String, String>();
        mapPlayers.put("listar todos", "/players");
        mapPlayers.put("Buscar por nome", "/players/name");
        mapPlayers.put("Adicionar", "/players");
        mapPlayers.put("Editar", "/players");
        mapPlayers.put("Remover", "/players");
        map.put("players", mapPlayers);

        var mapCoaches = new HashMap<String, String>();
        mapCoaches.put("listar todos", "/coaches");
        mapPlayers.put("Buscar por nome", "/coaches/name");
        mapCoaches.put("Adicionar", "/coaches");
        mapCoaches.put("Editar", "/coaches");
        mapCoaches.put("Remover", "/coaches");
        map.put("coaches", mapCoaches);

        var mapMatches = new HashMap<String, String>();
        mapMatches.put("listar todos", "/matches");
        mapMatches.put("Buscar por nome", "/matches/name");
        mapMatches.put("Adicionar", "/matches");
        mapMatches.put("Editar", "/matches");
        mapMatches.put("Remover", "/matches");
        map.put("matches", mapMatches);

        return map;
    }

}
