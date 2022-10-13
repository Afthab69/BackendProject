package com.example.ClubProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClubProject.models.Club;
import com.example.ClubProject.models.Players;
import com.example.ClubProject.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerrepository;

	public Players getPlayer(Long id) {
		return playerrepository.findById(id).orElse(null);
	}

	public void setPlayer(Players player) {
		playerrepository.save(player);
	}

	public List<Players> getPlayers() {
		List<Players> players = playerrepository.findAll();
		return players;
	}

	public void updatePlayers(Long id,Players player) {
		player.setId(id);
		Club club = playerrepository.getReferenceById(id).getClub();
		player.setClub(club);
		playerrepository.save(player);

	}

	public void delete(Long id) {
		playerrepository.deleteById(id);
	}
	public List<Players> getPlayers(String name){
		return playerrepository.findAllByClubName(name);
	}
}
