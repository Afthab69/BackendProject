package com.example.ClubProject.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ClubProject.Dto.ClubDto;
import com.example.ClubProject.Dto.PlayersDto;
import com.example.ClubProject.models.Club;
import com.example.ClubProject.models.Players;
import com.example.ClubProject.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerrepository;

	public PlayersDto getPlayer(Long id) {
		Players player =  playerrepository.findById(id).orElse(null);
		PlayersDto playerDto = new PlayersDto();
		playerDto = toDto(player);
		return playerDto;
	}

	public void setPlayer(Players newplayer) {
		playerrepository.save(newplayer);
	}

	private PlayersDto toDto(Players player) {
		PlayersDto playerDto = new PlayersDto();
		playerDto.setName(player.getName());
		playerDto.setPos(player.getPos());
		playerDto.setId(player.getId());
		playerDto.setJno(player.getJno());
		playerDto.setClub(player.getClub());
		return playerDto;
	}
	
	public List<PlayersDto> getPlayers() {
		List<Players> players = playerrepository.findAll();
		List<PlayersDto> playersDto = new ArrayList();
		players.forEach((player)->{
			playersDto.add(toDto(player));
		});
		return playersDto;
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
	public List<PlayersDto> getPlayers(String name){
		List<Players> players = playerrepository.findAllByClubName(name);
		List<PlayersDto> playerDto = new ArrayList();
		players.forEach((player)->{
			playerDto.add(toDto(player));
		});
		return playerDto;
	}
}
