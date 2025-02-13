package kz.aitu.oop.restservice.service;

import org.springframework.stereotype.Service;
import java.util.List;
import kz.aitu.oop.restservice.entity.Player;
import kz.aitu.oop.restservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
}
