package com.example.ClubProject.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClubProject.models.Club;
import com.example.ClubProject.models.Players;
import com.example.ClubProject.services.ClubService;
import com.example.ClubProject.services.PlayerService;

@RestController
@RequestMapping("clubs")
public class ClubController {
	@Autowired
	private ClubService clubservice;

	@Autowired
	private PlayerService playerservice;

	@GetMapping()
	public List<Club> ClubList() {
		return clubservice.getClubs();
	}

	@GetMapping("{name}")
	public Club getClub(@PathVariable("name") String name) {
		return clubservice.getClub(name);
	}

	@GetMapping("{name}/players")
	public List<Players> getPlayers(@PathVariable("name") String name){
		return playerservice.getPlayers(name);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.OK)
	public void createClub(@RequestBody Club club) {
		clubservice.setClub(club);
	}

	@PutMapping("/{name}")
	public void update(@PathVariable("name") String name,@RequestBody Club club) {
		Club c = clubservice.getClub(name);
		c.setName(club.getName());
		c.setLeague(club.getLeague());
		clubservice.updateClub(c);
	}

	@DeleteMapping("{name}")
	public void delete(@PathVariable("name") String name) {
		clubservice.delete(name);
	}
	
}
