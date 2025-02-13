package kz.aitu.oop.restservice.repository;

import kz.aitu.oop.restservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByNameIgnoreCase(String name);
    List<Player> findByPositionIgnoreCase(String position);
}