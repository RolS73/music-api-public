package com.codecool.musicapi.model.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlaylistDTO {

    @JsonIgnore
    private Long id;
    private String playlistName;

    public PlaylistDTO(String playlistName) {
        this.playlistName = playlistName;
    }

    public PlaylistDTO(){}

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
