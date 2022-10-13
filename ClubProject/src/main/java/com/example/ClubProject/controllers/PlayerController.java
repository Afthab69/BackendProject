package com.example.ClubProject.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.http.HttpStatus;

import com.example.ClubProject.Exceptions.NameNotFound;
import com.example.ClubProject.models.Club;
import com.example.ClubProject.models.Players;
import com.example.ClubProject.services.ClubService;
import com.example.ClubProject.services.PlayerService;

@RestController
@RequestMapping("players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerservice;

	@Autowired
	private ClubService clubservice;

	@GetMapping("")
	public List<Players> listPlayers() {
		return playerservice.getPlayers();
	}

	@GetMapping("{id}")
	public Players dispPlayer(@PathVariable("id") Long id) {
		return playerservice.getPlayer(id);
	}

	@PostMapping("add/{name}")
	@ResponseStatus(HttpStatus.OK)
	public void createPlayer(@RequestBody Players player, @PathVariable("name") String name) throws NameNotFound {
		Club club = clubservice.getClub(name);
		if (club!= null) {
			Players newplayer  = new Players();
			newplayer.setName(player.getName());
			newplayer.setPos(player.getPos());
			newplayer.setJno(player.getJno());
			newplayer.setClub(club);
			playerservice.setPlayer(newplayer);
		} else {
			throw new NameNotFound();
		}

	}

	@PutMapping("update/{id}")
	public void update(@PathVariable("id") Long id, @Valid @RequestBody Players player) {
		playerservice.updatePlayers(id,player);
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		playerservice.delete(id);
	}
}
