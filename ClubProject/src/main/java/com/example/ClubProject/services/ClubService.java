package com.example.ClubProject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClubProject.Dto.ClubDto;
import com.example.ClubProject.models.Club;
import com.example.ClubProject.repositories.ClubRepository;

@Service
public class ClubService {
	@Autowired
	private ClubRepository clubrepository;

	
	public Club getClub(String name) {
		Club club = clubrepository.findById(name).orElse(null);
//		ClubDto clubDto = new ClubDto();
//		clubDto.setName(club.getName());
//		clubDto.setLeague(club.getLeague());
		return club;
	}

	public void setClub(Club club) {
		clubrepository.save(club);
	}

	public List<ClubDto> getClubs() {
		List<Club> club = clubrepository.findAll();
		List<ClubDto> clubDto = new ArrayList();
		club.forEach((clubs)->{
			clubDto.add(toDto(clubs));
		});
		return clubDto;
	}

	private ClubDto toDto(Club club) {
		ClubDto clubDto = new ClubDto();
		clubDto.setName(club.getName());
		clubDto.setLeague(club.getLeague());
		return clubDto;
	}

	public void updateClub(Club club) {
		clubrepository.save(club);

	}
	
	public void delete(String name) {
		clubrepository.deleteById(name);
	}
}
