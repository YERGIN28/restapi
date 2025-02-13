package kz.aitu.oop.restservice.service;



import kz.aitu.oop.restservice.entity.SportsClub;
import kz.aitu.oop.restservice.repository.SportsClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SportsClubService {
    @Autowired
    private SportsClubRepository sportsClubRepository;

    public List<SportsClub> getAllClubs() {
        return sportsClubRepository.findAll();
    }

    public SportsClub addClub(SportsClub club) {
        return sportsClubRepository.save(club);
    }
}