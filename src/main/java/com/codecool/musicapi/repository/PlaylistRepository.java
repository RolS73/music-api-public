package com.codecool.musicapi.repository;

import com.codecool.musicapi.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {


}
