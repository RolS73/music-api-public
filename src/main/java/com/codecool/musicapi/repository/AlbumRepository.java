package com.codecool.musicapi.repository;

import com.codecool.musicapi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {


}
