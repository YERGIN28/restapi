package kz.aitu.oop.restservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String position;

    @ManyToOne
    @JoinColumn(name = "sports_club_id")
    private SportsClub sportsClub;

    public Player() {

    }

    public Player(String name, int age, String position, SportsClub sportsClub) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.sportsClub = sportsClub;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public SportsClub getSportsClub() { return sportsClub; }
    public void setSportsClub(SportsClub sportsClub) { this.sportsClub = sportsClub; }
}
