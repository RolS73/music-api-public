package com.codecool.musicapi.repository;


import com.codecool.musicapi.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {


}
