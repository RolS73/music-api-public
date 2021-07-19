package com.codecool.musicapi.model.DTO;


import com.codecool.musicapi.model.Album;
import com.codecool.musicapi.model.Artist;
import com.codecool.musicapi.model.Genre;
import com.codecool.musicapi.model.Playlist;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SongDTO {

    @JsonIgnore
    private Long id;
    private String name;

    private Album album;
    private Artist artist;
    private Playlist playlist;
    private Genre genre;

    public SongDTO(String name, Album album, Artist artist, Playlist playlist, Genre genre) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.playlist = playlist;
        this.genre = genre;
    }

    public SongDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
