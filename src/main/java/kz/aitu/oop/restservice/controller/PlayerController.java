package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.service.PlayerService;
import kz.aitu.oop.restservice.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working!");
    }


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }
}
