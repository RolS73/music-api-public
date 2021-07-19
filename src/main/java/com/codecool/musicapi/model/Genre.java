package com.codecool.musicapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
    @SequenceGenerator(name = "seqid-gen", sequenceName = "MA_IDSEQ_3" )
    @JsonIgnore
    Long id;

    String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.MERGE)
    private List<Song> songList = new ArrayList<>();

    public Genre(String genreName) {
        this.name = genreName;
    }

    public Genre(){}

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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songList=" + songList +
                '}';
    }
}
