package kz.aitu.oop.restservice.controller;

import kz.aitu.oop.restservice.entity.SportsClub;
import kz.aitu.oop.restservice.service.SportsClubService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clubs")
public class SportsClubController {
    @Autowired
    private SportsClubService sportsClubService;

    @GetMapping
    public List<SportsClub> getAllClubs() {
        return sportsClubService.getAllClubs();
    }

    @PostMapping
    public SportsClub addClub(@RequestBody SportsClub club) {
        return sportsClubService.addClub(club);
    }
}