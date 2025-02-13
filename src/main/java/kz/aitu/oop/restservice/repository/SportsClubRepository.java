package kz.aitu.oop.restservice.repository;


import kz.aitu.oop.restservice.entity.SportsClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsClubRepository extends JpaRepository<SportsClub, Integer> {

}

