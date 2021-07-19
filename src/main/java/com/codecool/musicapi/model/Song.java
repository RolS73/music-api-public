package com.codecool.musicapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
    @SequenceGenerator(name = "seqid-gen", sequenceName = "MA_IDSEQ_5" )
    @JsonIgnore
    Long id;

    String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "album_id", referencedColumnName = "ID")
    Album album;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "artist_id", referencedColumnName = "ID")
    Artist artist;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "playlist_id", referencedColumnName = "ID")
    Playlist playlist;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "genre_id", referencedColumnName = "ID")
    Genre genre;


    public Song(String name, Album album, Artist artist, Playlist playlist, Genre genre) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.playlist = playlist;
        this.genre = genre;
    }

    public Song() {}

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

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", album=" + album +
                ", artist=" + artist +
                ", playlist=" + playlist +
                ", genre=" + genre +
                '}';
    }
}
