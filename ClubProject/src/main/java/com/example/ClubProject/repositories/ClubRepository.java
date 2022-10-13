package com.example.ClubProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.ClubProject.Dto.ClubDto;
import com.example.ClubProject.models.Club;

public interface ClubRepository extends JpaRepository<Club, String> {

}
