package com.codecool.musicapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
    @SequenceGenerator(name = "seqid-gen", sequenceName = "MA_IDSEQ_1" )
    @JsonIgnore
    Long id;

    String name;

    @OneToMany(mappedBy="album", cascade = CascadeType.MERGE)
    private List<Song> songList = new ArrayList<>();

    public Album(String name) {
        this.name = name;
    }

    public Album() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songList=" + songList +
                '}';
    }
}
