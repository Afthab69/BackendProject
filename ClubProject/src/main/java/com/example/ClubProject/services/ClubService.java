package com.example.ClubProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClubProject.models.Club;
import com.example.ClubProject.repositories.ClubRepository;

@Service
public class ClubService {
	@Autowired
	private ClubRepository clubrepository;

	public Club getClub(String name) {
		return clubrepository.findById(name).orElse(null);
	}

	public void setClub(Club club) {
		clubrepository.save(club);
	}

	public List<Club> getClubs() {
		List<Club> club = clubrepository.findAll();
		return club;
	}

	public void updateClub(Club club) {
		clubrepository.save(club);

	}
	
	public void delete(String name) {
		clubrepository.deleteById(name);
	}
}
