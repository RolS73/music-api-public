package com.codecool.musicapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
    @SequenceGenerator(name = "seqid-gen", sequenceName = "MA_IDSEQ_4" )
    @JsonIgnore
    private Long id;

    private String playlistName;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.MERGE)
    private List<Song> songList = new ArrayList<>();

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
    }

    public Playlist(){}

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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", playlistName='" + playlistName + '\'' +
                ", songList=" + songList +
                '}';
    }
}
