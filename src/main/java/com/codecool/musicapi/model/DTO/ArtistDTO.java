package com.codecool.musicapi.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;



public class ArtistDTO {

    @JsonIgnore
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public ArtistDTO(String name) {
        this.name = name;
    }

    public ArtistDTO(){}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistDTO artist = (ArtistDTO) o;
        return Objects.equals(id, artist.id) && Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
