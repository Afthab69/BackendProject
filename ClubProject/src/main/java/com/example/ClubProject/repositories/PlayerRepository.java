package com.example.ClubProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClubProject.models.Players;

public interface PlayerRepository extends JpaRepository<Players, Long>{
	public List<Players> findAllByClubName(String name);
}
