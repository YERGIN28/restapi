package kz.aitu.oop.restservice.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sports_clubs")
public class SportsClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "sportsClub", cascade = CascadeType.ALL)
    private List<Player> players;

    public List<Player> getPlayers() { return players; }
    public void setPlayers(List<Player> players) { this.players = players; }


    public SportsClub() {}

    public SportsClub(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
