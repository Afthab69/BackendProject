package com.example.ClubProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Club {
	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="league")
	private String league;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "club")
	private List<Players> players = new ArrayList<>();

	public List<Players> getPlayers() {
		return players;
	}
	public void setPlayers(List<Players> players) {
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
}
